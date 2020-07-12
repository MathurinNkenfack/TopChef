package topchef.model;
public class BreakFast extends Menu {
	private String formula;
	private int amount;
   
    public BreakFast(String formula, double price) {
    	this.setAmount(1);
    	this.formula = formula;
    	this.price = price;
    }

	public String getFormula() {
		return formula;
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
	
	@Override
    public String toString() { 
        return String.format("%30s%30s%30s%30s\n",formula,price,amount,this.total()); 
    } 

 

}