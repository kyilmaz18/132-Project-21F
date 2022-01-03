package manager;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import menu.Drink;
import menu.Menu;



public class drinkPanel extends JFrame {
	
	private Menu m;
	private JTextField name;
	private JTextField stock;
	private JTextField price;
	private JTextField calories;
	private JTextField abv;
	private JTextField alergens;
	private JCheckBox c;
	private JButton b;
	
	public drinkPanel(Menu m) {
		
		super("Drink Panel");
		this.m = m;
		
		setLayout(new GridLayout(7,2));
		
		JLabel l = new JLabel("Name:", JLabel.LEFT);
	    add(l);
	    name = new JTextField(10);
	    l.setLabelFor(name);
	    add(name);
	    
	    l = new JLabel("Stock:", JLabel.LEFT);
	    add(l);
	    stock = new JTextField(10);
	    l.setLabelFor(stock);
	    add(stock);
	    
	    l = new JLabel("Price:", JLabel.LEFT);
	    add(l);
	    price = new JTextField(10);
	    l.setLabelFor(price);
	    add(price);
	    
	    l = new JLabel("Calories:", JLabel.LEFT);
	    add(l);
	    calories = new JTextField(10);
	    l.setLabelFor(calories);
	    add(calories);
	    
	    l = new JLabel("ABV%:", JLabel.LEFT);
	    add(l);
	    abv = new JTextField(10);
	    l.setLabelFor(abv);
	    add(abv);
	    
	    l = new JLabel("Alergens:", JLabel.LEFT);
	    add(l);
	    alergens = new JTextField(10);
	    l.setLabelFor(alergens);
	    add(alergens);
	    
	    c = new JCheckBox("Age Gated");
	    add(c);
	    
	    b = new JButton("add");
	    add(b);
	    ButtonHandler handler = new ButtonHandler();
		b.addActionListener(handler);
	}
	
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			ArrayList<String> af = new ArrayList<String>(Arrays.asList(alergens.getText()));
			m.addItem(new Drink(name.getText(), Integer.parseInt(stock.getText()), Double.parseDouble(price.getText()), Double.parseDouble(calories.getText()), Double.parseDouble(abv.getText()), c.isSelected(), af));
			System.out.println(m.getItem(0).toString());
		}
	}
}
