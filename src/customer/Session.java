package customer;

import java.util.ArrayList;

public class Session {
	private ArrayList<Customer> patronList; // Customers present in the session
	
	public Session() {
		this.patronList = new ArrayList<Customer>();
	}

	public ArrayList<Customer> getPatronList() {
		return patronList;
	}
	
	public boolean addCustomer(Customer c) {
		return this.patronList.add(c);
	}

	public double getBill() { // Gets the total bill of the session
		double bill = 0;
		for (int i = 0; i < this.patronList.size(); i++) bill += this.patronList.get(i).getBill(); // Session and Customer both have getBill() method
		return bill;
	}
	
}
