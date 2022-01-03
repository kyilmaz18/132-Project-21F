package customer;

import java.util.ArrayList;

public class Customer {
	private String name;
	private double balance;
	private int age;
	private ArrayList<String> alergies;

	public Customer(String name, int age, ArrayList<String> alergies) {
		this.name = name;
		this.age = age;
		this.alergies = alergies;
		this.balance = 0;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public int getAge() {
		return age;
	}

	public ArrayList<String> getAllergies() {
		return alergies;
	}
}
