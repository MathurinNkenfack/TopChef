package topchef.model;


public class FreshDrink extends Drink {
	private FreshDrinkCategory category;

    public FreshDrink(FreshDrinkCategory category, String name, double price) {
    	this.amount = 0;
    	this.category = category;
    	this.name = name;
    	this.price = price;
    }

	public FreshDrinkCategory getCategory() {
		return category;
	}

	@Override
    public String toString() { 
        return String.format("%30s%30s%30s%30s\n",name,price,amount,this.total()); 
    } 
 
}