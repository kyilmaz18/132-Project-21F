package menu;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;

import customer.Customer;

public class Drink extends Item implements Serializable {
	private double abv;

	public Drink(String name, int stock, double price, double calories, int ageLimit, String image, double abv) {
		super(name, stock, price, calories, ageLimit, image);
		this.abv = abv;
	}
	
	public double getAbv() {
		return abv;
	}

	public void setAbv(double abv) {
		this.abv = abv;
	}

	@Override
	public boolean canOrder(Customer c) { 
		if (stock < 1) return false;
		
		if (c.getAge() < this.getAgeLimit()) return false;
		
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name: ");
		builder.append(name);
		builder.append("\n");
		builder.append(" Stock: ");
		builder.append(stock);
		builder.append("\n");
		builder.append(" Price: ");
		builder.append(price);
		builder.append("\n");
		builder.append(" Calories: ");
		builder.append(calories);
		builder.append("\n");
		builder.append(" Age Limit: : ");
		builder.append(ageLimit);
		builder.append("\n");
		builder.append(" Abv: ");
		builder.append(abv);
		builder.append("\n");
		builder.append(" Current Orders: ");
		builder.append(currentOrders);
		return builder.toString();
	}	
}
