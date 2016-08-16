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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.l2fprod.common.propertysheet.DefaultProperty;
import com.l2fprod.common.propertysheet.Property;
import com.l2fprod.common.propertysheet.PropertySheet;
import com.l2fprod.common.propertysheet.PropertySheetPanel;
import com.l2fprod.common.swing.LookAndFeelTweaks;
import com.l2fprod.common.util.ResourceManager;

public class PropertySheetPage3 extends JPanel
{
	private static final Class THIS_CLASS = PropertySheetPage3.class;
	static ResourceManager RESOURCE = ResourceManager.get( THIS_CLASS );
	
	public PropertySheetPage3()
	{
		setLayout( LookAndFeelTweaks.createVerticalPercentLayout() );

		JTextArea message = new JTextArea();
		message.setText( PropertySheetMain.RESOURCE.getString( "Main.sheet1.message" ) );
		LookAndFeelTweaks.makeMultilineLabel( message );
		add( message );

		final Colorful data = new Colorful();
		data.setColor( new Color( 255, 153, 102 ) );

        DefaultProperty level0 = new NoReadWriteProperty();
        level0.setDisplayName("Level 0");
        level0.setCategory("A category");
        DefaultProperty level1 = new NoReadWriteProperty();
        level1.setDisplayName("Level 1");
        level1.setCategory("Another category");
        level0.addSubProperty(level1);
        DefaultProperty level2 = new NoReadWriteProperty();
        level2.setDisplayName("Level 2");
        level1.addSubProperty(level2);
        DefaultProperty level21 = new NoReadWriteProperty();
        level21.setDisplayName("Level 3");
        level1.addSubProperty(level21);

        DefaultProperty level211 = new NoReadWriteProperty();
        level211.setDisplayName("Level 3.1");
        level21.addSubProperty(level211);

        DefaultProperty root = new NoReadWriteProperty();
        root.setDisplayName("Root");
        
        final PropertySheetPanel sheet = new PropertySheetPanel();
		sheet.setMode( PropertySheet.VIEW_AS_FLAT_LIST );
		sheet.setProperties( new Property[] { new ColorProperty(), level0, root } );
		sheet.readFromObject( data );
		sheet.setDescriptionVisible( true );
		sheet.setSortingCategories( true );
		sheet.setSortingProperties( true );
		add( sheet, "*" );
        
		// everytime a property change, update the button with it
		PropertyChangeListener listener = new PropertyChangeListener() {
			public void propertyChange( PropertyChangeEvent evt )
			{
				Property prop = (Property) evt.getSource();
				prop.writeToObject( data );
				System.out.println( "Updated object to " + data );
			}
		};
		sheet.addPropertySheetChangeListener( listener );
        
        JButton button = new JButton(new AbstractAction("Click to setWantsExtraIndent(true)") {
          public void actionPerformed(ActionEvent e) {
            sheet.getTable().setWantsExtraIndent(!sheet.getTable().getWantsExtraIndent());
            putValue(NAME, "Click to setWantsExtraIndent(" + !sheet.getTable().getWantsExtraIndent() + ")");
          }
        });
        add(button);
	}

    static class NoReadWriteProperty extends DefaultProperty {
      public void readFromObject(Object object) {
      }
      public void writeToObject(Object object) {
      }
    }
    
	public static class Colorful
	{
		private Color color;

		public Color getColor()
		{
			return color;
		}
		
		public void setColor( Color color )
		{
			this.color = color;
		}

		public int getRed()
		{
			return color.getRed();
		}
		
		public void setRed( int red )
		{
			color = new Color( red, getGreen(), getBlue() );
		}
		
		public int getGreen()
		{
			return color.getGreen();
		}
		
		public void setGreen( int green )
		{
			color = new Color( getRed(), green, getBlue() );
		}
		
		public int getBlue()
		{
			return color.getBlue();
		}
		
		public void setBlue( int blue )
		{
			color = new Color( getRed(), getGreen(), blue );
		}
		
		public String toString()
		{
			return color.toString();
		}
	}

	public static class ColorProperty extends DefaultProperty
	{
		public ColorProperty()
		{
			setName( "color" );
			setCategory( RESOURCE.getString( "color.cat" ) );
			setDisplayName( RESOURCE.getString( "color.name" ) );
			setShortDescription( RESOURCE.getString( "color.desc" ) );
			setType( Color.class );
			
			addSubProperty( new ColorComponentProperty( "red" ) );
			addSubProperty( new ColorComponentProperty( "green" ) );
			addSubProperty( new ColorComponentProperty( "blue" ) );
		}
	}
	
	public static class ColorComponentProperty extends DefaultProperty
	{
		public ColorComponentProperty( String name )
		{
			setName( name );
			setDisplayName( RESOURCE.getString( name + ".name" ) );
			setShortDescription( RESOURCE.getString( name  + ".desc" ) );
			setType( int.class );
		}
	}
}