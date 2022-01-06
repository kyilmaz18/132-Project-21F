package manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import main.main;
import menu.Drink;
import menu.Entree;
import menu.Item;
import menu.MainDish;
import menu.Salad;
import menu.Sandwich;

	public class MenuSelector extends JFrame{ // GUI for viewing All or a Subsection of the menu

	private JButton sa, sd, se, ss, ssw, smd;
	
	public MenuSelector() {
		
		super("Menu Selector");
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
		public void actionPerformed(ActionEvent event) { // Switch for different menu selections
			
			ArrayList<Item> temp = new ArrayList<Item>();
			MenuViewer mw;
			switch (event.getActionCommand()) {
		
			case "Show All":
				mw = new MenuViewer(main.getMenu());
				mw.setSize(350, 350);
				mw.setVisible(true);
				temp.clear();
				break;
				
			case "Show Drinks": 
				for (int i = 0; i < main.getMenu().size(); i++) {
					if (main.getMenu().get(i) instanceof Drink)  temp.add(main.getMenu().get(i));
				}
				mw = new MenuViewer(temp);
				mw.setSize(350, 350);
				mw.setVisible(true);
				temp.clear();
				break;
				
			case "Show Entrees":
				for (int i = 0; i < main.getMenu().size(); i++) {
					if (main.getMenu().get(i) instanceof Entree)  temp.add(main.getMenu().get(i));
				}
				mw = new MenuViewer(temp);
				mw.setSize(350, 350);
				mw.setVisible(true);
				temp.clear();
				break;
				
			case "Show Salads":
				for (int i = 0; i < main.getMenu().size(); i++) {
					if (main.getMenu().get(i) instanceof Salad)  temp.add(main.getMenu().get(i));
				}
				mw = new MenuViewer(temp);
				mw.setSize(350, 350);
				mw.setVisible(true);
				temp.clear();
				break;
				
			case "Show Sandwiches":
				for (int i = 0; i < main.getMenu().size(); i++) {
					if (main.getMenu().get(i) instanceof Sandwich)  temp.add(main.getMenu().get(i));
				}
				mw = new MenuViewer(temp);
				mw.setSize(350, 350);
				mw.setVisible(true);
				temp.clear();
				break;
				
			case "Show Main Dishes":
				for (int i = 0; i < main.getMenu().size(); i++) {
					if (main.getMenu().get(i) instanceof MainDish)  temp.add(main.getMenu().get(i));
				}
				mw = new MenuViewer(temp);
				mw.setSize(350, 350);
				mw.setVisible(true);
				temp.clear();
				break;
			}
		}
	}
}
