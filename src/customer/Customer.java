package customer;

import java.util.ArrayList;

import menu.Item;

public class Customer {
	private String name;
	private int age;
	private ArrayList<String> alergies;
	private ArrayList<Item> orders;

	public Customer(String name, int age, ArrayList<String> alergies) {
		this.name = name;
		this.age = age;
		this.alergies = alergies;
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

	public ArrayList<String> getAllergies() {
		return alergies;
	}
}
