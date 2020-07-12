package topchef.model;

import java.util.ArrayList;

public class Dinner extends Menu {
	private ArrayList<Item> items;
    
    public Dinner() {
    	this.price = 0;
    	this.items = new ArrayList<Item>();
    }
    
    public ArrayList<Item> getItems() {
		return items;
	}

    public void setItems(ArrayList<Item> items) {
		this.items = items;
		for(int i=0; i < items.size(); i++) {
			Item item = items.get(i);
			this.price = this.price + item.getPrice()*item.getAmount();
		}
			
	}
    
	public boolean addItem(Item item) {
		this.price = this.price + item.getPrice()*item.getAmount();
		return this.items.add(item);
	}
	
	public boolean removeItem(Item item) {
		if(items.contains(item)) {
			this.price = this.price - item.getPrice()*item.getAmount();
			return items.remove(item);
		}else {
			return false;
		}
	}



}