package topchef.model;


public class Dish extends Item {
	private String description;
    
    public Dish(String description, double price) {
    	this.description = description;
    	this.price = price;
    	this.amount = 0;
    }

	public String getDescription() {
		return description;
	}

    
	@Override
    public String toString() { 
        return String.format("%30s%30s%30s%30s\n",description,price,amount,this.total()); 
    } 

}