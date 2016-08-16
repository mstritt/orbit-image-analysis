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
package com.l2fprod.common.propertysheet;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyEditor;

import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.l2fprod.common.propertysheet.PropertySheetTableModel.Item;
import com.l2fprod.common.swing.HeaderlessColumnResizer;

/**
 * A table which allows the editing of Properties through
 * PropertyEditors. The PropertyEditors can be changed by using the
 * PropertyEditorRegistry.
 */
public class PropertySheetTable extends JTable {
  
  private static final int HOTSPOT_SIZE = 18;
  
  private static final String TREE_EXPANDED_ICON_KEY = "Tree.expandedIcon";
  private static final String TREE_COLLAPSED_ICON_KEY = "Tree.collapsedIcon";
  private static final String TABLE_BACKGROUND_COLOR_KEY = "Table.background";
  private static final String TABLE_FOREGROUND_COLOR_KEY = "Table.foreground";
  private static final String TABLE_SELECTED_BACKGROUND_COLOR_KEY = "Table.selectionBackground";
  private static final String TABLE_SELECTED_FOREGROUND_COLOR_KEY = "Table.selectionForeground";
  private static final String PANEL_BACKGROUND_COLOR_KEY = "Panel.background";

  private PropertyEditorFactory editorFactory;
  private PropertyRendererFactory rendererFactory;

  private TableCellRenderer categoryValueRenderer;
  private TableCellRenderer nameRenderer;  
  
  private boolean wantsExtraIndent = false;
  
  /**
   * Cancel editing when editing row is changed
   */
  private TableModelListener cancelEditing;

  public PropertySheetTable() {
    this(new PropertySheetTableModel());
  }

  public PropertySheetTable(PropertySheetTableModel dm) {
    super(dm);
    addMouseListener(new CategoryVisibilityToggle());

    setGridColor(UIManager.getColor(PANEL_BACKGROUND_COLOR_KEY));
    
    // select only one property at a time
    getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    // hide the table header, we do not need it
    Dimension nullSize = new Dimension(0, 0);
    getTableHeader().setPreferredSize(nullSize);
    getTableHeader().setMinimumSize(nullSize);
    getTableHeader().setMaximumSize(nullSize);
    getTableHeader().setVisible(false);

    // table header not being visible, make sure we can still resize the columns
    new HeaderlessColumnResizer(this);

    // default renderers and editors
    setRendererFactory(new PropertyRendererRegistry());
    setEditorFactory(new PropertyEditorRegistry());
    
    categoryValueRenderer = new CategoryValueRenderer();
    nameRenderer = new NameRenderer();
    
    // force the JTable to commit the edit when it losts focus
    putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
  }

  public void setEditorFactory(PropertyEditorFactory factory) {
    editorFactory = factory;
  }

  public final PropertyEditorFactory getEditorFactory() {
    return editorFactory;
  }

  /**
   * @param registry
   * @deprecated use {@link #setEditorFactory(PropertyEditorFactory)}
   */
  public void setEditorRegistry(PropertyEditorRegistry registry) {
    setEditorFactory(registry);
  }

  /**
   * @deprecated use {@link #getEditorFactory()}
   * @throws ClassCastException if the current editor factory is not a
   *           PropertyEditorRegistry
   */
  public PropertyEditorRegistry getEditorRegistry() {
    return (PropertyEditorRegistry) editorFactory;
  }

  public void setRendererFactory(PropertyRendererFactory factory) {
    rendererFactory = factory;
  }

  public PropertyRendererFactory getRendererFactory() {
    return rendererFactory;
  }

  /**
   * @deprecated use {@link #setRendererFactory(PropertyRendererFactory)}
   * @param registry
   */
  public void setRendererRegistry(PropertyRendererRegistry registry) {
    setRendererFactory(registry);
  }

  /**
   * @deprecated use {@link #getRendererFactory()}
   * @throws ClassCastException if the current renderer factory is not a
   *           PropertyRendererRegistry
   */
  public PropertyRendererRegistry getRendererRegistry() {
    return (PropertyRendererRegistry) getRendererFactory();
  }

