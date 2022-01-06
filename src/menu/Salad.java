package menu;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;

import customer.Customer;

public class Salad extends Item implements Serializable {
	
	public Salad(String name, int stock, double price, double calories, int ageLimit, String image) {
		super(name, stock, price, calories, ageLimit, image);
	}

	@Override
	public boolean canOrder(Customer c) { // Checks Item and Customer properties to see if iten can be ordered
		if (stock < 1) return false;
		
		if (c.getAge() < this.getAgeLimit()) return false;

		return true;
	}
	
	@Override
	public String toString() {  // toString() for display purposes
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
		builder.append(" Current Orders: ");
		builder.append(currentOrders);
		return builder.toString();
	}
}
