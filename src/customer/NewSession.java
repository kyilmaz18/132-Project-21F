package customer;

import java.awt.FlowLayout;
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
		setLayout(new FlowLayout());
		
		JLabel l = new JLabel("Enter Guest Amount:", JLabel.LEFT);
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
				if (Integer.parseInt(count.getText()) > 4 + (main.getTableCount() - 1) * 2 ) throw new ArithmeticException();
				main.setTableCount(main.getTableCount() - 1);
				Session ns = new Session();
				main.addSession(ns);
				for (int i = Integer.parseInt(count.getText()) - 4; i > 0; i = i - 2) main.setTableCount(main.getTableCount() - 1);
				for (int i = 0; i < Integer.parseInt(count.getText()); i++) {
		    		CustomerPanel cp = new CustomerPanel(main.getSessions().indexOf(ns));
		    		cp.setSize(350,350);
					cp.setVisible(true);
				}
				NewSession.this.setVisible(false);
			} catch (ArithmeticException e) {
				JOptionPane.showMessageDialog(null, "Not Enough Seats", "ERROR", JOptionPane.ERROR_MESSAGE);
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, "Invalid Input", "ERROR", JOptionPane.ERROR_MESSAGE);
		    }
		}
    }
}
