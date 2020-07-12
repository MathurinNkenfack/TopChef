package topchef.model;


public abstract class Item {
	protected int amount;
	protected double price;


	public double getPrice() {
		return price;
	}
	
	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void increaseAmount() {
		amount++;
	}
	
	public double total() {
		return amount*price;
	}

}