package customer;

import java.util.ArrayList;

public class Session {
	private ArrayList<Customer> patronList;
	
	public Session() {
		this.patronList = new ArrayList<Customer>();
	}

	public ArrayList<Customer> getPatronList() {
		return patronList;
	}
	
	public boolean addCustomer(Customer c) {
		return this.patronList.add(c);
	}
	
	public int getCustomerCount() {
		return this.patronList.size();
	}

	public double getBill() {
		double bill = 0;
		for (int i = 0; i < this.patronList.size(); i++) {
			for (int j = 0; j < this.patronList.get(i).getOrders().size(); i++) {
				bill += this.patronList.get(i).getOrders().get(j).getPrice();
			}
		}
		return bill;
	}
	
}
