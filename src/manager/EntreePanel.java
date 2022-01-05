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
import menu.Entree;
import menu.Item;

public class EntreePanel extends JFrame { // GUI for adding new Entree
	
	private String f;
	private JTextField name, stock, price, calories, st, et, agl;
	private JButton ic, ab;
	
	final JFileChooser fc = new JFileChooser(); // FileChooser to pick image for item
	
	public EntreePanel() {
		
		super("Drink Panel");
		
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
	    
	    l = new JLabel("Start Time:", JLabel.LEFT);
	    add(l);
	    st = new JTextField("00:00");
	    l.setLabelFor(st);
	    add(st);
	    
	    l = new JLabel("End Time:", JLabel.LEFT);
	    add(l);
	    et = new JTextField("23:59");
	    l.setLabelFor(et);
	    add(et);

	    l = new JLabel("Age Limit:", JLabel.LEFT);
	    add(l);
	    agl = new JTextField("0");
	    l.setLabelFor(agl);
	    add(agl);
	    
	    ic = new JButton("Select Image");
	    add(ic);
	    ButtonHandler handler = new ButtonHandler();
		ic.addActionListener(handler);
	    
	    ab = new JButton("Add Entree");
	    add(ab); 
		ab.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == ab) {
				try {
					if(f == null) { // Checks if no image present
						throw new DataFormatException("Invalid File");
					}
					main.getMenu().add(new Entree(name.getText(), Integer.parseInt(stock.getText()), Double.parseDouble(price.getText()), Double.parseDouble(calories.getText()), Integer.parseInt(agl.getText()), f, Integer.parseInt(st.getText().split(":")[0]), Integer.parseInt(st.getText().split(":")[1]), Integer.parseInt(et.getText().split(":")[0]), Integer.parseInt(et.getText().split(":")[1])));
					JOptionPane.showMessageDialog(null, "Entree Added", "Success", JOptionPane.DEFAULT_OPTION);
				} catch (DataFormatException e) {
					JOptionPane.showMessageDialog(null, "No Image Found", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Input", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (event.getSource() == ic) { // Opens filechooser for user, Checks filetype
				int returnVal = fc.showOpenDialog(EntreePanel.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						ImageIO.read(fc.getSelectedFile());
						f = fc.getSelectedFile().getPath();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid File", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
}
