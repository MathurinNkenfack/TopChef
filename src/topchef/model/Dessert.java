package topchef.model;

public class Dessert extends Item {
	private String description;

    public Dessert(String description, double price) {
    	this.amount = 0;
    	this.description = description;
    	this.price = price;
    }

    public String getDescription() {
		return description;
	}
    
    @Override
    public String toString() { 
        return String.format("%30s%30s%30s%30s\n",description,price,amount,this.total()); 
    } 

	


}