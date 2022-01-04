package manager;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import menu.Item;

public class MenuViewer extends JFrame{ // GUI for displaying selected menu from MenuSelector
	
	private LinkedList<JButton> buttons = new LinkedList<JButton>();
	private JButton mi, ba;
	private ArrayList<Item> m;

	public MenuViewer(ArrayList<Item> m) { // Grabs menu from the MenuSelector and builds gui
		
		super("Menu");
		this.m = m;
		ButtonHandler handler = new ButtonHandler();
		
		setLayout(new GridLayout(m.size() + 1, 0));
		
		for (int i = 0; i < m.size(); i++) { //Loop to create GUI entry for all menu Items
			Image img = m.get(i).getImage();
			mi = new JButton(new ImageIcon(img));
		    add(mi);
		    mi.addActionListener(handler);
		    buttons.add(mi);
		}
		
		ba = new JButton("Close Menu");
	    add(ba); 
		ba.addActionListener(handler);
		buttons.add(ba);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() != ba) {
				ItemViewer iv = new ItemViewer(m.get(buttons.indexOf(event.getSource())));
				iv.setSize(350, 350);
				iv.setVisible(true);
			}
			
			if (event.getSource() == ba) {
				MenuViewer.this.setVisible(false);
			}
			
		}
	}
		
}
