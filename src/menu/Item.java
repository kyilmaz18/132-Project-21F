package menu;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

public class Item { // Superclass for all Items protected vars for subclass access
	protected String name;
	protected int stock, ageLimit;
	protected double price, calories;
	protected ArrayList<String> alergens;
	protected Image image;
	
	public Item(String name, int stock, double price, double calories, int ageLimit, ArrayList<String> alergens, Image image) {
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.calories = calories;
		this.ageLimit = ageLimit;
		this.alergens = alergens;
		this.image = image;
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
	public int getAge() {
		return ageLimit;
	}

	public Image getImage() {
		return image;
	}

	public ArrayList<String> getAlergens() {
		return alergens;
	}
	
}
