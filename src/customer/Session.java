package customer;

import java.util.ArrayList;

public class Session {
	private ArrayList<Customer> patronList;
	private double bill;
	
	public Session(ArrayList<Customer> patronList, double bill) {
		super();
		this.patronList = patronList;
		this.bill = bill;
	}

	public ArrayList<Customer> getPatronList() {
		return patronList;
	}

	public double getBill() {
		return bill;
	}
	
}
