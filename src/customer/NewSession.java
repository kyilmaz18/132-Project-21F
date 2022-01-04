package customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import menu.Item;

public class NewSession extends JFrame {

	private Session cs;
	private JTextField count;
	private int tc;
	
	
	public NewSession(ArrayList<Item> m, int tc, ArrayList<Session> sessions) {
		
		super("Arrange Seating");
		this.tc = tc;
		sessions.add(cs);
		
		JLabel l = new JLabel("Enter Guest Amount:", JLabel.LEFT);
	    add(l);
	    count = new JTextField("Guest Amount");
	    l.setLabelFor(count);
	    add(count);
	    
	    JButton ss = new JButton("Select Image");
	    add(ss);
	    ButtonHandler handler = new ButtonHandler();
		ss.addActionListener(handler);	    
	}
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				if (Integer.parseInt(count.getText()) > 4 + (tc - 1) * 2 ) throw new ArithmeticException();
				tc--;
				for (int i = Integer.parseInt(count.getText()) - 4; i > 0; i = i - 2) tc--;
				for (int i = 0; i < Integer.parseInt(count.getText()); i++) {
		    		CustomerPanel cp = new CustomerPanel(cs);
		    		cp.setSize(350,350);
					cp.setVisible(true);
				}
			} catch (ArithmeticException e) {
				JOptionPane.showMessageDialog(null, "Not Enough Seats", "ERROR", JOptionPane.ERROR_MESSAGE);
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, "Invalid Input", "ERROR", JOptionPane.ERROR_MESSAGE);
		    }
		}
    }
}
