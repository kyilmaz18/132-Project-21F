package menu;

import java.util.ArrayList;

import customer.Customer;

public class Entree extends Item {
	private int startHour, startMin, endHour, endMin;
	
	public Entree(String name, int stock, double price, double calories, boolean ageGate, ArrayList<String> alergens,
			int startHour, int startMin, int endHour, int endMin) {
		super(name, stock, price, calories, ageGate, alergens);
		this.startHour = startHour;
		this.startMin = startMin;
		this.endHour = endHour;
		this.endMin = endMin;
	}

	public boolean canOrder(Customer c) {
		int lowLim = this.startHour * 60 + this.startMin;
		int highLim = this.endHour * 60 + this.endMin;
		int currTime = java.time.LocalTime.now().getHour() * 60 + java.time.LocalTime.now().getMinute();
		
		if (this.isAgeGate()) {
			if (c.getAge() < 18) return false;
		}
		
		if (currTime < lowLim && currTime > highLim) {
			return false;
		}
		
		ArrayList<String> temp = this.getAlergens();
		temp.retainAll(c.getAllergies());
		if (temp.size() > 0) return false; //TODO: Turn this to warning window in GUI
		
		return true;
	}
}
