package topchef.model;

import java.io.File;


public class Invoice {
	private int id;
	private double totalAmount;
	private String date;
    private String time;
    private File docInvoice;
	
    public Invoice(int id, String date, String time) {
    	this.id = id;
    	this.date = date;
    	this.time = time;
    }
    
    //uses the order to calculate amount to be paid 
    public void setTotal(double amount) {
       totalAmount = amount;
    }


	public double getTotalAmount() {
		return totalAmount;
	}

	public int getId() {
		return id;
	}

	public File getDocInvoice() {
		return docInvoice;
	}

	public void setDocInvoice(File docInvoice) {
		this.docInvoice = docInvoice;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}



}