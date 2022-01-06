package customer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.main;

public class CustomerPanel extends JFrame{
	
	private JTextField name, age;
	private JButton of;
	private int sn;
	
	public CustomerPanel(int sn) { // Panel for entering customer info
		
		super("New Customer");
		setLayout(new GridLayout(0,2));
		this.sn = sn;
		
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
	    
	    of = new JButton("Place Orders");
	    add(of);
	    ButtonHandler handler = new ButtonHandler();
		of.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) { // Checks input and creates a new customer class
			try {
				Customer cs = new Customer(name.getText(),Integer.parseInt(age.getText()));
				main.getSessions().get(sn).addCustomer(cs);
				MenuSelectorCS mscs = new MenuSelectorCS(sn, main.getSessions().get(sn).getPatronList().indexOf(cs));
				mscs.setSize(350, 350);
				mscs.setVisible(true);
				CustomerPanel.this.setVisible(false);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Input", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
