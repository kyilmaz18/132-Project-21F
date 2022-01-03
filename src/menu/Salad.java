package menu;

import java.util.ArrayList;

import customer.Customer;

public class Salad extends Item {

	public Salad(String name, int stock, double price, double calories, boolean ageGate, ArrayList<String> alergens) {
		super(name, stock, price, calories, ageGate, alergens);
	}
	
	public boolean canOrder(Customer c) {
		if (this.isAgeGate()) {
			if (c.getAge() < 18) return false;
		}
		
		ArrayList<String> temp = this.getAlergens();
		temp.retainAll(c.getAllergies());
		if (temp.size() > 0) return false; //TODO: Turn this to warning window in GUI
		
		return true;
	}
	
}
