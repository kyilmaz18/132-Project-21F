package menu;

import java.awt.Image;
import java.util.ArrayList;

import customer.Customer;

public class Entree extends Item { // As variation Entrees have times they can be ordered
	private int startHour, startMin, endHour, endMin;

	public Entree(String name, int stock, double price, double calories, int ageLimit, ArrayList<String> alergens, Image image, int startHour, int startMin, int endHour, int endMin) {
		super(name, stock, price, calories, ageLimit, alergens, image);
		this.startHour = startHour;
		this.startMin = startMin;
		this.endHour = endHour;
		this.endMin = endMin;
	}

	public boolean canOrder(Customer c) { // Checks Item and Customer properties to see if iten can be ordered
		if (stock < 1) return false;
		
		int lowLim = this.startHour * 60 + this.startMin;
		int highLim = this.endHour * 60 + this.endMin;
		int currTime = java.time.LocalTime.now().getHour() * 60 + java.time.LocalTime.now().getMinute(); // Checks if system time is within given timewindow
		
		if (c.getAge() < this.getAge()) return false;
		
		if (currTime < lowLim && currTime > highLim) {
			return false;
		}
		
		ArrayList<String> temp = this.getAlergens();
		temp.retainAll(c.getAllergies());
		if (temp.size() > 0) return false; //TODO: Turn this to warning window in GUI
		
		return true;
	}
	
	@Override
	public String toString() { // toString() for display purposes
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
		builder.append("Served Between: ");
		builder.append(startHour);
		builder.append(":");
		builder.append(startMin);
		builder.append(" - ");
		builder.append(endHour);
		builder.append(":");
		builder.append(endMin);
		builder.append("\n");
		builder.append("Alergens: ");
		for (int i = 0; i < alergens.size(); i++) {
			builder.append(alergens.get(i));
			builder.append("\t");
		}
		return builder.toString();
	}
}
