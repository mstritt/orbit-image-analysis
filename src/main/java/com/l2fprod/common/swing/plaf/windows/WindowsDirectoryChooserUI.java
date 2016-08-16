/**
 * $ $ License.
 *
 * Copyright $ L2FProd.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.l2fprod.common.swing.plaf.windows;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileView;
import javax.swing.plaf.basic.BasicFileChooserUI;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.l2fprod.common.swing.JDirectoryChooser;
import com.l2fprod.common.swing.LookAndFeelTweaks;
import com.l2fprod.common.swing.plaf.DirectoryChooserUI;
import com.l2fprod.common.swing.tree.LazyMutableTreeNode;
import com.l2fprod.common.util.OS;
import com.l2fprod.common.util.ResourceManager;

/**
 * WindowsDirectoryChooserUI. <br>
 *  
 */
public class WindowsDirectoryChooserUI
  extends BasicFileChooserUI
  implements DirectoryChooserUI {

  private static Queue nodeQueue;

  private JDirectoryChooser chooser;
  private JTextComponent message;
  private JTree tree;
  private JScrollPane treeScroll;
  private JButton approveButton;
  private JButton cancelButton;
  private JPanel buttonPanel;
  private BasicFileView fileView = new WindowsFileView();
  private Action approveSelectionAction = new ApproveSelectionAction();
  private boolean useNodeQueue;

  public WindowsDirectoryChooserUI(JDirectoryChooser chooser) {
    super(chooser);
  }

  public void rescanCurrentDirectory(JFileChooser fc) {
    super.rescanCurrentDirectory(fc);
    findFile(
      chooser.getSelectedFile() == null
        ? chooser.getCurrentDirectory()
        : chooser.getSelectedFile(),
      true,
      true);
  }

  public void ensureFileIsVisible(JFileChooser fc, File f) {
    super.ensureFileIsVisible(fc, f);
    findFile(f, false, false);
  }

  protected String getToolTipText(MouseEvent event) {
    TreePath path = tree.getPathForLocation(event.getX(), event.getY());
    if (path != null && path.getLastPathComponent() instanceof FileTreeNode) {
      FileTreeNode node = (FileTreeNode)path.getLastPathComponent();
      String typeDescription =
        getFileView(chooser).getTypeDescription(node.getFile());
      if (typeDescription == null || typeDescription.length() == 0) {
        return node.toString();
      } else {
        return node.toString() + " - " + typeDescription;
      }
    } else {
      return null;
    }
  }

  public void installComponents(JFileChooser chooser) {
    this.chooser = (JDirectoryChooser)chooser;

    chooser.setLayout(LookAndFeelTweaks.createBorderLayout());
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

    Component accessory = chooser.getAccessory();
    if (accessory != null) {
      chooser.add("North", chooser.getAccessory());
    }

    tree = new JTree() {
      public String getToolTipText(MouseEvent event) {
        String tip = WindowsDirectoryChooserUI.this.getToolTipText(event);
        if (tip == null) {
          return super.getToolTipText(event);
        } else {
          return tip;
        }
      }
    };
    tree.addTreeExpansionListener(new TreeExpansion());

    tree.setModel(new FileSystemTreeModel(chooser.getFileSystemView()));
    tree.setRootVisible(false);
    tree.setShowsRootHandles(false);
    tree.setCellRenderer(new FileSystemTreeRenderer());
    tree.setToolTipText("");

    chooser.add("Center", treeScroll = new JScrollPane(tree));
    treeScroll.setPreferredSize(new Dimension(300, 300));

    approveButton = new JButton();
    approveButton.setAction(getApproveSelectionAction());

    cancelButton = new JButton();
    cancelButton.addActionListener(getCancelSelectionAction());

    buttonPanel = new JPanel(LookAndFeelTweaks.createButtonAreaLayout());
    buttonPanel.add(approveButton);
    buttonPanel.add(cancelButton);
    chooser.add("South", buttonPanel);

    updateView(chooser);
  }

  protected void installStrings(JFileChooser fc) {
    super.installStrings(fc);

    saveButtonToolTipText =
      ResourceManager.get(DirectoryChooserUI.class).getString(
        "DirectoryChooser.saveButtonToolTipText");
    openButtonToolTipText =
      ResourceManager.get(DirectoryChooserUI.class).getString(
        "DirectoryChooser.openButtonToolTipText");
    cancelButtonToolTipText =
      ResourceManager.get(DirectoryChooserUI.class).getString(
        "DirectoryChooser.cancelButtonToolTipText");
  }

  public void uninstallComponents(JFileChooser chooser) {
    chooser.remove(message);
    chooser.remove(treeScroll);
    chooser.remove(buttonPanel);
  }

  public FileView getFileView(JFileChooser fc) {
    return fileView;
  }

  protected void installListeners(JFileChooser fc) {
    super.installListeners(fc);

    tree.addTreeSelectionListener(new SelectionListener());
  }

  protected void uninstallListeners(JFileChooser fc) {
    super.uninstallListeners(fc);
  }

  public PropertyChangeListener createPropertyChangeListener(JFileChooser fc) {
    return new ChangeListener();
  }

  private void updateView(JFileChooser chooser) {
    if (chooser.getApproveButtonText() != null) {
      approveButton.setText(chooser.getApproveButtonText());
      approveButton.setMnemonic(chooser.getApproveButtonMnemonic());
    } else {
      if (JFileChooser.OPEN_DIALOG == chooser.getDialogType()) {
        approveButton.setText(openButtonText);
        approveButton.setToolTipText(openButtonToolTipText);
        approveButton.setMnemonic(openButtonMnemonic);
      } else {
        approveButton.setText(saveButtonText);
        approveButton.setToolTipText(saveButtonToolTipText);
        approveButton.setMnemonic(saveButtonMnemonic);
      }
    }

    cancelButton.setText(cancelButtonText);
    cancelButton.setMnemonic(cancelButtonMnemonic);

    buttonPanel.setVisible(chooser.getControlButtonsAreShown());
  }

  /**
   * Ensures the file is visible, tree expanded and optionally selected
   * 
   * @param fileToLocate
   * @param selectFile
   */
  private void findFile(
    File fileToLocate,
    boolean selectFile,
    boolean reload) {
    if (fileToLocate == null || !fileToLocate.isDirectory()) {
      return;
    }

    // build the canonical path so we can navigate the tree model to find the
    // node
    File file = null;
    try {
      file = fileToLocate.getCanonicalFile();
    } catch (Exception e) {
      return;
    }

    // temporarly disable loading nodes in the background
    useNodeQueue = false;
    try {
      // split the full path into individual files to locate them in the tree
      // model
      List files = new ArrayList();
      files.add(file);
      while ((file = chooser.getFileSystemView().getParentDirectory(file))
        != null) {
        files.add(0, file);
      }

      List path = new ArrayList();

      // start from the root
      DefaultMutableTreeNode node =
        (DefaultMutableTreeNode)tree.getModel().getRoot();
      path.add(node);

      DefaultMutableTreeNode current;

      boolean found = true;

      // ...and go through the tree model to find the files. Stop as soon as
      // path is completely found or if one of the files in the path is not
      // found.
      while (files.size() > 0 && found) {
        found = false;
        for (int i = 0, c = node.getChildCount(); i < c; i++) {
          current = (DefaultMutableTreeNode)node.getChildAt(i);
          File f = ((FileTreeNode)current).getFile();
          if (files.get(0).equals(f)) {
            path.add(current);
            files.remove(0);
            node = current;
            found = true;
            break;
          }
        }
      }

      // select the path we found, it may be the file we were looking for or a
      // subpath only
      TreePath pathToSelect = new TreePath(path.toArray());
      if (pathToSelect.getLastPathComponent() instanceof FileTreeNode
        && reload) {
        ((FileTreeNode) (pathToSelect.getLastPathComponent())).clear();
      }

      if (selectFile) {
        tree.expandPath(pathToSelect);
        tree.setSelectionPath(pathToSelect);
      }

      tree.scrollPathToVisible(pathToSelect);

    } finally {
      // re-enable background loading
      useNodeQueue = true;
    }
  }

  private class ChangeListener implements PropertyChangeListener {
    public void propertyChange(PropertyChangeEvent evt) {
      if (JFileChooser
        .APPROVE_BUTTON_TEXT_CHANGED_PROPERTY
        .equals(evt.getPropertyName())) {
        updateView(chooser);
      }

      if (JFileChooser
        .MULTI_SELECTION_ENABLED_CHANGED_PROPERTY
        .equals(evt.getPropertyName())) {
        if (chooser.isMultiSelectionEnabled()) {
          tree.getSelectionModel().setSelectionMode(
            TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
        } else {
          tree.getSelectionModel().setSelectionMode(
            TreeSelectionModel.SINGLE_TREE_SELECTION);
        }
      }

      if (JFileChooser
        .DIRECTORY_CHANGED_PROPERTY
        .equals(evt.getPropertyName())) {
        findFile(chooser.getCurrentDirectory(), false, false);
      }

      if (JFileChooser
        .ACCESSORY_CHANGED_PROPERTY
        .equals(evt.getPropertyName())) {
        Component oldValue = (Component)evt.getOldValue();
        Component newValue = (Component)evt.getNewValue();
        if (oldValue != null) {
          chooser.remove(oldValue);
        }
        if (newValue != null) {
          chooser.add("North", newValue);
        }
        chooser.revalidate();
        chooser.repaint();
      }

      if (JFileChooser
        .CONTROL_BUTTONS_ARE_SHOWN_CHANGED_PROPERTY
        .equals(evt.getPropertyName())) {
        updateView(chooser);
      }
    }
  }

  private class SelectionListener implements TreeSelectionListener {
    public void valueChanged(TreeSelectionEvent e) {
      getApproveSelectionAction().setEnabled(tree.getSelectionCount() > 0);
      setSelectedFiles();
    }
  }

  public Action getApproveSelectionAction() {
    return approveSelectionAction;
  }

  private void setSelectedFiles() {
    TreePath[] selectedPaths = tree.getSelectionPaths();
    if (selectedPaths == null || selectedPaths.length == 0) {
      chooser.setSelectedFile(null);
      return;
    }

    List files = new ArrayList();
    for (int i = 0, c = selectedPaths.length; i < c; i++) {
      File f =
        ((FileTreeNode)selectedPaths[i].getLastPathComponent()).getFile();
      files.add(f);
    }

    chooser.setSelectedFiles((File[])files.toArray(new File[0]));
  }

  private class ApproveSelectionAction extends AbstractAction {
    public ApproveSelectionAction() {
      setEnabled(false);
    }
    public void actionPerformed(ActionEvent e) {
      setSelectedFiles();
      chooser.approveSelection();
    }
  }

  /**
   * Listens on nodes being opened and preload their children to get better UI
   * experience (GUI should be more responsive and empty nodes discovered
   * automatically).
   */
  private class TreeExpansion implements TreeExpansionListener {
    public void treeCollapsed(TreeExpansionEvent event) {
    }
    public void treeExpanded(TreeExpansionEvent event) {
      // ensure children gets expanded later
      if (event.getPath() != null) {
        Object lastElement = event.getPath().getLastPathComponent();
        if (lastElement instanceof FileTreeNode && useNodeQueue) {
          if (((FileTreeNode)lastElement).isLoaded()) {
            for (Enumeration e = ((FileTreeNode)lastElement).children();
              e.hasMoreElements();
              ) {
              //Object node = enum.nextElement();
              addToQueue((FileTreeNode)e.nextElement(), tree);
            }
          }
        }
      }
    }
  }

  private class FileSystemTreeRenderer extends DefaultTreeCellRenderer {
    public Component getTreeCellRendererComponent(
      JTree tree,
      Object value,
      boolean sel,
      boolean expanded,
      boolean leaf,
      int row,
      boolean hasFocus) {
      super.getTreeCellRendererComponent(tree, value, sel, expanded, false,
      // even "leaf" folders should look like other folders
      row, hasFocus);

      if (value instanceof FileTreeNode) {
        FileTreeNode node = (FileTreeNode)value;
        setText(getFileView(chooser).getName(node.getFile()));
        if (OS.isMacOSX()
          && UIManager.getLookAndFeel().isNativeLookAndFeel()) {
          // do not set icon for MacOSX when native look is used, it seems the
          // Tree.icons set by the
          // look and feel are not that good or Apple is doing something I
          // can't figure.
          // setIcon only if not running in MacOSX
        } else {
          setIcon(getFileView(chooser).getIcon(node.getFile()));
        }
      }

      return this;
    }
  }

  private class FileSystemTreeModel extends DefaultTreeModel {
    public FileSystemTreeModel(FileSystemView fsv) {
      super(new MyComputerTreeNode(fsv), false);
    }
  }

  private class MyComputerTreeNode extends LazyMutableTreeNode {
    public MyComputerTreeNode(FileSystemView fsv) {
      super(fsv);
    }
    protected void loadChildren() {
      FileSystemView fsv = (FileSystemView)getUserObject();
      File[] roots = fsv.getRoots();
      if (roots != null) {
        Arrays.sort(roots);
        for (int i = 0, c = roots.length; i < c; i++) {
          add(new FileTreeNode(roots[i]));
        }
      }
    }
    public String toString() {
      return "/";
    }
  }

  private class FileTreeNode
    extends LazyMutableTreeNode
    implements Comparable {
    public FileTreeNode(File file) {
      super(file);
    }
    public boolean canEnqueue() {
      return !isLoaded()
        && !chooser.getFileSystemView().isFloppyDrive(getFile())
        && !chooser.getFileSystemView().isFileSystemRoot(getFile());
    }
    public boolean isLeaf() {
      if (!isLoaded()) {
        return false;
      } else {
        return super.isLeaf();
      }
    }
    protected void loadChildren() {
      FileTreeNode[] nodes = getChildren();
      for (int i = 0, c = nodes.length; i < c; i++) {
        add(nodes[i]);
      }
    }
    private FileTreeNode[] getChildren() {
      File[] files =
        chooser.getFileSystemView().getFiles(
          getFile(),
          chooser.isFileHidingEnabled());
      ArrayList nodes = new ArrayList();
      // keep only directories, no "file" in the tree.
      if (files != null) {
        for (int i = 0, c = files.length; i < c; i++) {
          if (files[i].isDirectory()) {
            nodes.add(new FileTreeNode(files[i]));
          }
        }
      }
      // sort directories, FileTreeNode implements Comparable
      FileTreeNode[] result =
        (FileTreeNode[])nodes.toArray(new FileTreeNode[0]);
      Arrays.sort(result);
      return result;
    }
    public File getFile() {
      return (File)getUserObject();
    }
    public String toString() {
      return chooser.getFileSystemView().getSystemDisplayName(
        (File)getUserObject());
    }
    public int compareTo(Object o) {
      if (!(o instanceof FileTreeNode)) {
        return 1;
      }
      return getFile().compareTo(((FileTreeNode)o).getFile());
    }
    public void clear() {
      super.clear();
      ((DefaultTreeModel)tree.getModel()).nodeStructureChanged(this);
    }
  }

  /**
   * From WindowsFileChooserUI
   */
  protected class WindowsFileView extends BasicFileView {
    public Icon getIcon(File f) {
      Icon icon = getCachedIcon(f);
      if (icon != null) {
        return icon;
      }
      if (f != null) {
        icon = getFileChooser().getFileSystemView().getSystemIcon(f);
      }
      if (icon == null) {
        icon = super.getIcon(f);
      }
      cacheIcon(f, icon);
      return icon;
    }
  }

  private static synchronized void addToQueue(FileTreeNode node, JTree tree) {
    if (nodeQueue == null || !nodeQueue.isAlive()) {
      nodeQueue = new Queue();
      nodeQueue.start();
    }
    if (node.canEnqueue()) {
      nodeQueue.add(node, tree);
    }
  }

  /**
   * This queue takes care of loading nodes in the background.
   */
  private static final class Queue extends Thread {

    private volatile Stack nodes = new Stack();
    private Object lock = new Object();
    private volatile boolean running = true;

    public Queue() {
      super("DirectoryChooser-BackgroundLoader");
      setDaemon(true);
    }

    public void add(WindowsDirectoryChooserUI.FileTreeNode node, JTree tree) {
      if (!isAlive()) {
        throw new IllegalArgumentException("Queue is no longer alive");
      }

      synchronized (lock) {
        if (running) {
          nodes.addElement(new QueueItem(node, tree));
          lock.notifyAll();
        }
      }
    }

    public void run() {
      while (running) {
        while (nodes.size() > 0) {
          final QueueItem item = (QueueItem)nodes.pop();
          final WindowsDirectoryChooserUI.FileTreeNode node = item.node;
          final JTree tree = item.tree;

          // ask how many items we got
          node.getChildCount();

          Runnable runnable = new Runnable() {
            public void run() {
              ((DefaultTreeModel)tree.getModel()).nodeChanged(node);
              tree.repaint();
            }
          };
          try {
            SwingUtilities.invokeAndWait(runnable);
          } catch (InterruptedException e) {
            e.printStackTrace();
          } catch (InvocationTargetException e) {
            e.printStackTrace();
          }
        }

        // wait for 5 seconds for someone to use the queue, else just ends this
        // queue
        try {
          synchronized (lock) {
            lock.wait(5000);
          }

          if (nodes.size() == 0) {
            running = false;
          }

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * An entry in the queue.
   */
  private static final class QueueItem {
    WindowsDirectoryChooserUI.FileTreeNode node;
    JTree tree;
    public QueueItem(WindowsDirectoryChooserUI.FileTreeNode node, JTree tree) {
      this.node = node;
      this.tree = tree;
    }
  }

}
