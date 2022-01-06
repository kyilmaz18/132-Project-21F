package customer;

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

public class ItemViewerCS extends JFrame {

	private JButton img, ao;
	private JTextField text;
	private int sn, cn;
	private Item i;
	
	public ItemViewerCS(Item i, int sn, int cn) { // Views selected item from the menu
		super(i.getName());
		setLayout(new GridLayout(2,0));
		ButtonHandler handler = new ButtonHandler();
		this.i = i;
		this.sn = sn;
		this.cn = cn;
		
		img = new JButton(new ImageIcon(i.getImage()));
	    add(img);
	    text = new JTextField(i.toString());
	    text.setEditable(false);
	    add(text);
	    
	    ao = new JButton("Add to Order");
	    add(ao);
	    ao.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				if (!(i.canOrder(main.getSessions().get(sn).getPatronList().get(cn)))) throw new Exception(); // Checks if the item can be ordered
				main.getSessions().get(sn).getPatronList().get(cn).addOrder(i);
				main.getMenu().get(main.getMenu().indexOf(i)).orderPlaced();
				JOptionPane.showMessageDialog(null, "Order Added", "Success", JOptionPane.DEFAULT_OPTION);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Can't order item", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