  /* (non-Javadoc)
   * @see javax.swing.JTable#isCellEditable(int, int)
   */
  public boolean isCellEditable(int row, int column) {
    // names are not editable
    if (column == 0) { return false; }

    PropertySheetTableModel.Item item = getSheetModel().getPropertySheetElement(row);
    return item.isProperty() && item.getProperty().isEditable();
  }

  /**
   * Gets the CellEditor for the given row and column. It uses the
   * editor registry to find a suitable editor for the property.
   * @see javax.swing.JTable#getCellEditor(int, int)
   */
  public TableCellEditor getCellEditor(int row, int column) {
    if (column == 0) { return null; }

    Item item = getSheetModel().getPropertySheetElement(row);
    if (!item.isProperty())
      return null;
    
    TableCellEditor result = null;
    Property propery = item.getProperty();
    PropertyEditor editor = getEditorFactory().createPropertyEditor(propery);
    if (editor != null)
      result = new CellEditorAdapter(editor);

    return result;
  }

  /* (non-Javadoc)
   * @see javax.swing.JTable#getCellRenderer(int, int)
   */
  public TableCellRenderer getCellRenderer(int row, int column) {
    PropertySheetTableModel model = (PropertySheetTableModel) getModel();
    PropertySheetTableModel.Item item = model.getPropertySheetElement(row);

    switch (column) {
      case PropertySheetTableModel.NAME_COLUMN:
        // name column gets a custom renderer
        return nameRenderer;

      case PropertySheetTableModel.VALUE_COLUMN: {
        if (!item.isProperty())
          return categoryValueRenderer;

        // property value column gets the renderer from the factory, but wrapped
        Property property = item.getProperty();
        TableCellRenderer renderer = getRendererFactory().createTableCellRenderer(property);
        if (renderer == null)
          renderer = getCellRenderer(property.getType());
        return new WrappedRenderer(renderer);
      }
      default:
        // when will this happen, given the above?
        return super.getCellRenderer(row, column);
    }
  }

  /**
   * Helper method to lookup a cell renderer based on type.
   * @param type the type for which a renderer should be found
   * @return a renderer for the given object type
   */
  private TableCellRenderer getCellRenderer(Class type) {
    // try to create one from the factory
    TableCellRenderer renderer = getRendererFactory().createTableCellRenderer(type);

    // if that fails, recursively try again with the superclass
    if (renderer == null && type != null)
      renderer = getCellRenderer(type.getSuperclass());

    // if that fails, just use the default Object renderer
    if (renderer == null)
      renderer = super.getDefaultRenderer(Object.class);

    return renderer;
  }

  public final PropertySheetTableModel getSheetModel() {
    return (PropertySheetTableModel) getModel();
  }

  /**
   * Overriden to register a listener on the model. This listener
   * ensures editing is cancelled when editing row is being changed.
   * 
   * @see javax.swing.JTable#setModel(javax.swing.table.TableModel)
   * @throws IllegalArgumentException if dataModel is not a
   *           {@link PropertySheetTableModel}
   */
  public void setModel(TableModel newModel) {
    if (!(newModel instanceof PropertySheetTableModel)) {
      throw new IllegalArgumentException("dataModel must be of type "
          + PropertySheetTableModel.class.getName());
    }

    if (cancelEditing == null) {
      cancelEditing = new CancelEditing();
    }

    TableModel oldModel = getModel();
    if (oldModel != null) {
      oldModel.removeTableModelListener(cancelEditing);
    }
    super.setModel(newModel);
    newModel.addTableModelListener(cancelEditing);

    // ensure the "value" column can not be resized
    getColumnModel().getColumn(1).setResizable(false);
  }

  /**
   * @see #setWantsExtraIndent(boolean)
   */
  public boolean getWantsExtraIndent() {
    return wantsExtraIndent;
  }

