package manager;

import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import customer.Customer;
import customer.Session;
import main.main;

public class SessionViewer extends JFrame {

	private String text;
	
	public SessionViewer(int sn) {
		
		super("Session: " + sn);
		
		Session temp = main.getSessions().get(sn);
		Collections.sort(temp.getPatronList(), new Comparator<Customer>() {
	        @Override
	        public int compare(Customer c1, Customer c2) {
	        	if (Integer.compare(c1.getAge(), c2.getAge()) == 0) {
	        		return Double.compare(c2.getBill(), c1.getBill());
	        	}
	            return Integer.compare(c1.getAge(), c2.getAge());
	        }
		});
		
		for (int i = 0; i < temp.getPatronList().size(); i++) { //Loop to create GUI entry for all Sessions, its customer numbers, and total bill
			try {
				text ="Customer: " + temp.getPatronList().get(i).getName() + " Age: " + temp.getPatronList().get(i).getAge() + " Bill: " + temp.getPatronList().get(i).getBill();
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "No Customers in Session", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			JButton mi = new JButton(text);
		    add(mi);
		}
	}
}
