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
package com.l2fprod.common.demo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;

/**
 * A File System view which permits to show the DirectoryChooser even
 * in Java Web Start. It circumvents all security exceptions.
 */
public class FakeFileSystemView extends FileSystemView {

  private Map files = new HashMap();

  public FakeFileSystemView() {
    files.put("desktop", new FakeFile("Desktop"));
    files.put("computer", new FakeFile("My Computer"));
    files.put("A", new FakeFile("A"));
    files.put("C", new FakeFile("C"));
    files.put("D", new FakeFile("D"));
    files.put("getFiles(My Computer)", new File[] {(File)files.get("A"),
      (File)files.get("C"), (File)files.get("D")});
    files.put("network", new FakeFile("My Network Places"));
    files.put("getRoots", new File[] {(File)files.get("desktop")});
    files.put("getFiles(Desktop)", new File[] {(File)files.get("computer"),
      (File)files.get("network")});

    FakeFile[] folders = new FakeFile[] {new FakeFile("Folder 1"),
      new FakeFile("Folder 2"), new FakeFile("Folder 3"),};
    files.put("getFiles(C)", folders);
    files.put("getFiles(D)", folders);
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#createNewFolder(java.io.File)
   */
  public File createNewFolder(File containingDir) {
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#createFileObject(java.io.File,
   *      java.lang.String)
   */
  public File createFileObject(File dir, String filename) {
    return super.createFileObject(dir, filename);
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#createFileObject(java.lang.String)
   */
  public File createFileObject(String path) {
    return super.createFileObject(path);
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#createFileSystemRoot(java.io.File)
   */
  protected File createFileSystemRoot(File f) {
    return super.createFileSystemRoot(f);
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#getChild(java.io.File,
   *      java.lang.String)
   */
  public File getChild(File parent, String fileName) {
    return super.getChild(parent, fileName);
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#getDefaultDirectory()
   */
  public File getDefaultDirectory() {
    return new FakeFile("Default");
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#getFiles(java.io.File,
   *      boolean)
   */
  public File[] getFiles(File dir, boolean useFileHiding) {
    if (dir.getName().startsWith("Folder")) {
      return new FakeFile[] {new FakeFile(dir.getName() + ".1"),
        new FakeFile(dir.getName() + ".2"), new FakeFile(dir.getName() + ".3"),};
    } else {
      File[] children = (File[])files.get("getFiles(" + dir.getName() + ")");
      if (children == null) {
        return new File[0];
      } else {
        return children;
      }
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#getHomeDirectory()
   */
  public File getHomeDirectory() {
    return new FakeFile("Home");
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#getParentDirectory(java.io.File)
   */
  public File getParentDirectory(File dir) {
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#getRoots()
   */
  public File[] getRoots() {
    return (File[])files.get("getRoots");
  }
  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#getSystemDisplayName(java.io.File)
   */
  public String getSystemDisplayName(File f) {
    return f.getName();
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#getSystemIcon(java.io.File)
   */
  public Icon getSystemIcon(File f) {
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#getSystemTypeDescription(java.io.File)
   */
  public String getSystemTypeDescription(File f) {
    return "Description";
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#isComputerNode(java.io.File)
   */
  public boolean isComputerNode(File dir) {
    return files.get("computer") == dir;
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#isDrive(java.io.File)
   */
  public boolean isDrive(File dir) {
    return "C".equals(dir.getName()) || "D".equals(dir.getName());
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#isFileSystem(java.io.File)
   */
  public boolean isFileSystem(File f) {
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#isFileSystemRoot(java.io.File)
   */
  public boolean isFileSystemRoot(File dir) {
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#isFloppyDrive(java.io.File)
   */
  public boolean isFloppyDrive(File dir) {
    return "A".equals(dir.getName());
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#isHiddenFile(java.io.File)
   */
  public boolean isHiddenFile(File f) {
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#isParent(java.io.File,
   *      java.io.File)
   */
  public boolean isParent(File folder, File file) {
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#isRoot(java.io.File)
   */
  public boolean isRoot(File f) {
    return files.get("desktop") == f;
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.filechooser.FileSystemView#isTraversable(java.io.File)
   */
  public Boolean isTraversable(File f) {
    return Boolean.TRUE;
  }

  static class FakeFile extends File {
    public FakeFile(String s) {
      super(s);
    }
    public boolean isDirectory() {
      return true;
    }
  }
}