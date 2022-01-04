package menu;

import java.awt.Image;
import java.util.ArrayList;

import customer.Customer;

public class Sandwich extends Item{
	
	public Sandwich(String name, int stock, double price, double calories, int ageLimit, ArrayList<String> alergens, Image image) {
		super(name, stock, price, calories, ageLimit, alergens, image);
	}

	public boolean canOrder(Customer c) { // Checks Item and Customer properties to see if iten can be ordered
		if (stock < 1) return false;
		
		if (c.getAge() < this.getAge()) return false;
		
		ArrayList<String> temp = this.getAlergens();
		temp.retainAll(c.getAllergies());
		if (temp.size() > 0) return false; //TODO: Turn this to warning window in GUI
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name: ");
		builder.append(name);
		builder.append("\n");
		builder.append("Stock: ");
		builder.append(stock);
		builder.append("\n");
		builder.append("Price: ");
		builder.append(price);
		builder.append("\n");
		builder.append("Calories: ");
		builder.append(calories);
		builder.append("\n");
		builder.append("Age Limit: : ");
		builder.append(ageLimit);
		builder.append("\n");
		builder.append("Alergens: ");
		for (int i = 0; i < alergens.size(); i++) {
			builder.append(alergens.get(i));
			builder.append("\t");
		}
		return builder.toString();
	}
}
