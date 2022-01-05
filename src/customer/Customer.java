package customer;

import java.util.ArrayList;

import menu.Item;

public class Customer {
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
	
	public boolean addOrder(Item i) {
		return this.orders.add(i);
	}
}