  /**
   * By default, properties with children are painted with the same indent level
   * as other properties and categories. When nested properties exist within the
   * set of properties, the end-user might be confused by the category and
   * property handles. Sets this property to true to add an extra indent level
   * to properties.
   * 
   * @param wantsExtraIndent
   */
  public void setWantsExtraIndent(boolean wantsExtraIndent) {
    this.wantsExtraIndent = wantsExtraIndent;
    repaint();
  }
  
  /**
   * Ensures the table uses the full height of its parent
   * {@link javax.swing.JViewport}.
   */
  public boolean getScrollableTracksViewportHeight() {
    return getPreferredSize().height < getParent().getHeight();
  }
  
  /**
   * Commits on-going cell editing 
   */
  public void commitEditing() {
    TableCellEditor editor = getCellEditor();
    if (editor != null) {
      editor.stopCellEditing();
    }    
  }

  /**
   * Cancels on-going cell editing 
   */
  public void cancelEditing() {
    TableCellEditor editor = getCellEditor();
    if (editor != null) {
      editor.cancelCellEditing();
    }    
  }

  private class CancelEditing implements TableModelListener {
    public void tableChanged(TableModelEvent e) {
      // in case the table changes for the following reasons:
      // * the editing row has changed
      // * the editing row was removed
      // * all rows were changed
      // * rows were added
      //
      // it is better to cancel the editing of the row as our editor
      // may no longer be the right one. It happens when you play with
      // the sorting while having the focus in one editor.
      if (e.getType() == TableModelEvent.UPDATE) {
        int first = e.getFirstRow();
        int last = e.getLastRow();
        int editingRow = PropertySheetTable.this.getEditingRow();

        TableCellEditor editor = PropertySheetTable.this.getCellEditor();
        if (editor != null && first <= editingRow && editingRow <= last) {
          editor.cancelCellEditing();
        }
      }
    }
  }

  private static class CategoryVisibilityToggle extends MouseAdapter {
    public void mouseReleased(MouseEvent event) {
      PropertySheetTable table = (PropertySheetTable) event.getComponent();
      int row = table.rowAtPoint(event.getPoint());
      int column = table.columnAtPoint(event.getPoint());
      if (row != -1 && column == 0) {
        // if we clicked on an Item, see if we clicked on its hotspot
        Item item = table.getSheetModel().getPropertySheetElement(row);        
        int x = event.getX() - getIndent(table, item);
        if (x > 0 && x < HOTSPOT_SIZE)
          item.toggle();
      }
    }
  }

  static int getIndent(PropertySheetTable table, Item item) {
    int indent = 0;
    
    if (item.isProperty()) {
      // it is a property, it has no parent or a category, and no child
      if ((item.getParent() == null || !item.getParent().isProperty())
        && !item.hasToggle()) {
        indent = table.getWantsExtraIndent()?HOTSPOT_SIZE:0;
      } else {
        // it is a property with children
        if (item.hasToggle()) {
          indent = item.getDepth() * HOTSPOT_SIZE;
        } else {          
          indent = (item.getDepth() + 1) * HOTSPOT_SIZE;
        }        
      }
      
      if (table.getSheetModel().getMode() == PropertySheet.VIEW_AS_CATEGORIES
        && table.getWantsExtraIndent()) {
        indent += HOTSPOT_SIZE;
      }

    } else {
      // category has no indent
      indent = 0;
    }    
    return indent;
  }
  
  private static class CellBorder implements Border {
    
    private Color background = UIManager.getColor(PANEL_BACKGROUND_COLOR_KEY);
    private int indentWidth; // space before hotspot
    private boolean showToggle;
    private boolean toggleState;
    private Icon expandedIcon = (Icon) UIManager.get(TREE_EXPANDED_ICON_KEY);
    private Icon collapsedIcon = (Icon) UIManager.get(TREE_COLLAPSED_ICON_KEY);
    private Insets insets = new Insets(1, 0, 1, 1);
    private boolean isProperty;
    
