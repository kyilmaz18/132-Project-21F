package customer;

import java.util.ArrayList;

import menu.Item;

public class Customer { // Customer class keeps track of info and orders
	private String name;
	private int age;
	private ArrayList<Item> orders;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
		this.orders = new ArrayList<Item>();
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public ArrayList<Item> getOrders() {
		return orders;
	}
	
	public boolean addOrder(Item i) { // Adds item to the customer order list
		return this.orders.add(i);
	}
	
	public double getBill() { // Gets the bill for the customer
		double total = 0;
		for (int i = 0; i < this.orders.size(); i++) total += this.orders.get(i).getPrice();
		return total;
	}
}
