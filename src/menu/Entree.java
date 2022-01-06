package menu;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;

import customer.Customer;

public class Entree extends Item implements Serializable { // As variation Entrees have time windows they can be ordered
	private int startHour, startMin, endHour, endMin;

	public Entree(String name, int stock, double price, double calories, int ageLimit, String image, int startHour, int startMin, int endHour, int endMin) {
		super(name, stock, price, calories, ageLimit, image);
		this.startHour = startHour;
		this.startMin = startMin;
		this.endHour = endHour;
		this.endMin = endMin;
	}
	
	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getStartMin() {
		return startMin;
	}

	public void setStartMin(int startMin) {
		this.startMin = startMin;
	}

	public int getEndHour() {
		return endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public int getEndMin() {
		return endMin;
	}

	public void setEndMin(int endMin) {
		this.endMin = endMin;
	}

	@Override
	public boolean canOrder(Customer c) { // Checks Item and Customer properties to see if iten can be ordered
		if (stock < 1) return false;
		
		int lowLim = this.startHour * 60 + this.startMin;
		int highLim = this.endHour * 60 + this.endMin;
		int currTime = java.time.LocalTime.now().getHour() * 60 + java.time.LocalTime.now().getMinute(); // Checks if system time is within given timewindow
		
		if (c.getAge() < this.getAgeLimit()) return false;
		
		if (currTime < lowLim && currTime > highLim) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() { // toString() for display purposes
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
		builder.append(" Served Between: ");
		builder.append(startHour);
		builder.append(":");
		builder.append(startMin);
		builder.append(" - ");
		builder.append(endHour);
		builder.append(":");
		builder.append(endMin);
		builder.append("\n");
		builder.append(" Current Orders: ");
		builder.append(currentOrders);
		return builder.toString();
	}
}
