package manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import menu.Drink;
import menu.Entree;
import menu.Item;
import menu.MainDish;
import menu.Salad;
import menu.Sandwich;

public class MenuSelector extends JFrame{ // GUI for viewing All or a Subsection of the menu
	
	private ArrayList<Item> m;
	private JButton sa, sd, se, ss, ssw, smd;
	
	public MenuSelector(ArrayList<Item> m) {
		
		super("Menu Selector");
		this.m = m;
		ButtonHandler handler = new ButtonHandler();
		
		setLayout(new GridLayout(6,0));
		
		sa = new JButton("Show All");
		add(sa);
		sa.addActionListener(handler);
		
		sd = new JButton("Show Drinks");
		add(sd);
		sd.addActionListener(handler);
		
		se = new JButton("Show Entrees");
		add(se);
		se.addActionListener(handler);

		ss = new JButton("Show Salads");
		add(ss);
		ss.addActionListener(handler);
		
		ssw = new JButton("Show Sandwiches");
		add(ssw);
		ssw.addActionListener(handler);
		
		smd = new JButton("Show Main Dishes");
		add(smd);
		smd.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) { // Chained ifs for different buttons
			
			if (event.getSource() == sa) {
				MenuViewer mw = new MenuViewer(m);
				mw.setSize(350, 350);
				mw.setVisible(true);
			}
			
			if (event.getSource() == sd) {
				ArrayList<Item> temp = new ArrayList<Item>();
				for (int i = 0; i < m.size(); i++) {
					if (m.get(i) instanceof Drink)  temp.add(m.get(i));
				}
				MenuViewer mw = new MenuViewer(temp);
				mw.setSize(350, 350);
				mw.setVisible(true);
			}

			if (event.getSource() == se) {
				ArrayList<Item> temp = new ArrayList<Item>();
				for (int i = 0; i < m.size(); i++) {
					if (m.get(i) instanceof Entree)  temp.add(m.get(i));
				}
				MenuViewer mw = new MenuViewer(temp);
				mw.setSize(350, 350);
				mw.setVisible(true);
			}

			if (event.getSource() == ss) {
				ArrayList<Item> temp = new ArrayList<Item>();
				for (int i = 0; i < m.size(); i++) {
					if (m.get(i) instanceof Salad)  temp.add(m.get(i));
				}
				MenuViewer mw = new MenuViewer(temp);
				mw.setSize(350, 350);
				mw.setVisible(true);
			}

			if (event.getSource() == ssw) {
				ArrayList<Item> temp = new ArrayList<Item>();
				for (int i = 0; i < m.size(); i++) {
					if (m.get(i) instanceof Sandwich)  temp.add(m.get(i));
				}
				MenuViewer mw = new MenuViewer(temp);
				mw.setSize(350, 350);
				mw.setVisible(true);
			}

			if (event.getSource() == smd) {
				ArrayList<Item> temp = new ArrayList<Item>();
				for (int i = 0; i < m.size(); i++) {
					if (m.get(i) instanceof MainDish)  temp.add(m.get(i));
				}
				MenuViewer mw = new MenuViewer(temp);
				mw.setSize(350, 350);
				mw.setVisible(true);
			}
		}
	}
}