    public void configure(PropertySheetTable table, Item item) {      
      isProperty = item.isProperty();      
      toggleState =  item.isVisible();
      showToggle = item.hasToggle();
      
      indentWidth = getIndent(table, item);      
      insets.left = indentWidth + (showToggle?HOTSPOT_SIZE:0) + 2;;
    }
    
    public Insets getBorderInsets(Component c) {
      return insets;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width,
        int height) {      
      if (!isProperty) {
        Color oldColor = g.getColor();      
        g.setColor(background);
        g.fillRect(x, y, x + HOTSPOT_SIZE - 2, y + height);
        g.setColor(oldColor);
      }
      
      if (showToggle) {
        Icon drawIcon = (toggleState ? expandedIcon : collapsedIcon);
        drawIcon.paintIcon(c, g,
          x + indentWidth + (HOTSPOT_SIZE - 2 - drawIcon.getIconWidth()) / 2,
          y + (height - drawIcon.getIconHeight()) / 2);
      }
    }

    public boolean isBorderOpaque() {
      return true;
    }
    
  }

  /**
   * A {@link TableCellRenderer} for property names.
   */
  private static class NameRenderer extends DefaultTableCellRenderer {
    
    private Color background;
    private Color foreground;
    private Color propertyBackground;
    private Color propertyForeground;
    private Color selectedBackground;
    private Color selectedForeground;
    private CellBorder border;
    
    public NameRenderer() {
      this(UIManager.getColor(PANEL_BACKGROUND_COLOR_KEY), UIManager.getColor(
          PANEL_BACKGROUND_COLOR_KEY).darker());
    }

    public NameRenderer(Color background, Color foreground) {
      this.background = background;
      this.foreground = foreground;
      this.propertyBackground = UIManager.getColor(TABLE_BACKGROUND_COLOR_KEY);
      this.propertyForeground = UIManager.getColor(TABLE_FOREGROUND_COLOR_KEY);
      this.selectedBackground = UIManager.getColor(TABLE_SELECTED_BACKGROUND_COLOR_KEY);
      this.selectedForeground = UIManager.getColor(TABLE_SELECTED_FOREGROUND_COLOR_KEY);
      border = new CellBorder();
    }
    
    private Color getForeground(boolean isProperty, boolean isSelected) {
      return (isProperty ? (isSelected ? selectedForeground : propertyForeground) : foreground);
    }

    private Color getBackground(boolean isProperty, boolean isSelected) {
      return (isProperty ? (isSelected ? selectedBackground : propertyBackground) : background);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
      super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
      setBorder(border);

      PropertySheetTableModel.Item item = (Item) value;
      // configure the border
      border.configure((PropertySheetTable)table, item);
      
      setBackground(getBackground(item.isProperty(), isSelected));
      setForeground(getForeground(item.isProperty(), isSelected));
      
      setEnabled(isSelected || !item.isProperty() ? true : item.getProperty().isEditable());
      setFont(getFont().deriveFont(item.isProperty() ? Font.PLAIN : Font.BOLD));
      setText(item.getName());

      return this;
    }
  }

  private static class WrappedRenderer implements TableCellRenderer {
    private TableCellRenderer renderer;

    public WrappedRenderer(TableCellRenderer renderer) {
      this.renderer = renderer;
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
      return renderer.getTableCellRendererComponent(table, value, false, false,
          row, column);
    }
  }

  private static class CategoryValueRenderer extends DefaultTableCellRenderer {
    private Color background;
    private Color foreground;

    public CategoryValueRenderer() {
      this(UIManager.getColor(PANEL_BACKGROUND_COLOR_KEY), UIManager.getColor(
          PANEL_BACKGROUND_COLOR_KEY).darker().darker().darker());
    }

    public CategoryValueRenderer(Color background, Color foreground) {
      this.background = background;
      this.foreground = foreground;
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
      setBackground(background);
      setForeground(foreground);
      setText("");
      return this;
    }
  }

}