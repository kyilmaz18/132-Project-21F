package manager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import customer.Session;
import menu.Item;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManagerPanel extends JFrame { // Main panel for the manager

	private JButton sns, ss, sm, aib, es;
	private JComboBox<String> combo1;
	private ArrayList<Item> m;
	private int tc ;
	private ArrayList<Session> sessions = new ArrayList<Session>();
	
	private static final String[] types = {"Drink", "Entree", "Salad", "Sandwich", "Main Dish"}; 
	
	public ManagerPanel (ArrayList<Item> m, int tc) {
		
		super("Manager Panel");
		this.m = m;
		this.tc = tc;
		
		setLayout(new GridLayout(6,0));
		
		sns = new JButton("Start new sessions");
		add(sns);
		ButtonHandler handler = new ButtonHandler();
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
		
		es = new JButton("Close Restaurant");
		add(es);
		es.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == aib) {
				switch ((String) combo1.getSelectedItem()) {
				case "Drink":
					DrinkPanel dp = new DrinkPanel(m);
					dp.setSize(350, 350);
					dp.setVisible(true);
					break;
				case "Entree":
					EntreePanel ep = new EntreePanel(m);
					ep.setSize(350,350);
					ep.setVisible(true);
					break;
				case "Salad":
					SaladPanel sp = new SaladPanel(m);
					sp.setSize(350,350);
					sp.setVisible(true);
					break;
				case "Sandwich":
					SandwichPanel swp = new SandwichPanel(m);
					swp.setSize(350,350);
					swp.setVisible(true);
					break;
				case "Main Dish":
					MainDishPanel mdp = new MainDishPanel(m);
					mdp.setSize(350,350);
					mdp.setVisible(true);
					break; 
				}
			}
			
			if (event.getSource() == sns) {
				
			}
			
			if (event.getSource() == ss) {
				
			}
			
			if (event.getSource() == sm) {
				MenuSelector ms = new MenuSelector(m);
				ms.setSize(350,350);
				ms.setVisible(true);
			}
			
			if (event.getSource() == es) {
				System.exit(0);
			}
		}
	}
	
	public void addSession(Session s) {
		this.sessions.add(s);
	}
}
