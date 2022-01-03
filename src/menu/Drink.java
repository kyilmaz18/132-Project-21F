package menu;

import java.util.ArrayList;

import customer.Customer;

public class Drink extends Item {
	private double abv;

	public Drink(String name, int stock, double price, double calories, double abv, boolean ageGate, ArrayList<String> alergens) {
		super(name, stock, price, calories, ageGate, alergens);
		this.abv = abv;
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

	@Override
	public String toString() {
		return "Drink [abv=" + abv + ", getAbv()=" + getAbv() + ", getName()=" + getName() + ", getStock()="
				+ getStock() + ", getPrice()=" + getPrice() + ", getCalories()=" + getCalories() + ", isAgeGate()="
				+ isAgeGate() + ", getAlergens()=" + getAlergens() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
