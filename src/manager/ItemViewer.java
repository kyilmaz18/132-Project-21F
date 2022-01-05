package manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.main;
import menu.Item;

public class ItemViewer extends JFrame {
	
	private JButton img;
	private JTextField text;
	private Item item;
	private JButton ba, ms;
	
	public ItemViewer(Item I) { // Views selected item from the menu
		super(I.getName());
		setLayout(new GridLayout(2,0));
		item = I;
		ButtonHandler handler = new ButtonHandler();
		
		img = new JButton(new ImageIcon(I.getImage()));
	    add(img);
	    text = new JTextField(I.toString());
	    text.setEditable(false);
	    add(text);
	    
	    ms = new JButton("Modify Item");
	    add(ms); 
		ms.addActionListener(handler);
	    
	    ba = new JButton("Remove Item");
	    add(ba); 
		ba.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == ba) {
				try {
					main.removeItem(item);
					JOptionPane.showMessageDialog(null, "Item Removed", "Success", JOptionPane.DEFAULT_OPTION);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Item Does Not Exist", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (event.getSource() == ms) {
				try {
					ItemModifier im = new ItemModifier(item);
					im.setSize(350,350);
					im.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Item Does Not Exist", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
