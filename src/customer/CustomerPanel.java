package customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import manager.DrinkPanel.ButtonHandler;

public class CustomerPanel extends JFrame{
	
	private JTextField name, age, alergies;
	private JButton of;
	
	public CustomerPanel(Session s) {
		
		JLabel l = new JLabel("Name:", JLabel.LEFT);
	    add(l);
	    name = new JTextField("Name");
	    l.setLabelFor(name);
	    add(name);
	    
	    l = new JLabel("Age:", JLabel.LEFT);
	    add(l);
	    age = new JTextField("0");
	    l.setLabelFor(age);
	    add(age);
	    
	    l = new JLabel("Alergies:", JLabel.LEFT);
	    add(l);
	    alergies = new JTextField("");
	    l.setLabelFor(alergies);
	    add(alergies);
	    
	    of = new JButton("Place Order");
	    add(of);
	    ButtonHandler handler = new ButtonHandler();
		of.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
		}
	}
}
