package menu;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;

import customer.Customer;

public class Item implements Serializable { // Superclass for all Items protected vars for subclass access
	protected String name, image;
	protected int stock, ageLimit, currentOrders;
	protected double price, calories;
	
	public Item(String name, int stock, double price, double calories, int ageLimit, String image) {
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.calories = calories;
		this.ageLimit = ageLimit;
		this.image = image;
		this.currentOrders = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}
	
	public int getCurrentOrders() {
		return currentOrders;
	}

	public void setCurrentOrders(int currentOrders) {
		this.currentOrders = currentOrders;
	}
	
	public void orderPlaced() {
		this.stock--;
		this.currentOrders++;
	}

	public boolean canOrder(Customer c) { // Checks Item and Customer properties to see if iten can be ordered
		if (stock < 1) return false;
		
		if (c.getAge() < ageLimit) return false;
		
		return true;
	}
}
