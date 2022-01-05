package manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.main;

public class SessionManager extends JFrame{ // Provides Session Overview for the manager
	
	private LinkedList<JButton> buttons = new LinkedList<JButton>();
	private JButton mi, ba;
	private String text;
	
	public SessionManager() {
		
		super("Current Sessions");
		ButtonHandler handler = new ButtonHandler();
		
		setLayout(new GridLayout(main.getSessions().size() + 1, 0));
		
		for (int i = 0; i < main.getSessions().size(); i++) { //Loop to create GUI entry for all Sessions, its customer numbers, and total bill
			try {
				text ="Session: " + (i + 1) + " Customers: " + main.getSessions().get(i).getPatronList().size() + " Bill: " + main.getSessions().get(i).getBill();
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "No Sessions Active", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			mi = new JButton(text);
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
			
		}
	}
}
