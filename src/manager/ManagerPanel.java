package manager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import menu.Menu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerPanel extends JFrame {

	private JButton aib;
	private JComboBox<String> combo1;
	private Menu m;
	
	private static final String[] types = {"Drink", "Entree", "Salad", "Sandwich", "Main Dish"}; 
	
	public ManagerPanel (Menu m) {
		
		super("Manager Panel");
		this.m = m;
		
		setLayout(new FlowLayout());
		
		combo1 = new JComboBox<String>(types);
		add(combo1);
		
		aib = new JButton("Add Item");
		add(aib);
		
		ButtonHandler handler = new ButtonHandler();
		aib.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if (event.getActionCommand() == "Add Item") {
				switch ((String) combo1.getSelectedItem()) {
				case "Drink":
					drinkPanel dp = new drinkPanel(m);
					dp.setSize(350, 350);
					dp.setVisible(true);
					break;
			/*	case "Entree":
					entreePanel ep = new entreePanel(m);
					ep.setSize(350,350);
					ep.setVisible(true);
					break;
				case "Salad":
					saladPanel sp = new saladPanel(m);
					sp.setSize(350,350);
					sp.setVisible(true);
					break;
				case "Sandwich":
					sandwichPanel swp = new sandwichPanel(m);
					swp.setSize(350,350);
					swp.setVisible(true);
					break;
				case "Main Dish":
					mainDishPanel mdp = new mainDishPanel(m);
					mdp.setSize(350,350);
					mdp.setVisible(true);
					break; */
				}
			}
		}
	}	
}
