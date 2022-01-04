package manager;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import menu.Item;

public class ItemViewer extends JFrame {
	
	private JButton img;
	private JTextField text;
	
	public ItemViewer(Item I) { // Views selected item from the menu
		setLayout(new GridLayout(2,0));
		img = new JButton(new ImageIcon(I.getImage()));
	    add(img);
	    text = new JTextField(I.toString());
	    text.setEditable(false);
	    add(text);
	}
}
