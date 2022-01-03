package menu;

import java.util.ArrayList;

public class Menu { // TODO: File I/O for program start/end
	ArrayList<Item> menu;

	public Menu() {
		this.menu  = new ArrayList<Item>();
	}
	
	public void addItem(Item i) {
		this.menu.add(i);
	}
	
	public Item getItem(int i) {
		return this.menu.get(i);
	}
}
