package manager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import customer.NewSession;
import customer.Session;
import menu.Item;
import main.main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManagerPanel extends JFrame { // Main panel for the manager

	private JButton sns, ss, sm, aib, em, es;
	private JComboBox<String> combo1;
	
	private static final String[] types = {"Drink", "Entree", "Salad", "Sandwich", "Main Dish"}; 
	
	public ManagerPanel () {
		
		super("Manager Panel");
		setLayout(new GridLayout(0,1));
		ButtonHandler handler = new ButtonHandler();
		
		sns = new JButton("Start New Session");
		add(sns);
		sns.addActionListener(handler);
		
		ss = new JButton("Show Sessions");
		add(ss);
		ss.addActionListener(handler);
		
		sm = new JButton("Show Menu");
		add(sm);
		sm.addActionListener(handler);
		
		combo1 = new JComboBox<String>(types);
		add(combo1);
		
		aib = new JButton("Add Item");
		add(aib);
		aib.addActionListener(handler);
		
		em = new JButton("Export Menu");
		add(em);
		em.addActionListener(handler);
		
		es = new JButton("Close Restaurant");
		add(es);
		es.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			switch(event.getActionCommand()) { // Switch Statement for Handling Buttons
			
			case "Add Item":
				switch ((String) combo1.getSelectedItem()) { // Opens Item adding page with the combobox selection
				
				case "Drink":
					DrinkPanel dp = new DrinkPanel();
					dp.setSize(350, 350);
					dp.setVisible(true);
					break;
					
				case "Entree":
					EntreePanel ep = new EntreePanel();
					ep.setSize(350,350);
					ep.setVisible(true);
					break;
					
				case "Salad":
					SaladPanel sp = new SaladPanel();
					sp.setSize(350,350);
					sp.setVisible(true);
					break;
					
				case "Sandwich":
					SandwichPanel swp = new SandwichPanel();
					swp.setSize(350,350);
					swp.setVisible(true);
					break;
					
				case "Main Dish":
					MainDishPanel mdp = new MainDishPanel();
					mdp.setSize(350,350);
					mdp.setVisible(true);
					break;
				}
				break;
				
			case "Start New Session": // Starts a new Customer Session
				NewSession ns = new NewSession();
				ns.setSize(350,350);
				ns.setVisible(true);
				break;
				
			case "Show Sessions": // Shows All Sessions
				SessionManager sm = new SessionManager();
				sm.setSize(350,350);
				sm.setVisible(true);
				break;
				
			case "Show Menu": // Shows menu GUI
				MenuSelector ms = new MenuSelector();
				ms.setSize(350,350);
				ms.setVisible(true);
				break;
				
			case "Export Menu": // Shows Export GUI
				MenuExporter me = new MenuExporter();
				me.setSize(350, 350);
				me.setVisible(true);
				break;
				
			case "Close Restaurant": // Exits Program
				System.exit(0);
				break;
			}
		}
	}
}
