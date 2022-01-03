package menu;

import java.util.ArrayList;

public class Item {
	private String name;
	private int stock;
	private double price, calories;
	private boolean ageGate;
	private ArrayList<String> alergens;
	
	public Item(String name, int stock, double price, double calories, boolean ageGate, ArrayList<String> alergens) {
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.calories = calories;
		this.ageGate = ageGate;
		this.alergens = alergens;
	}

	public String getName() {
		return name;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStock() {
		return stock;
	}
	public double getPrice() {
		return price;
	}
	public double getCalories() {
		return calories;
	}
	public boolean isAgeGate() {
		return ageGate;
	}

	public ArrayList<String> getAlergens() {
		return alergens;
	}
	
}
