package topchef.model;


public class Cafe extends Drink {
	private CafeCategory category;
	
    public Cafe(CafeCategory category, String name, double price) {
    	this.amount = 0;
    	this.name = name;
    	this.price = price;
    	this.category = category;

    }

	public CafeCategory getCategory() {
		return category;
	}
	
	@Override
    public String toString() { 
        return String.format("%30s%30s%30s%30s\n",name,price,amount,this.total()); 
    } 

}