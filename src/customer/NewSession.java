package customer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.main;

public class NewSession extends JFrame {
	
	private JTextField count;

	public NewSession() {
		
		super("Arrange Seating");
		setLayout(new GridLayout(0,1));
		
		JLabel l = new JLabel("Available Seats: " + main.getTableCount() * 2, JLabel.LEFT);
	    add(l);
		
		l = new JLabel("Enter Guest Amount:", JLabel.LEFT);
	    add(l);
	    count = new JTextField("Guest Amount");
	    l.setLabelFor(count);
	    add(count);
	    
	    JButton ss = new JButton("Place Orders");
	    add(ss);
	    ButtonHandler handler = new ButtonHandler();
		ss.addActionListener(handler);	    
	}
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				if (Integer.parseInt(count.getText()) > (main.getTableCount() - 1) * 2 ) throw new ArithmeticException();
				Session ns = new Session();
				main.addSession(ns);
				for (int i = Integer.parseInt(count.getText()); i > 0; i = i - 2) main.setTableCount(main.getTableCount() - 1);
				for (int i = 0; i < Integer.parseInt(count.getText()); i++) {
		    		CustomerPanel cp = new CustomerPanel(main.getSessions().indexOf(ns));
		    		cp.setSize(350,350);
					cp.setVisible(true);
				}
				NewSession.this.setVisible(false);
			} catch (ArithmeticException e) {
				JOptionPane.showMessageDialog(null, "Not Enough Seats", "ERROR", JOptionPane.ERROR_MESSAGE);
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, "Invalid Guest Amount", "ERROR", JOptionPane.ERROR_MESSAGE);
		    }
		}
    }
}
