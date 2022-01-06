package manager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.main;

public class SessionsOverview extends JFrame {

	private LinkedList<JButton> buttons = new LinkedList<JButton>();
	private JButton mi, ba, tc;
	private String text;
	
	public SessionsOverview() {
		
		super("Current Sessions");
		ButtonHandler handler = new ButtonHandler();
		
		setLayout(new GridLayout(0, 1));
		
		tc = new JButton("Remaining Tables:" + main.getTableCount());
	    add(tc); 
		
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
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() != ba) { // Finds index from button array to view selected item
				SessionViewer sv = new SessionViewer((buttons.indexOf(event.getSource())));
				sv.setSize(350, 350);
				sv.setVisible(true);
			}
			
			if (event.getSource() == ba) {
				SessionsOverview.this.setVisible(false);
			}
			
		}
	}
}
