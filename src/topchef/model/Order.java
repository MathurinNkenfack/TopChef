package topchef.model;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
 
/*
 *  @Author : Nkenfack Mathurin
 *  @Date : 01/07/2020
 *  
 *  
 *  Order class represents an order placed by a customer
 */
public class Order {
	private static int count = 0;
	private int id;
    private Invoice invoice;
    private Menu menu;
    private ArrayList<Drink> drinks;
    
    public Order() {
    	id = ++count;
    	DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
    	LocalDateTime now = LocalDateTime.now();
    	invoice = new Invoice(id, date.format(now), time.format(now));
    	drinks = new ArrayList<Drink>();
    	menu = null;
    }

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public Invoice getInvoice() {
		return invoice;
	}
	
	public void makeInvoice() throws FileNotFoundException {
		double totalSum = 0;
		if(menu != null) {
			File invoiceDoc = new File("invoice/invoice-"+this.getId()+".txt");
			PrintStream stream = new PrintStream(invoiceDoc);
			System.setOut(stream);
			boolean appetisez = false;
			boolean dish = false;
			boolean dessert = false;
			boolean freshDrink = false;
			boolean cafe = false;
			String invoiceName = String.format("%s%07d", "INVOICE#",this.id);
			String date[] = invoice.getDate().split("-");
			String dateAndTimeTitle = String.format("%s/%s/%s%4s%10s", date[2],date[1],date[0],"AT",invoice.getTime());
			System.out.print(invoiceName +"\n\n");
			System.out.print(dateAndTimeTitle + "\n\n\n\n");
			if(menu instanceof Lunch) {
				String title1 = String.format("%75s", "LUNCH\n\n");
				System.out.println(title1);
				String title2 = String.format("%30s%30s%30s%30s\n","ITEM","PRICE(FCFA)","AMOUNT","TOTAL(FCFA)");
				System.out.println(title2);
				Lunch m = (Lunch)menu;
				ArrayList<Item> items = m.getItems();
				
				
				
				for(int i=0; i<items.size(); i++) {
					if(items.get(i) instanceof Cafe) {
						cafe = true;
					}
					if(items.get(i) instanceof Appetizer) {
						appetisez = true;
					}
					if(items.get(i) instanceof Dish) {
						dish = true;
					}
					if(items.get(i) instanceof Dessert) {
						dessert = true;
					}
					if(items.get(i) instanceof FreshDrink) {
						freshDrink = true;
					}
					
				}
				
				if(appetisez) {
					String title3 = String.format("%30s", "APPETISEZ");
					System.out.println("\n\n" + title3 + "\n");
					for(int i=0; i<items.size(); i++) {
						if(items.get(i) instanceof Appetizer) {
							Appetizer a = (Appetizer)items.get(i);
							totalSum = totalSum + a.getAmount()*a.getPrice();
							System.out.print(a);
						}
					}
				}
				if(dish) {
					String title4 = String.format("%30s", "DISH");
					System.out.println("\n\n\n" + title4 + "\n");
					for(int i=0; i<items.size(); i++) {
						if(items.get(i) instanceof Dish) {
							Dish a = (Dish)items.get(i);
							totalSum = totalSum + a.getAmount()*a.getPrice();
							System.out.print(a);
						}
					}
				}
				
				if(dessert) {
					String title5 = String.format("%30s", "DESSERT");
					System.out.println("\n\n\n" + title5 + "\n");
					for(int i=0; i<items.size(); i++) {
						if(items.get(i) instanceof Dessert) {
							Dessert a = (Dessert)items.get(i);
							totalSum = totalSum + a.getAmount()*a.getPrice();
							System.out.print(a);
						}
					}
				}
				if(freshDrink) {
					String title6 = String.format("%30s", "FRESH DRINK");
					System.out.println("\n\n\n" + title6 + "\n");
					for(int i=0; i<items.size(); i++) {
						if(items.get(i) instanceof FreshDrink) {
							FreshDrink a = (FreshDrink)items.get(i);
							totalSum = totalSum + a.getAmount()*a.getPrice();
							System.out.print(a);
						}
					}
				}
				if(cafe) {
					String title7 = String.format("%30s", "CAFE");
					System.out.println("\n\n\n" + title7 + "\n");
					for(int i=0; i<items.size(); i++) {
						if(items.get(i) instanceof Cafe) {
							Cafe a = (Cafe)items.get(i);
							totalSum = totalSum + a.getAmount()*a.getPrice();
							System.out.print(a);
						}
					}
				}
			}
			else if(menu instanceof Dinner) {
				String title1 = String.format("%75s", "DINNER\n");
				System.out.println(title1);
				String title2 = String.format("%30s%30s%30s%30s\n","ITEM","PRICE(FCFA)","AMOUNT","TOTAL(FCFA)");
				System.out.println(title2);
				Dinner m = (Dinner)menu;
				ArrayList<Item> items = m.getItems();
				
				for(int i=0; i<items.size(); i++) {
					if(items.get(i) instanceof Cafe) {
						cafe = true;
					}
					if(items.get(i) instanceof Appetizer) {
						appetisez = true;
					}
					if(items.get(i) instanceof Dish) {
						dish = true;
					}
					if(items.get(i) instanceof Dessert) {
						dessert = true;
					}
					if(items.get(i) instanceof FreshDrink) {
						freshDrink = true;
					}
					
				}
				
				if(appetisez) {
					String title3 = String.format("%30s", "APPETISEZ");
					System.out.println("\n\n" + title3 + "\n");
					for(int i=0; i<items.size(); i++) {
						if(items.get(i) instanceof Appetizer) {
							Appetizer a = (Appetizer)items.get(i);
							totalSum = totalSum + a.getAmount()*a.getPrice();
							System.out.print(a);
						}
					}
				}
				if(dish) {
					String title4 = String.format("%30s", "DISH");
					System.out.println("\n\n\n" + title4 + "\n");
					for(int i=0; i<items.size(); i++) {
						if(items.get(i) instanceof Dish) {
							Dish a = (Dish)items.get(i);
							totalSum = totalSum + a.getAmount()*a.getPrice();
							System.out.print(a);
						}
					}
				}
				if(dessert) {
					String title5 = String.format("%30s", "DESSERT");
					System.out.println("\n\n\n" + title5 + "\n");
					for(int i=0; i<items.size(); i++) {
						if(items.get(i) instanceof Dessert) {
							Dessert a = (Dessert)items.get(i);
							totalSum = totalSum + a.getAmount()*a.getPrice();
							System.out.print(a);
						}
					}
				}
				if(freshDrink) {
					String title6 = String.format("%30s", "FRESH DRINK");
					System.out.println("\n\n\n" + title6 + "\n");
					for(int i=0; i<items.size(); i++) {
						if(items.get(i) instanceof FreshDrink) {
							FreshDrink a = (FreshDrink)items.get(i);
							totalSum = totalSum + a.getAmount()*a.getPrice();
							System.out.print(a);
						}
					}
				}
				if(cafe) {
					String title7 = String.format("%30s", "CAFE");
					System.out.println("\n\n\n" + title7 + "\n");
					for(int i=0; i<items.size(); i++) {
						if(items.get(i) instanceof Cafe) {
							Cafe a = (Cafe)items.get(i);
							totalSum = totalSum + a.getAmount()*a.getPrice();
							System.out.print(a);
						}
					}
				}
			}
			else if(menu instanceof BreakFast) {
				String title8 = String.format("%75s", "BREAK FAST\n\n");
				System.out.println(title8);
				String title9 = String.format("%30s%30s%30s%30s\n","ITEM","PRICE(FCFA)","AMOUNT","TOTAL(FCFA)");
				System.out.println(title9);
				BreakFast m = (BreakFast)menu;
				totalSum = totalSum + m.getAmount()*m.getPrice();
				System.out.println(m);
				
			}
			
			String title12 = String.format("%30s%90s%5s", "TOTAL BILL: ",totalSum,"FCFA");
			System.out.println("\n\n\n"+title12);
			System.setOut(System.out);
			invoiceDoc.setReadOnly();
			invoice.setDocInvoice(invoiceDoc);
			invoice.setTotal(totalSum);
			
		}
		
		if(!drinks.isEmpty()) {
			boolean freshdrink2 = false;
			boolean cafe2 = false;
			
			for(int i=0; i<drinks.size(); i++) {
				if(drinks.get(i) instanceof FreshDrink) {
					freshdrink2 = true;
				}
				if(drinks.get(i) instanceof Cafe) {
					cafe2 = true;
				}
			}
			
			File invoiceDoc = new File("invoice/invoice-"+this.getId()+".txt");
			PrintStream stream = new PrintStream(invoiceDoc);
			System.setOut(stream);
			String invoiceName = String.format("%s%07d", "INVOICE#",this.id);
			String date[] = invoice.getDate().split("-");
			String dateAndTimeTitle = String.format("%s/%s/%s%4s%10s", date[2],date[1],date[0],"AT",invoice.getTime());
			System.out.print(invoiceName +"\n\n");
			System.out.print(dateAndTimeTitle + "\n\n\n\n");
			String title8 = String.format("%75s", "DRINKS");
			System.out.println(title8 + "\n" );
			String title2 = String.format("%30s%30s%30s%30s\n","ITEM","PRICE(FCFA)","AMOUNT","TOTAL(FCFA)");
			System.out.println(title2);
			if(freshdrink2) {
				String title10 = String.format("%30s", "FRESH DRINK");
				System.out.println("\n\n\n"+title10);
				for(int i=0; i<drinks.size(); i++) {
					if(drinks.get(i) instanceof FreshDrink) {
						FreshDrink d = (FreshDrink)drinks.get(i);
						totalSum = totalSum + d.amount*d.getPrice();
						System.out.print(d);
					}
				}
			}
			if(cafe2) {
				String title11 = String.format("%30s", "CAFE\n");
				System.out.println("\n\n\n" +title11);
				for(int i=0; i<drinks.size(); i++) {
					if(drinks.get(i) instanceof Cafe) {
						Cafe d = (Cafe)drinks.get(i);
						totalSum = totalSum + d.amount*d.getPrice();
						System.out.print(d);
					}
				}
			}
			String title12 = String.format("%30s%90s%5s", "TOTAL BILL: ",totalSum,"FCFA");
			System.out.println("\n\n\n"+title12);
			System.setOut(System.out);
			invoiceDoc.setReadOnly();
			invoice.setDocInvoice(invoiceDoc);
			invoice.setTotal(totalSum);
			
		}
		
		
	}

	public ArrayList<Drink> getDrinks() {
		return drinks;
	}
	
	public boolean addDrink(Drink drink) {
		return drinks.add(drink);
	}
	
	public boolean addDrink(ArrayList<Drink> drinks) {
		return drinks.addAll(drinks);
	}

	public void setDrinks(ArrayList<Drink> drinks) {
		this.drinks = drinks;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Order.count = count;
	}
	
	

	

}