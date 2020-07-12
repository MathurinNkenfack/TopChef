package topchef.mvc;

import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import topchef.model.*;

public class ModelTopChef {
	private Connection connect;
	private Statement statement;
	private ResultSet resultSet;
	
	private void connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try{
			connect = DriverManager.getConnection("jdbc:mysql://localhost/topChef",
					"mathurin", "Mathurin@0011");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			throw e;
			}
	}
	
	/*==================================================
	 * Functions to insert items from the Database ||
	 * =================================================
	 */
			
	public int insertAppetisez(Appetisez appetisez) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String insertQuery = "Insert into topChef.Appetisez (price, description) values ( '" + appetisez.getPrice() + "', '" + appetisez.getDescription() + "')";
			
			// returns the number of insertion done
			return statement.executeUpdate(insertQuery);
			
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}	
	
	public int insertDish(Dish dish) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String insertQuery = "Insert into topChef.Dish (price, description) values ( '" + dish.getPrice() + "', '" + dish.getDescription() + "')";
			
			// return the number of insertion done
			return statement.executeUpdate(insertQuery);
			
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public int insertDessert(Dessert dessert) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String insertQuery = "Insert into topChef.Dessert (price, description) values ( '" + dessert.getPrice() + "', '" + dessert.getDescription() + "')";
			
			// return the number of insertion done
			return statement.executeUpdate(insertQuery);
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public int insertCafe(Cafe cafe) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String insertQuery = "Insert into topChef.Cafe (name, price, category) values ( '" + cafe.getName() + "', '" + cafe.getPrice()+ "', '" + cafe.getCategory().toString() + "')";
			
			// return the number of insertion done
			return statement.executeUpdate(insertQuery);
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public int insertFreshDrink(FreshDrink drink) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String insertQuery = "Insert into topChef.FreshDrink (name, price, category) values ( '" + drink.getName() + "', '" + drink.getPrice()+ "', '" + drink.getCategory().toString() + "')";
			
			// return the number of insertion done
			return statement.executeUpdate(insertQuery);
			
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public int insertInvoice(Invoice invoice) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String insertQuery = "Insert into topChef.Invoice (id, date, time, totalAmount, file) values ( '" + invoice.getId() + "', '" + invoice.getDate()+ "', '" + invoice.getTime()+ "', '" + invoice.getTotalAmount()+ "', '" + invoice.getDocInvoice().getPath() + "')";
			
			// return the number of insertion done
			return statement.executeUpdate(insertQuery);
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public int insertBreakFast(BreakFast breakFast) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String insertQuery = "Insert into topChef.BreakFast (price, formula) values ( '" + breakFast.getPrice() + "', '" + breakFast.getFormula() + "')";
			
			// return the number of insertion done
			return statement.executeUpdate(insertQuery);
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	/*==================================================
	 * Functions to delete items from the Database ||
	 * =================================================
	 */
			
	public int deleteAppetisez(Appetisez appetisez) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String deleteQuery = "Delete from topChef.Appetisez where price = '" + appetisez.getPrice() + "' and description = '" + appetisez.getDescription() + "'";
			
			// returns the number of insertion done
			return statement.executeUpdate(deleteQuery);
			
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}	
	
	public int deleteDish(Dish dish) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String deleteQuery = "Delete from topChef.Dish where price = '" + dish.getPrice() + "' and description = '" + dish.getDescription() + "'";
			
			// return the number of insertion done
			return statement.executeUpdate(deleteQuery);
			
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public int deleteDessert(Dessert dessert) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String deleteQuery = "Delete from topChef.Dessert where price = '" + dessert.getPrice() + "' and  description = '" + dessert.getDescription() + "'";
			
			// return the number of insertion done
			return statement.executeUpdate(deleteQuery);
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public int deleteCafe(Cafe cafe) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String deleteQuery = "Delete from topChef.Cafe where name = '" + cafe.getName() + "' and price = '" + cafe.getPrice()+ "' and category = '" + cafe.getCategory().toString() + "'";
			
			// return the number of insertion done
			return statement.executeUpdate(deleteQuery);
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public int deleteFreshDrink(FreshDrink drink) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String deleteQuery = "Delete from topChef.FreshDrink where name = '" + drink.getName() + "' and price = '" + drink.getPrice()+ "' and category = '" + drink.getCategory().toString() + "'";
			
			// return the number of insertion done
			return statement.executeUpdate(deleteQuery);
			
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public int deleteInvoice(Invoice invoice) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String deleteQuery = "Delete from topChef.Invoice where id ='" + invoice.getId() + "'";
			
			// return the number of insertion done
			return statement.executeUpdate(deleteQuery);
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public int deleteBreakFast(BreakFast breakFast) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			String deleteQuery = "Delete from topChef.BreakFast where price = '" + breakFast.getPrice() + "' and  formula = '" + breakFast.getFormula() + "'";
			
			// return the number of insertion done
			return statement.executeUpdate(deleteQuery);
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	/*===========================================
	 * Functions to get items from the database
	 * ==========================================
	 */
	
	public ArrayList<Appetisez> getAppetisezs() throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select description, price from topChef.Appetisez");
			if(resultSet == null) {
				return null;
			}
			else {
				ArrayList<Appetisez> app = new ArrayList<Appetisez>();
				while(resultSet.next()) {
					String des = resultSet.getString("description");
					double price = resultSet.getDouble("price");
					app.add(new Appetisez(des, price));
				}
				return app;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}	
	
	public ArrayList<Dish> getDishes() throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select description, price from topChef.Dish");
			if(resultSet == null) {
				return null;
			}
			else {
				ArrayList<Dish> dishes = new ArrayList<Dish>();
				while(resultSet.next()) {
					String des = resultSet.getString("description");
					double price = resultSet.getDouble("price");
					dishes.add(new Dish(des, price));
				}
				return dishes;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public ArrayList<Dessert> getDesserts() throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select description, price from topChef.Dessert");
			if(resultSet == null) {
				return null;
			}
			else {
				ArrayList<Dessert> desserts = new ArrayList<Dessert>();
				while(resultSet.next()) {
					String des = resultSet.getString("description");
					double price = resultSet.getDouble("price");
					desserts.add(new Dessert(des, price));
				}
				return desserts;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public ArrayList<Cafe> getCafes() throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select name, category, price from topChef.Cafe");
			if(resultSet == null) {
				return null;
			}
			else {
				ArrayList<Cafe> cafes = new ArrayList<Cafe>();
				while(resultSet.next()) {
					String name = resultSet.getString("name");
					CafeCategory category = CafeCategory.valueOf(resultSet.getString("category"));
					double price = resultSet.getDouble("price");
					cafes.add(new Cafe(category,name, price));
				}
				
				return cafes;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public ArrayList<Cafe> getCafes(String categoryName) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select name, category, price from topChef.Cafe where category ='" + categoryName +"'");
			if(resultSet == null) {
				return null;
			}
			else {
				ArrayList<Cafe> cafes = new ArrayList<Cafe>();
				while(resultSet.next()) {
					String name = resultSet.getString("name");
					CafeCategory category = CafeCategory.valueOf(resultSet.getString("category"));
					double price = resultSet.getDouble("price");
					cafes.add(new Cafe(category,name, price));
				}
				
				return cafes;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public ArrayList<FreshDrink> getFreshDrinks() throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select name, category, price from topChef.FreshDrink");
			if(resultSet == null) {
				return null;
			}
			else {
				ArrayList<FreshDrink> drinks = new ArrayList<FreshDrink>();
				while(resultSet.next()) {
					String name = resultSet.getString("name");
					FreshDrinkCategory category = FreshDrinkCategory.valueOf(resultSet.getString("category"));
					double price = resultSet.getDouble("price");
					drinks.add(new FreshDrink(category,name, price));
				}
				return drinks;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public ArrayList<FreshDrink> getFreshDrinks(String categoryName) throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select name, category, price from topChef.FreshDrink where category='" + categoryName +"'");
			if(resultSet == null) {
				return null;
			}
			else {
				ArrayList<FreshDrink> drinks = new ArrayList<FreshDrink>();
				while(resultSet.next()) {
					String name = resultSet.getString("name");
					FreshDrinkCategory category = FreshDrinkCategory.valueOf(resultSet.getString("category"));
					double price = resultSet.getDouble("price");
					drinks.add(new FreshDrink(category,name, price));
				}
				return drinks;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public ArrayList<Invoice> getInvoices() throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			String today = dateFormater.format(now);
			resultSet = statement.executeQuery("select id, date, file, time from topChef.Invoice where date='" + today + "'");
			if(resultSet == null) {
				return null;
			}
			else {
				ArrayList<Invoice> invoices = new ArrayList<Invoice>();
				while(resultSet.next()) {
					int id = resultSet.getInt("id");
					String date = resultSet.getString("date");
					File doc = new File(resultSet.getString("file"));
					String time = resultSet.getString("time");
					Invoice invoice = new Invoice(id,date,time);
					invoice.setDocInvoice(doc);
					invoices.add(invoice);
				}
				return invoices;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	public int getLastInvoiceId() throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select MAX(id) as maxId from topChef.Invoice" );
			if(resultSet == null) {
				return 0;
			}
			else {
				
					resultSet.next();
					int id = resultSet.getInt("maxId");
					return id;
				
			}
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
		
	}
	
	public ArrayList<BreakFast> getBreakFasts() throws Exception{
		try {
			connect();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select formula, price from topChef.BreakFast");
			if(resultSet == null) {
				return null;
			}
			else {
				ArrayList<BreakFast> breakFasts = new ArrayList<BreakFast>();
				while(resultSet.next()) {
					String formula = resultSet.getString("formula");
					double price = resultSet.getDouble("price");
					breakFasts.add(new BreakFast(formula, price));
				}
				return breakFasts;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			this.connect.close();
		}
		
	}
	
	
}
