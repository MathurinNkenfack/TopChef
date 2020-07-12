package topchef.model;


public class Appetisez extends Item {

	private String description;
	
    public Appetisez(String description, double price) {
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