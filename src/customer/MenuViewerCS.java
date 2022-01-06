package customer;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import menu.Item;

public class MenuViewerCS extends JFrame {
	private LinkedList<JButton> buttons = new LinkedList<JButton>();
	private JButton mi, ba;
	private LinkedList<Item> me = new LinkedList<Item>();
	private int sn, cn;
	private Image img;

	public MenuViewerCS(LinkedList<Item> m, int sn, int cn) { // Grabs menu from the MenuSelector and builds gui
		
		super("Menu");
		for (int i = 0; i < m.size(); i++) me.add(m.get(i));
		ButtonHandler handler = new ButtonHandler();
		
		setLayout(new GridLayout(0, 2));
		
		for (int i = 0; i < m.size(); i++) { //Loop to create GUI entry for all menu Items
			try {
				img = ImageIO.read(new File(m.get(i).getImage()));
			} catch (IOException e) {
				e.printStackTrace(); // Should not enter here due to previous exception check
			}
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

			if (event.getSource() != ba) { // Uses the index of buttons to find the menu index
				ItemViewerCS iv = new ItemViewerCS(me.get(buttons.indexOf(event.getSource())), sn, cn);
				iv.setSize(350, 350);
				iv.setVisible(true);
			}
			
			if (event.getSource() == ba) {
				MenuViewerCS.this.setVisible(false);
			}
		}
	}
}
