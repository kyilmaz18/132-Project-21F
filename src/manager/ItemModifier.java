package manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.DataFormatException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.main;
import menu.Drink;
import menu.Entree;
import menu.Item;

public class ItemModifier extends JFrame { // Modifies a Selected Item Switch statements are used to handle class spesific edits
	
	private String f;
	private JTextField name, stock, price, calories, agl, abv, st, et;
	private JButton ic, ab;
	private JLabel l;
	private int item;
	final JFileChooser fc = new JFileChooser();

	public ItemModifier(Item I) {
		
		super("Item Editor");
		ButtonHandler handler = new ButtonHandler();
		setLayout(new GridLayout(0,2));
		item = main.getMenu().indexOf(I);
		System.out.println(I.getClass().toString());
				
		switch (I.getClass().toString()) { // Builds GUI depending on the Item Subclass using switch
		
		case "class menu.Drink":
			
			l = new JLabel("Name:", JLabel.LEFT);
		    add(l);
		    name = new JTextField(main.getMenu().get(item).getName());
		    l.setLabelFor(name);
		    add(name);
		    
		    l = new JLabel("Stock:", JLabel.LEFT);
		    add(l);
		    stock = new JTextField(main.getMenu().get(item).getStock());
		    l.setLabelFor(stock);
		    add(stock);
		    
		    l = new JLabel("Price:", JLabel.LEFT);
		    add(l);
		    price = new JTextField("" + main.getMenu().get(item).getPrice());
		    l.setLabelFor(price);
		    add(price);
		    
		    l = new JLabel("Calories:", JLabel.LEFT);
		    add(l);
		    calories = new JTextField("" + main.getMenu().get(item).getCalories());
		    l.setLabelFor(calories);
		    add(calories);
		    
		    l = new JLabel("ABV%:", JLabel.LEFT);
		    add(l);
		    abv = new JTextField("" + ((Drink)main.getMenu().get(item)).getAbv());
		    l.setLabelFor(abv);
		    add(abv);
		    
		    l = new JLabel("Age Limit:", JLabel.LEFT);
		    add(l);
		    agl = new JTextField(main.getMenu().get(item).getAgeLimit());
		    l.setLabelFor(agl);
		    add(agl);
		    
		    ic = new JButton("Select Image");
		    add(ic);
			ic.addActionListener(handler);
		    
		    ab = new JButton("Add Drink");
		    add(ab); 
			ab.addActionListener(handler);
			
			break;
			
		case "menu.Entree":
			
			l = new JLabel("Name:", JLabel.LEFT);
		    add(l);
		    name = new JTextField(main.getMenu().get(item).getName());
		    l.setLabelFor(name);
		    add(name);
		    
		    l = new JLabel("Stock:", JLabel.LEFT);
		    add(l);
		    stock = new JTextField(main.getMenu().get(item).getStock());
		    l.setLabelFor(stock);
		    add(stock);
		    
		    l = new JLabel("Price:", JLabel.LEFT);
		    add(l);
		    price = new JTextField("" + main.getMenu().get(item).getPrice());
		    l.setLabelFor(price);
		    add(price);
		    
		    l = new JLabel("Calories:", JLabel.LEFT);
		    add(l);
		    calories = new JTextField("" + main.getMenu().get(item).getCalories());
		    l.setLabelFor(calories);
		    add(calories);
		    
		    l = new JLabel("Start Time:", JLabel.LEFT);
		    add(l);
		    st = new JTextField(((Entree)main.getMenu().get(item)).getStartHour() + ":" + ((Entree)main.getMenu().get(item)).getStartMin());
		    l.setLabelFor(st);
		    add(st);
		    
		    l = new JLabel("End Time:", JLabel.LEFT);
		    add(l);
		    et = new JTextField(((Entree)main.getMenu().get(item)).getEndHour() + ":" + ((Entree)main.getMenu().get(item)).getEndMin());
		    l.setLabelFor(et);
		    add(et);
		    
		    l = new JLabel("Age Limit:", JLabel.LEFT);
		    add(l);
		    agl = new JTextField(main.getMenu().get(item).getAgeLimit());
		    l.setLabelFor(agl);
		    add(agl);
		    
		    ic = new JButton("Select Image");
		    add(ic);
			ic.addActionListener(handler);
		    
		    ab = new JButton("Add Entree");
		    add(ab); 
			ab.addActionListener(handler);
			
			break;
			
		case "menu.Salad":
			
			l = new JLabel("Name:", JLabel.LEFT);
		    add(l);
		    name = new JTextField(main.getMenu().get(item).getName());
		    l.setLabelFor(name);
		    add(name);
		    
		    l = new JLabel("Stock:", JLabel.LEFT);
		    add(l);
		    stock = new JTextField(main.getMenu().get(item).getStock());
		    l.setLabelFor(stock);
		    add(stock);
		    
		    l = new JLabel("Price:", JLabel.LEFT);
		    add(l);
		    price = new JTextField("" + main.getMenu().get(item).getPrice());
		    l.setLabelFor(price);
		    add(price);
		    
		    l = new JLabel("Calories:", JLabel.LEFT);
		    add(l);
		    calories = new JTextField("" + main.getMenu().get(item).getCalories());
		    l.setLabelFor(calories);
		    add(calories);
		    
		    l = new JLabel("Age Limit:", JLabel.LEFT);
		    add(l);
		    agl = new JTextField(main.getMenu().get(item).getAgeLimit());
		    l.setLabelFor(agl);
		    add(agl);
		    
		    ic = new JButton("Select Image");
		    add(ic);
			ic.addActionListener(handler);
		    
		    ab = new JButton("Edit Salad");
		    add(ab); 
			ab.addActionListener(handler);
			
			break;
			
		case "menu.Sandwich":
			
			l = new JLabel("Name:", JLabel.LEFT);
		    add(l);
		    name = new JTextField(main.getMenu().get(item).getName());
		    l.setLabelFor(name);
		    add(name);
		    
		    l = new JLabel("Stock:", JLabel.LEFT);
		    add(l);
		    stock = new JTextField(main.getMenu().get(item).getStock());
		    l.setLabelFor(stock);
		    add(stock);
		    
		    l = new JLabel("Price:", JLabel.LEFT);
		    add(l);
		    price = new JTextField("" + main.getMenu().get(item).getPrice());
		    l.setLabelFor(price);
		    add(price);
		    
		    l = new JLabel("Calories:", JLabel.LEFT);
		    add(l);
		    calories = new JTextField("" + main.getMenu().get(item).getCalories());
		    l.setLabelFor(calories);
		    add(calories);
		    
		    l = new JLabel("Age Limit:", JLabel.LEFT);
		    add(l);
		    agl = new JTextField(main.getMenu().get(item).getAgeLimit());
		    l.setLabelFor(agl);
		    add(agl);
		    
		    ic = new JButton("Select Image");
		    add(ic);
			ic.addActionListener(handler);
		    
		    ab = new JButton("Edit Sandwich");
		    add(ab); 
			ab.addActionListener(handler);
			
			break;
			
		case "menu.MainDish":
			
			l = new JLabel("Name:", JLabel.LEFT);
		    add(l);
		    name = new JTextField(main.getMenu().get(item).getName());
		    l.setLabelFor(name);
		    add(name);
		    
		    l = new JLabel("Stock:", JLabel.LEFT);
		    add(l);
		    stock = new JTextField(main.getMenu().get(item).getStock());
		    l.setLabelFor(stock);
		    add(stock);
		    
		    l = new JLabel("Price:", JLabel.LEFT);
		    add(l);
		    price = new JTextField("" + main.getMenu().get(item).getPrice());
		    l.setLabelFor(price);
		    add(price);
		    
		    l = new JLabel("Calories:", JLabel.LEFT);
		    add(l);
		    calories = new JTextField("" + main.getMenu().get(item).getCalories());
		    l.setLabelFor(calories);
		    add(calories);
		    
		    l = new JLabel("Age Limit:", JLabel.LEFT);
		    add(l);
		    agl = new JTextField(main.getMenu().get(item).getAgeLimit());
		    l.setLabelFor(agl);
		    add(agl);
		    
		    ic = new JButton("Select Image");
		    add(ic);
			ic.addActionListener(handler);
		    
		    ab = new JButton("Edit Main Dish");
		    add(ab); 
			ab.addActionListener(handler);
			
			break;
		}
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == ic) {
				int returnVal = fc.showOpenDialog(ItemModifier.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						ImageIO.read(fc.getSelectedFile());
						f = fc.getSelectedFile().getPath();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid File", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			if (event.getSource() == ab) {
				
				switch (main.getMenu().get(item).getClass().toString()) {
	
				case "menu.Drink":
					
					try {
						if(f == null) throw new DataFormatException();
						main.getMenu().get(item).setName(name.getText());
						main.getMenu().get(item).setStock(Integer.parseInt(stock.getText()));
						main.getMenu().get(item).setPrice(Double.parseDouble(price.getText()));
						main.getMenu().get(item).setCalories(Double.parseDouble(calories.getText()));
						main.getMenu().get(item).setAgeLimit(Integer.parseInt(agl.getText()));
						main.getMenu().get(item).setImage(f);
						((Drink)main.getMenu().get(item)).setAbv(Double.parseDouble(abv.getText()));
						JOptionPane.showMessageDialog(null, "Drink Added", "Success", JOptionPane.DEFAULT_OPTION);
					} catch (DataFormatException e) {
						JOptionPane.showMessageDialog(null, "No Image Found", "ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid Input", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					break;
					
				case "menu.Entree":
					
					try {
						if(f == null) throw new DataFormatException();
						main.getMenu().get(item).setName(name.getText());
						main.getMenu().get(item).setStock(Integer.parseInt(stock.getText()));
						main.getMenu().get(item).setPrice(Double.parseDouble(price.getText()));
						main.getMenu().get(item).setCalories(Double.parseDouble(calories.getText()));
						main.getMenu().get(item).setAgeLimit(Integer.parseInt(agl.getText()));
						main.getMenu().get(item).setImage(f);
						((Entree)main.getMenu().get(item)).setStartHour(Integer.parseInt(st.getText().split(":")[0]));
						((Entree)main.getMenu().get(item)).setStartMin(Integer.parseInt(st.getText().split(":")[1]));
						((Entree)main.getMenu().get(item)).setEndHour(Integer.parseInt(et.getText().split(":")[0]));
						((Entree)main.getMenu().get(item)).setEndMin(Integer.parseInt(et.getText().split(":")[1]));
						JOptionPane.showMessageDialog(null, "Drink Added", "Success", JOptionPane.DEFAULT_OPTION);
					} catch (DataFormatException e) {
						JOptionPane.showMessageDialog(null, "No Image Found", "ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid Input", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					break;
					
				case "menu.Salad":
					
					try {
						if(f == null) throw new DataFormatException();
						main.getMenu().get(item).setName(name.getText());
						main.getMenu().get(item).setStock(Integer.parseInt(stock.getText()));
						main.getMenu().get(item).setPrice(Double.parseDouble(price.getText()));
						main.getMenu().get(item).setCalories(Double.parseDouble(calories.getText()));
						main.getMenu().get(item).setAgeLimit(Integer.parseInt(agl.getText()));
						main.getMenu().get(item).setImage(f);
						JOptionPane.showMessageDialog(null, "Drink Added", "Success", JOptionPane.DEFAULT_OPTION);
					} catch (DataFormatException e) {
						JOptionPane.showMessageDialog(null, "No Image Found", "ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid Input", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					break;
					
				case "menu.Sandwich":
					
					try {
						if(f == null) throw new DataFormatException();
						main.getMenu().get(item).setName(name.getText());
						main.getMenu().get(item).setStock(Integer.parseInt(stock.getText()));
						main.getMenu().get(item).setPrice(Double.parseDouble(price.getText()));
						main.getMenu().get(item).setCalories(Double.parseDouble(calories.getText()));
						main.getMenu().get(item).setAgeLimit(Integer.parseInt(agl.getText()));
						main.getMenu().get(item).setImage(f);
						JOptionPane.showMessageDialog(null, "Drink Added", "Success", JOptionPane.DEFAULT_OPTION);
					} catch (DataFormatException e) {
						JOptionPane.showMessageDialog(null, "No Image Found", "ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid Input", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					break;
					
				case "menu.MainDish":
					
					try {
						if(f == null) throw new DataFormatException();
						main.getMenu().get(item).setName(name.getText());
						main.getMenu().get(item).setStock(Integer.parseInt(stock.getText()));
						main.getMenu().get(item).setPrice(Double.parseDouble(price.getText()));
						main.getMenu().get(item).setCalories(Double.parseDouble(calories.getText()));
						main.getMenu().get(item).setAgeLimit(Integer.parseInt(agl.getText()));
						main.getMenu().get(item).setImage(f);
						JOptionPane.showMessageDialog(null, "Drink Added", "Success", JOptionPane.DEFAULT_OPTION);
					} catch (DataFormatException e) {
						JOptionPane.showMessageDialog(null, "No Image Found", "ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid Input", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					break;
				}
			}
		}
	}
}
