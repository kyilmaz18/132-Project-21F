package manager;

import java.awt.GridLayout;
import java.awt.Image;
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

import menu.Item;
import menu.Sandwich;

public class SandwichPanel extends JFrame {
	
	private ArrayList<Item> m;
	private Image f;
	private JTextField name, stock, price, calories, alergens, agl;
	private JButton ic, ab;
	
	final JFileChooser fc = new JFileChooser();

	public SandwichPanel(ArrayList<Item> m) {
		super("Salad Panel");
		this.m = m;
		
		setLayout(new GridLayout(20,2));
		
		JLabel l = new JLabel("Name:", JLabel.LEFT);
	    add(l);
	    name = new JTextField("Dish Name");
	    l.setLabelFor(name);
	    add(name);
	    
	    l = new JLabel("Stock:", JLabel.LEFT);
	    add(l);
	    stock = new JTextField("0");
	    l.setLabelFor(stock);
	    add(stock);
	    
	    l = new JLabel("Price:", JLabel.LEFT);
	    add(l);
	    price = new JTextField("0");
	    l.setLabelFor(price);
	    add(price);
	    
	    l = new JLabel("Calories:", JLabel.LEFT);
	    add(l);
	    calories = new JTextField("0");
	    l.setLabelFor(calories);
	    add(calories);
	    
	    l = new JLabel("Alergens:", JLabel.LEFT);
	    add(l);
	    alergens = new JTextField(10);
	    l.setLabelFor(alergens);
	    add(alergens);
	    
	    l = new JLabel("Age Limit:", JLabel.LEFT);
	    add(l);
	    agl = new JTextField("0");
	    l.setLabelFor(agl);
	    add(agl);
	    
	    ic = new JButton("Select Image");
	    add(ic);
	    ButtonHandler handler = new ButtonHandler();
		ic.addActionListener(handler);
	    
	    ab = new JButton("Add Sandwich");
	    add(ab); 
		ab.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == ab ) {
				ArrayList<String> af = new ArrayList<String>(Arrays.asList(alergens.getText().toLowerCase().replaceAll("\\s", "").split(",")));
				try {
					if(f == null) {
						throw new DataFormatException("Invalid File");
					}
					m.add(new Sandwich(name.getText(), Integer.parseInt(stock.getText()), Double.parseDouble(price.getText()), Double.parseDouble(calories.getText()), Integer.parseInt(agl.getText()), af, f));
					JOptionPane.showMessageDialog(null, "Sandwich Added", "Success", JOptionPane.DEFAULT_OPTION);
				} catch (DataFormatException e) {
					JOptionPane.showMessageDialog(null, "No Image Found", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Input", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (event.getSource() == ic) {
				int returnVal = fc.showOpenDialog(SandwichPanel.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						f = ImageIO.read(fc.getSelectedFile());
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid File", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
}
