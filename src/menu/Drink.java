package menu;

import java.util.ArrayList;

import customer.Customer;

public class Drink extends Item {
	private boolean hotOrCold;
	private double abv;

	public Drink(String name, int stock, double price, double calories, boolean ageGate, ArrayList<String> alergens,
			boolean hotOrCold, double abv) {
		super(name, stock, price, calories, ageGate, alergens);
		this.hotOrCold = hotOrCold;
		this.abv = abv;
	}

	public boolean isHotOrCold() {
		return hotOrCold;
	}
	
	public double getAbv() {
		return abv;
	}
	
	public boolean canOrder(Customer c) {
		
		if (this.isAgeGate()) {
			if (c.getAge() < 18) return false;
		}
		
		if (abv > 0) {
			if (c.getAge() < 18) return false;
		}
		
		ArrayList<String> temp = this.getAlergens();
		temp.retainAll(c.getAllergies());
		if (temp.size() > 0) return false; //TODO: Turn this to warning window in GUI
		
		return true;
	}
}
