package topchef.mvc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import topchef.model.Appetisez;
import topchef.model.BreakFast;
import topchef.model.Cafe;
import topchef.model.CafeCategory;
import topchef.model.Dessert;
import topchef.model.Dinner;
import topchef.model.Dish;
import topchef.model.Drink;
import topchef.model.FreshDrink;
import topchef.model.FreshDrinkCategory;
import topchef.model.Invoice;
import topchef.model.Item;
import topchef.model.Lunch;
import topchef.model.Order;

public class ViewTopChef extends JFrame{
	private ControllerTopChef model;
	private Map<String,ImageIcon> icons;
	private Map<String,JButton> buttons;
	private Map<String,JPanel> panels;
	private Map<String, JLabel> labels;
	private Stack<String> stackOfStates;
	private Map<String,ArrayList<Item>> items;
	private ArrayList<Item> orderItems;
	private Map<String,JTable> tables;
	private Map<String,JComboBox<String>> comboBoxes;
	
	public ViewTopChef() throws Exception {
		super("Top Chef");
		initialise();
		setLayout( new BorderLayout(5,5) );
		add(labels.get("mainTitle"),BorderLayout.NORTH);
		goTo("home");
	}
	
	public void initialise() throws Exception {
		model = new ControllerTopChef();
		icons = new HashMap<String, ImageIcon>();
		buttons = new HashMap<String, JButton>();
		panels = new HashMap<String, JPanel>();
		labels = new HashMap<String, JLabel>();
		stackOfStates = new Stack<String>();
		items = new HashMap<String, ArrayList<Item>>();
		tables = new HashMap<String,JTable>();
		comboBoxes = new HashMap<String,JComboBox<String>>();
		
		
		
		
		
		ImageIcon logo = new ImageIcon("image/chef2.png");
		ImageIcon adminIcon = new ImageIcon("image/admin.png");
		ImageIcon orderIcon = new ImageIcon("image/order.png");
		ImageIcon invoiceIcon = new ImageIcon("image/invoice.png");
		ImageIcon itemIcon = new ImageIcon("image/items.png");
		ImageIcon dinnerIcon = new ImageIcon("image/dinner.png");
		ImageIcon lunchIcon = new ImageIcon("image/lunch.png");
		ImageIcon breakFastIcon = new ImageIcon("image/Breakfast.png");
		ImageIcon freshDrinkIcon = new ImageIcon("image/freshDrink.png");
		ImageIcon drinksIcon = new ImageIcon("image/drinks.png");
		ImageIcon cafeIcon = new ImageIcon("image/cafe.png");
		ImageIcon appetisezIcon = new ImageIcon("image/Appetisez.png");
		ImageIcon dishIcon = new ImageIcon("image/Dish.png");
		ImageIcon dessertIcon = new ImageIcon("image/Dessert.png");
		ImageIcon returnLeftIcon = new ImageIcon("image/returnLeft.png");
		ImageIcon returnRightIcon = new ImageIcon("image/returnRight.png");
		
		JButton drinksButton = new JButton("DRINKS",drinksIcon);
		JButton returnLeftButton = new JButton(returnLeftIcon);
		JButton returnRightButton = new JButton(returnRightIcon);
		JButton returnLeftButton2 = new JButton(returnLeftIcon);
		JButton returnRightButton2 = new JButton(returnRightIcon);
		JButton returnLeftButton3 = new JButton(returnLeftIcon);
		JButton returnRightButton3 = new JButton(returnRightIcon);
		JButton returnLeftButton4 = new JButton(returnLeftIcon);
		JButton returnRightButton4 = new JButton(returnRightIcon);
		JButton returnLeftButton5 = new JButton(returnLeftIcon);
		JButton returnRightButton5 = new JButton(returnRightIcon);
		JButton returnLeftButton6 = new JButton(returnLeftIcon);
		JButton returnRightButton6 = new JButton(returnRightIcon);
		JButton returnLeftButton7 = new JButton(returnLeftIcon);
		JButton returnRightButton7 = new JButton(returnRightIcon);
		JButton returnLeftButton8 = new JButton(returnLeftIcon);
		JButton returnRightButton8 = new JButton(returnRightIcon);
		JButton orderButton = new JButton("ORDER", orderIcon);
		JButton adminButton = new JButton("ADMIN", adminIcon);
		JButton invoiceButton = new JButton("INVOICES", invoiceIcon);
		JButton itemButton = new JButton("ITEMS", itemIcon);
		JButton breakFastButton = new JButton(breakFastIcon);
		JButton breakFastButton2 = new JButton(breakFastIcon);
		JButton lunchButton = new JButton(lunchIcon);
		JButton lunchButton2 = new JButton(lunchIcon);
		JButton dinnerButton = new JButton(dinnerIcon);
		JButton dinnerButton2 = new JButton(dinnerIcon);
		JButton freshDrinkButton = new JButton("FRESH DRINK", freshDrinkIcon);
		JButton freshDrinkButton2 = new JButton("FRESH DRINK", freshDrinkIcon);
		JButton cafeButton = new JButton("CAFE", cafeIcon);
		JButton cafeButton2 = new JButton("CAFE", cafeIcon);
		JButton dessertButton = new JButton(dessertIcon);
		JButton dessertButton2 = new JButton(dessertIcon);
		JButton dishButton = new JButton(dishIcon);
		JButton dishButton2 = new JButton(dishIcon);
		JButton appetisezButton = new JButton(appetisezIcon);
		JButton appetisezButton2 = new JButton(appetisezIcon);
		JButton addBreakFastButton = new JButton("ADD BREAK-FAST");
		JButton addAppetisezButton = new JButton("ADD APPETISEZ");
		JButton addDishButton = new JButton("ADD DISH");
		JButton addDessertButton = new JButton("ADD DESSERT");
		JButton addFreshDrinkButton = new JButton("ADD FRESH DRINK");
		JButton addCafeButton = new JButton("ADD CAFE");
		JButton addOrderButton1 = new JButton("ORDER");
		JButton addOrderButton2 = new JButton("ORDER");
		JButton addOrderButton3 = new JButton("ORDER");
		JButton addOrderButton4 = new JButton("ORDER");
		JButton addOrderButton5 = new JButton("ORDER");
		
		addOrderButton1.setBackground(Color.GREEN);
		addOrderButton2.setBackground(Color.GREEN);
		addOrderButton3.setBackground(Color.GREEN);
		addOrderButton4.setBackground(Color.GREEN);
		addOrderButton5.setBackground(Color.GREEN);
		addOrderButton1.setVisible(false);
		addOrderButton2.setVisible(false);
		addOrderButton3.setVisible(false);
		addOrderButton4.setVisible(false);
		addOrderButton5.setVisible(false);
		

		JLabel invoiceTitle = new JLabel(invoiceIcon,SwingConstants.CENTER);
		JLabel mainTitle = new JLabel("Top Chef", SwingConstants.CENTER);
		JLabel adminTitle = new JLabel("ADMINISTRATOR", SwingConstants.CENTER);
		JLabel orderTitle = new JLabel("ENTER AN ORDER (MENU OR DRINK)", SwingConstants.CENTER);
		JLabel itemTitle = new JLabel("MANAGE ITEMS", SwingConstants.CENTER);
		JLabel menuTitle = new JLabel("MENU", SwingConstants.CENTER);
		JLabel drinkTitle = new JLabel("DRINKS", SwingConstants.CENTER);
		JLabel breakFastTitle = new JLabel(breakFastIcon, SwingConstants.CENTER);
		JLabel appetisezTitle = new JLabel(appetisezIcon, SwingConstants.CENTER);
		JLabel dishTitle = new JLabel(dishIcon, SwingConstants.CENTER);
		JLabel dessertTitle = new JLabel(dessertIcon, SwingConstants.CENTER);
		JLabel freshDrinkTitle = new JLabel(freshDrinkIcon, SwingConstants.CENTER);
		JLabel cafeTitle = new JLabel(cafeIcon, SwingConstants.CENTER);
		JLabel lunchTitle = new JLabel(lunchIcon,SwingConstants.CENTER);
		JLabel dinnerTitle = new JLabel(dinnerIcon,SwingConstants.CENTER);
		JLabel breakFast2Title = new JLabel(breakFastIcon,SwingConstants.CENTER);
		JLabel breakFast3Title = new JLabel("BREAK-FAST",SwingConstants.CENTER);
		JLabel drinksTitle = new JLabel(drinksIcon,SwingConstants.CENTER);
		JLabel totalTitle1 = new JLabel("TOTAL: 0.0 FCFA");
		JLabel totalTitle2 = new JLabel("TOTAL: 0.0 FCFA");
		JLabel totalTitle3 = new JLabel("TOTAL: 0.0 FCFA");
		JLabel totalTitle4 = new JLabel("TOTAL: 0.0 FCFA");
		JLabel totalTitle5 = new JLabel("TOTAL: 0.0 FCFA");
		JLabel appetisezTitle1 = new JLabel("APPETISEZ", SwingConstants.CENTER);
		JLabel dishTitle1 = new JLabel("DISH", SwingConstants.CENTER);
		JLabel dessertTitle1 = new JLabel("DESSERT", SwingConstants.CENTER);
		JLabel coffeeTitle1 = new JLabel("COFFEE", SwingConstants.CENTER);
		JLabel teaTitle1 = new JLabel("TEA", SwingConstants.CENTER);
		JLabel chocolateTitle1 = new JLabel("CHOCOLATE", SwingConstants.CENTER);
		JLabel wineTitle1 = new JLabel("WINE", SwingConstants.CENTER);
		JLabel whiskeyTitle1 = new JLabel("WHISKEY", SwingConstants.CENTER);
		JLabel spiritTitle1 = new JLabel("SPIRIT", SwingConstants.CENTER);
		JLabel beerTitle1 = new JLabel("BEER", SwingConstants.CENTER);
		JLabel juiceTitle1 = new JLabel("JUICE", SwingConstants.CENTER);
		JLabel waterTitle1 = new JLabel("WATER", SwingConstants.CENTER);
		JLabel appetisezTitle2 = new JLabel("APPETISEZ", SwingConstants.CENTER);
		JLabel dishTitle2 = new JLabel("DISH", SwingConstants.CENTER);
		JLabel dessertTitle2 = new JLabel("DESSERT", SwingConstants.CENTER);
		JLabel coffeeTitle2 = new JLabel("COFFEE", SwingConstants.CENTER);
		JLabel teaTitle2 = new JLabel("TEA", SwingConstants.CENTER);
		JLabel chocolateTitle2 = new JLabel("CHOCOLATE", SwingConstants.CENTER);
		JLabel wineTitle2 = new JLabel("WINE", SwingConstants.CENTER);
		JLabel whiskeyTitle2 = new JLabel("WHISKEY", SwingConstants.CENTER);
		JLabel spiritTitle2 = new JLabel("SPIRIT", SwingConstants.CENTER);
		JLabel beerTitle2 = new JLabel("BEER", SwingConstants.CENTER);
		JLabel juiceTitle2 = new JLabel("JUICE", SwingConstants.CENTER);
		JLabel waterTitle2 = new JLabel("WATER", SwingConstants.CENTER);
		JLabel wineTitle3 = new JLabel("WINE", SwingConstants.CENTER);
		JLabel whiskeyTitle3 = new JLabel("WHISKEY", SwingConstants.CENTER);
		JLabel spiritTitle3 = new JLabel("SPIRIT", SwingConstants.CENTER);
		JLabel beerTitle3 = new JLabel("BEER", SwingConstants.CENTER);
		JLabel juiceTitle3 = new JLabel("JUICE", SwingConstants.CENTER);
		JLabel waterTitle3 = new JLabel("WATER", SwingConstants.CENTER);
		JLabel coffeeTitle3 = new JLabel("COFFEE", SwingConstants.CENTER);
		JLabel teaTitle3 = new JLabel("TEA", SwingConstants.CENTER);
		JLabel chocolateTitle3 = new JLabel("CHOCOLATE", SwingConstants.CENTER);
		JLabel deleteTitle1 = new JLabel("DOUBLE-CLICK TO DELETE", SwingConstants.CENTER);
		JLabel deleteTitle2 = new JLabel("DOUBLE-CLICK TO DELETE", SwingConstants.CENTER);
		JLabel deleteTitle3 = new JLabel("DOUBLE-CLICK TO DELETE", SwingConstants.CENTER);
		JLabel deleteTitle4 = new JLabel("DOUBLE-CLICK TO DELETE", SwingConstants.CENTER);
		JLabel deleteTitle5 = new JLabel("DOUBLE-CLICK TO DELETE", SwingConstants.CENTER);
		JLabel deleteLabel = new JLabel("DOUBLE-CLICK ON AN ITEM TO DELETE");
		JLabel deleteLabel2 = new JLabel("DOUBLE-CLICK ON AN ITEM TO DELETE");
		JLabel deleteLabel3 = new JLabel("DOUBLE-CLICK ON AN ITEM TO DELETE");
		JLabel deleteLabel4 = new JLabel("DOUBLE-CLICK ON AN ITEM TO DELETE");
		JLabel deleteLabel5 = new JLabel("DOUBLE-CLICK ON AN ITEM TO DELETE");
		JLabel deleteLabel6 = new JLabel("DOUBLE-CLICK ON AN ITEM TO DELETE");
		Font titleFont = new Font("Mali", Font.BOLD, 25);
		Font TitleFont1 = new Font("Mali", Font.BOLD, 50);
		adminTitle.setFont(TitleFont1);
		mainTitle.setFont(titleFont);
		mainTitle.setIcon(logo);
		mainTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		mainTitle.setVerticalTextPosition(SwingConstants.BOTTOM);
		menuTitle.setFont(titleFont);
		menuTitle.setForeground(Color.red);
		breakFastTitle.setForeground(Color.WHITE);
		breakFastTitle.setFont(titleFont);
		deleteLabel.setForeground(Color.RED);
		deleteLabel2.setForeground(Color.RED);
		deleteLabel3.setForeground(Color.RED);
		deleteLabel4.setForeground(Color.RED);
		deleteLabel5.setForeground(Color.RED);
		deleteLabel6.setForeground(Color.RED);
		deleteTitle1.setForeground(Color.RED);
		drinkTitle.setFont(titleFont);
		drinkTitle.setForeground(Color.yellow);
		orderTitle.setFont(titleFont);
		orderTitle.setForeground(Color.WHITE);
		itemTitle.setFont(titleFont);
		itemTitle.setForeground(Color.WHITE);
		
		
		HomeButtonHandler homeButtonHandler = new HomeButtonHandler();
		adminButton.addActionListener( homeButtonHandler );
		orderButton.addActionListener( homeButtonHandler );
		
		AdminButtonHandler adminButtonHandler = new AdminButtonHandler();
		itemButton.addActionListener( adminButtonHandler );
		invoiceButton.addActionListener(adminButtonHandler );
		
		ItemManageButtonHandler itemManageButtonHandler = new ItemManageButtonHandler();
		breakFastButton2.addActionListener( itemManageButtonHandler );
		appetisezButton2.addActionListener( itemManageButtonHandler );
		dessertButton2.addActionListener( itemManageButtonHandler );
		dishButton2.addActionListener( itemManageButtonHandler );
		freshDrinkButton2.addActionListener( itemManageButtonHandler );
		cafeButton2.addActionListener( itemManageButtonHandler );
		
		ItemOrderButtonHandler itemOrderButtonHandler = new ItemOrderButtonHandler();
		breakFastButton.addActionListener( itemOrderButtonHandler );
		lunchButton.addActionListener( itemOrderButtonHandler );
		dinnerButton.addActionListener( itemOrderButtonHandler );
		drinksButton.addActionListener( itemOrderButtonHandler );
		
		
		ReturnButtonHandler returnButtonHandler = new ReturnButtonHandler();
		returnLeftButton.addActionListener( returnButtonHandler );
		returnRightButton.addActionListener( returnButtonHandler );
		returnLeftButton2.addActionListener( returnButtonHandler );
		returnRightButton2.addActionListener( returnButtonHandler );
		returnLeftButton3.addActionListener( returnButtonHandler );
		returnRightButton3.addActionListener( returnButtonHandler );
		returnLeftButton4.addActionListener( returnButtonHandler );
		returnRightButton4.addActionListener( returnButtonHandler );
		returnLeftButton5.addActionListener( returnButtonHandler );
		returnRightButton5.addActionListener( returnButtonHandler );
		returnLeftButton6.addActionListener( returnButtonHandler );
		returnRightButton6.addActionListener( returnButtonHandler );
		returnLeftButton7.addActionListener( returnButtonHandler );
		returnRightButton7.addActionListener( returnButtonHandler );
		returnLeftButton8.addActionListener( returnButtonHandler );
		returnRightButton8.addActionListener( returnButtonHandler );
		
		ItemAdditionButtonHandler itemAdditionButtonHandler = new ItemAdditionButtonHandler();
		addBreakFastButton.addActionListener( itemAdditionButtonHandler );
		addAppetisezButton.addActionListener( itemAdditionButtonHandler );
		addDishButton.addActionListener( itemAdditionButtonHandler );
		addDessertButton.addActionListener( itemAdditionButtonHandler );
		addFreshDrinkButton.addActionListener( itemAdditionButtonHandler );
		addCafeButton.addActionListener( itemAdditionButtonHandler );
		
		OrderButtonHandler orderButtonHandler = new OrderButtonHandler();
		addOrderButton1.addActionListener( orderButtonHandler );
		addOrderButton2.addActionListener( orderButtonHandler );
		addOrderButton3.addActionListener( orderButtonHandler );
		addOrderButton4.addActionListener( orderButtonHandler );
		addOrderButton5.addActionListener( orderButtonHandler );
		
		
		icons.put("logo", logo);
		icons.put("admin", adminIcon);
		icons.put("order", orderIcon);
		icons.put("invoice", invoiceIcon);
		icons.put("item", itemIcon);
		icons.put("dinner", dinnerIcon);
		icons.put("breakFast", breakFastIcon);
		icons.put("lunch", lunchIcon);
		icons.put("freshDrink", freshDrinkIcon);
		icons.put("cafe", cafeIcon);
		icons.put("appetisez", appetisezIcon);
		icons.put("dessert", dessertIcon);
		icons.put("dish", dishIcon);
		
		buttons.put("addDish",addDishButton);
		buttons.put("addDessert",addDessertButton);
		buttons.put("addBreakFast",addBreakFastButton);
		buttons.put("addAppetisez",addAppetisezButton);
		buttons.put("addFreshDrink",addFreshDrinkButton);
		buttons.put("addCafe",addCafeButton);
		buttons.put("returnLeft", returnLeftButton);
		buttons.put("returnRight", returnRightButton);
		buttons.put("returnLeft2", returnLeftButton2);
		buttons.put("returnRight2", returnRightButton2);
		buttons.put("returnLeft3", returnLeftButton3);
		buttons.put("returnRight3", returnRightButton3);
		buttons.put("returnLeft4", returnLeftButton4);
		buttons.put("returnRight4", returnRightButton4);
		buttons.put("returnLeft5", returnLeftButton5);
		buttons.put("returnRight5", returnRightButton5);
		buttons.put("returnLeft6", returnLeftButton6);
		buttons.put("returnRight6", returnRightButton6);
		buttons.put("returnLeft7", returnLeftButton7);
		buttons.put("returnRight7", returnRightButton7);
		buttons.put("returnLeft8", returnLeftButton8);
		buttons.put("returnRight8", returnRightButton8);
		buttons.put("order", orderButton);
		buttons.put("admin", adminButton);
		buttons.put("invoice", invoiceButton);
		buttons.put("item", itemButton);
		buttons.put("dinner", dinnerButton);
		buttons.put("breakFast", breakFastButton);
		buttons.put("lunch", lunchButton);
		buttons.put("freshDrink", freshDrinkButton);
		buttons.put("drinks",drinksButton);
		buttons.put("cafe", cafeButton);
		buttons.put("appetisez", appetisezButton);
		buttons.put("dessert", dessertButton);
		buttons.put("dish", dishButton);
		buttons.put("dinner2", dinnerButton2);
		buttons.put("breakFast2", breakFastButton2);
		buttons.put("lunch2", lunchButton2);
		buttons.put("freshDrink2", freshDrinkButton2);
		buttons.put("cafe2", cafeButton2);
		buttons.put("appetisez2", appetisezButton2);
		buttons.put("dessert2", dessertButton2);
		buttons.put("dish2", dishButton2);
		buttons.put("addOrder1", addOrderButton1);
		buttons.put("addOrder2", addOrderButton2);
		buttons.put("addOrder3", addOrderButton3);
		buttons.put("addOrder4", addOrderButton4);
		buttons.put("addOrder5", addOrderButton5);
		
		
		labels.put("invoiceTitle",invoiceTitle);
		labels.put("adminTitle", adminTitle);
		labels.put("mainTitle", mainTitle);
		labels.put("orderTitle", orderTitle);
		labels.put("menuTitle", menuTitle);
		labels.put("drinkTitle", drinkTitle);
		labels.put("itemTitle", itemTitle);
		labels.put("breakFastTitle", breakFastTitle);
		labels.put("appetisezTitle", appetisezTitle);
		labels.put("dishTitle", dishTitle);
		labels.put("dessertTitle", dessertTitle);
		labels.put("freshDrinkTitle", freshDrinkTitle);
		labels.put("cafeTitle", cafeTitle);
		labels.put("lunchTitle", lunchTitle);
		labels.put("dinnerTitle",dinnerTitle); 
		labels.put("breakFast2Title",breakFast2Title); 
		labels.put("breakFast3Title",breakFast3Title); 
		labels.put("drinksTitle",drinksTitle); 
		labels.put("totalTitle1", totalTitle1); 
		labels.put("totalTitle2", totalTitle2); 
		labels.put("totalTitle3", totalTitle3); 
		labels.put("totalTitle4", totalTitle4); 
		labels.put("totalTitle5", totalTitle5); 
		labels.put("appetisezTitle1", appetisezTitle1); 
		labels.put("dishTitle1", dishTitle1); 
		labels.put("dessertTitle1", dessertTitle1); 
		labels.put("coffeeTitle1", coffeeTitle1); 
		labels.put("teaTitle1", teaTitle1); 
		labels.put("chocolateTitle1", chocolateTitle1); 
		labels.put("wineTitle1", wineTitle1);
		labels.put("whiskeyTitle1", whiskeyTitle1); 
		labels.put("spiritTitle1", spiritTitle1);
		labels.put("beerTitle1", beerTitle1); 
		labels.put("juiceTitle1", juiceTitle1); 
		labels.put("waterTitle1", waterTitle1);
		labels.put("appetisezTitle2", appetisezTitle2); 
		labels.put("dishTitle2", dishTitle2); 
		labels.put("dessertTitle2", dessertTitle2); 
		labels.put("coffeeTitle2", coffeeTitle2); 
		labels.put("teaTitle2", teaTitle2); 
		labels.put("chocolateTitle2", chocolateTitle2); 
		labels.put("wineTitle2", wineTitle2);
		labels.put("whiskeyTitle2", whiskeyTitle2); 
		labels.put("spiritTitle2", spiritTitle2);
		labels.put("beerTitle2", beerTitle2); 
		labels.put("juiceTitle2", juiceTitle2); 
		labels.put("waterTitle2", waterTitle2);
		labels.put("wineTitle3",wineTitle3);
		labels.put("whiskeyTitle3", whiskeyTitle3); 
		labels.put("spiritTitle3", spiritTitle3);
		labels.put("beerTitle3", beerTitle3); 
		labels.put("juiceTitle3", juiceTitle3); 
		labels.put("waterTitle3", waterTitle3);
		labels.put("coffeeTitle3", coffeeTitle3); 
		labels.put("teaTitle3", teaTitle3); 
		labels.put("chocolateTitle3", chocolateTitle3);
		labels.put("deleteLabel", deleteLabel);
		labels.put("deleteLabel2", deleteLabel2);
		labels.put("deleteLabel3", deleteLabel3);
		labels.put("deleteLabel4", deleteLabel4);
		labels.put("deleteLabel5", deleteLabel5);
		labels.put("deleteLabel6", deleteLabel6);
		labels.put("deleteTitle1", deleteTitle1);
		labels.put("deleteTitle2", deleteTitle2);
		labels.put("deleteTitle3", deleteTitle3);
		labels.put("deleteTitle4", deleteTitle4);
		labels.put("deleteTitle5", deleteTitle5);
		
		homePage();
		adminPage();
		itemManagePage();
		orderPage();
		addBreakFastPage();
		addAppetisezPage();
		addDishPage();
		addDessertPage();
		addFreshDrinkPage();
		addCafePage();
		setItems();
		lunchOrderPage();
		dinnerOrderPage();
		breakFastOrderPage();
		drinksOrderPage();
		invoicePage();
		
		
		
		
		
		
	}
	

	
	public void homePage() {
		JPanel homeMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,100,50)); 
		homeMenu.add(buttons.get("admin"));
		homeMenu.add(buttons.get("order"));
		panels.put("home",homeMenu);
	}
	
	public void goTo(String pageName) {
		add(panels.get(pageName),BorderLayout.CENTER);
		stackOfStates.push(pageName);
		validate();
		repaint();
	}
	
	public void removePage(String pageName) {
		remove(panels.get(pageName));
		invalidate();
	}
	
	public void refresh() throws Exception {
		setItems();
	}
	
	public void adminPage() {
		JPanel adminMenu = new JPanel(new GridLayout(3,1,0,0));
		JPanel menu1 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,0)); 
		JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER,50,0));
		menu1.add(buttons.get("invoice"));
		menu1.add(buttons.get("item"));
		title.add(labels.get("adminTitle"));
		title.add(buttons.get("returnRight"));
		adminMenu.add(title);
		adminMenu.add(menu1);
		panels.put("admin", adminMenu);
		
		
	}
	
	public void orderPage() {
		JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER,50,10));
		JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,500,0));
		JPanel menuMenu = new JPanel(new GridLayout(2,1,0,0));
		JPanel drinkMenu = new JPanel(new GridLayout(2,1,0,0));
		JPanel menuButtons = new JPanel(new GridLayout(1,3,0,0)); 
		JPanel drinkButtons = new JPanel(new GridLayout(1,1,0,0));
		menuButtons.add(buttons.get("breakFast"));
		menuButtons.add(buttons.get("lunch"));
		menuButtons.add(buttons.get("dinner"));
		drinkButtons.add(buttons.get("drinks"));
	
		
		
		menuMenu.add(labels.get("menuTitle"));
		menuMenu.add(menuButtons);
		
		drinkMenu.add(labels.get("drinkTitle"));
		drinkMenu.add(drinkButtons);
		
		title.add(labels.get("orderTitle"));
		title.add(buttons.get("returnLeft"));
		mainMenu.add(title);
		mainMenu.add(menuMenu);
		mainMenu.add(drinkMenu);
		panels.put("order",mainMenu);
		
		
		
	}
	
	public void itemManagePage() {
		JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER,50,0));
		JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,500,50));
		JPanel itemButtons = new JPanel(new GridLayout(2,3,0,10));
		itemButtons.add(buttons.get("breakFast2"));
		itemButtons.add(buttons.get("appetisez2"));
		itemButtons.add(buttons.get("dish2"));
		itemButtons.add(buttons.get("dessert2"));
		itemButtons.add(buttons.get("freshDrink2"));
		itemButtons.add(buttons.get("cafe2"));
		
		
		title.add(labels.get("itemTitle"));
		title.add(buttons.get("returnLeft2"));
		mainMenu.add(title);
		mainMenu.add(itemButtons);
		panels.put("itemManage", mainMenu);
	}
	
	public void addBreakFastPage() throws Exception {
		String[] columnNames = {"N#","Formula","Price(FCFA)"};
		ArrayList<BreakFast> results = model.getBreakFasts();
		JTable table;
		if(results != null) {
			String values[][] = new String[results.size()][3];
			for(int i=0; i<results.size(); i++) {
				BreakFast f1 = results.get(i);
				String number = Integer.toString(i+1);
				String price = Double.toString(f1.getPrice());
				String value[] = { number, f1.getFormula(), price};
				for(int j=0; j<=2; j++) {
					values[i][j] = value[j];
				}
			}
			table = new JTable(values,columnNames) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		        }
			};
			
			table.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 2) {
		            	Object[] options = {"Yes", "No","Cancel"};
		            	// to detect double click events
		               JTable target = (JTable)me.getSource();
		               int row = target.getSelectedRow(); // select a row
		              int value = JOptionPane.showOptionDialog(null, 
		            		  "Do you really want to delete #" + "BreakFast"+ table.getValueAt(row, 0),
		            		  "Deletion",
		            		  JOptionPane.YES_NO_CANCEL_OPTION,
		            		  JOptionPane.WARNING_MESSAGE,
		            		  null,
		            		  options,
		            		  options[0]);
		              
		              if(value == 0) {
		            	  try {
							model.deleteBreakFast(results.get(row));
							JOptionPane.showMessageDialog(null,"Deleted!");
							removePage("addBreakFast");
							panels.remove("addBreakFast");
							addBreakFastPage();
							goTo("addBreakFast");
							stackOfStates.pop();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		              }
		            }
		         }
		      });
		}else {
			table = new JTable(null,columnNames);
		}
		
		table.setPreferredScrollableViewportSize(new Dimension(500,230));
        table.setFillsViewportHeight(true);
		JScrollPane sp = new JScrollPane(table);
		
		JPanel breakFastMenu = new JPanel(new GridLayout(1,3,50,0));
		breakFastMenu.add(buttons.get("addBreakFast"));
		breakFastMenu.add(labels.get("deleteLabel"));
		breakFastMenu.add(buttons.get("returnLeft3"));
		JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,500,50));
		mainMenu.add(labels.get("breakFastTitle"));
		mainMenu.add(breakFastMenu);
		mainMenu.add(sp);
		panels.put("addBreakFast", mainMenu);
			
	}
		
	public void addAppetisezPage() throws Exception {
		String[] columnNames = {"N#","Description","Price(FCFA)"};
		ArrayList<Appetisez> results = model.getAppetisezs();
		JTable table;
		if(results != null) {
			String values[][] = new String[results.size()][3];
			for(int i=0; i<results.size(); i++) {
				Appetisez f1 = results.get(i);
				String number = Integer.toString(i+1);
				String price = Double.toString(f1.getPrice());
				String value[] = { number, f1.getDescription(), price};
				for(int j=0; j<=2; j++) {
					values[i][j] = value[j];
				}
			}
			table = new JTable(values,columnNames) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		        }
			};
			
			table.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 2) {
		            	Object[] options = {"Yes", "No","Cancel"};
		            	// to detect double click events
		               JTable target = (JTable)me.getSource();
		               int row = target.getSelectedRow(); // select a row
		              int value = JOptionPane.showOptionDialog(null, 
		            		  "Do you really want to delete #" + "Appetisez"+ table.getValueAt(row, 0),
		            		  "Deletion",
		            		  JOptionPane.YES_NO_CANCEL_OPTION,
		            		  JOptionPane.WARNING_MESSAGE,
		            		  null,
		            		  options,
		            		  options[0]);
		              
		              if(value == 0) {
		            	  try {
							model.deleteAppetisez(results.get(row));
							JOptionPane.showMessageDialog(null,"Deleted!");
							removePage("addAppetisez");
							panels.remove("addAppetisez");
							addAppetisezPage();
							goTo("addAppetisez");
							stackOfStates.pop();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		              }
		            }
		         }
		      });
		}else {
			table = new JTable(null,columnNames);
		}
		table.setPreferredScrollableViewportSize(new Dimension(500,230));
        table.setFillsViewportHeight(true);
		JScrollPane sp = new JScrollPane(table);
		sp.setVisible(true);
		JPanel breakFastMenu = new JPanel(new GridLayout(1,3,50,0));
		breakFastMenu.add(buttons.get("addAppetisez"));
		breakFastMenu.add(labels.get("deleteLabel2"));
		breakFastMenu.add(buttons.get("returnRight3"));
		JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,500,50));
		mainMenu.add(labels.get("appetisezTitle"));
		mainMenu.add(breakFastMenu);
		mainMenu.add(sp);
		panels.put("addAppetisez", mainMenu);
			
	}
	
	public void addDishPage() throws Exception {
		String[] columnNames = {"N#","Description","Price(FCFA)"};
		ArrayList<Dish> results = model.getDishes();
		JTable table;
		if(results != null) {
			String values[][] = new String[results.size()][3];
			for(int i=0; i<results.size(); i++) {
				Dish f1 = results.get(i);
				String number = Integer.toString(i+1);
				String price = Double.toString(f1.getPrice());
				String value[] = { number, f1.getDescription(), price};
				for(int j=0; j<=2; j++) {
					values[i][j] = value[j];
				}
			}
			table = new JTable(values,columnNames) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		        }
			};
			
			table.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 2) {
		            	Object[] options = {"Yes", "No","Cancel"};
		            	// to detect double click events
		               JTable target = (JTable)me.getSource();
		               int row = target.getSelectedRow(); // select a row
		              int value = JOptionPane.showOptionDialog(null, 
		            		  "Do you really want to delete #" + "Dish"+ table.getValueAt(row, 0),
		            		  "Deletion",
		            		  JOptionPane.YES_NO_CANCEL_OPTION,
		            		  JOptionPane.WARNING_MESSAGE,
		            		  null,
		            		  options,
		            		  options[0]);
		              
		              if(value == 0) {
		            	  try {
							model.deleteDish(results.get(row));
							JOptionPane.showMessageDialog(null,"Deleted!");
							removePage("addDish");
							panels.remove("addDish");
							addDishPage();
							goTo("addDish");
							stackOfStates.pop();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		              }
		            }
		         }
		      });
		}else {
			table = new JTable(null,columnNames);
		}
		table.setPreferredScrollableViewportSize(new Dimension(500,230));
        table.setFillsViewportHeight(true);
		JScrollPane sp = new JScrollPane(table);
		sp.setVisible(true);
		
		JPanel breakFastMenu = new JPanel(new GridLayout(1,3,50,0));
		breakFastMenu.add(buttons.get("addDish"));
		breakFastMenu.add(labels.get("deleteLabel3"));
		breakFastMenu.add(buttons.get("returnLeft4"));
		JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,500,50));
		mainMenu.add(labels.get("dishTitle"));
		mainMenu.add(breakFastMenu);
		mainMenu.add(sp);
		panels.put("addDish", mainMenu);
			
	}
	
	public void addDessertPage() throws Exception {
		String[] columnNames = {"N#","Description","Price(FCFA)"};
		ArrayList<Dessert> results = model.getDesserts();
		JTable table;
		if(results != null) {
			String values[][] = new String[results.size()][3];
			for(int i=0; i<results.size(); i++) {
				Dessert f1 = results.get(i);
				String number = Integer.toString(i+1);
				String price = Double.toString(f1.getPrice());
				String value[] = { number, f1.getDescription(), price};
				for(int j=0; j<=2; j++) {
					values[i][j] = value[j];
				}
			}
			table = new JTable(values,columnNames) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		        }
			};
			
			table.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 2) {
		            	Object[] options = {"Yes", "No","Cancel"};
		            	// to detect double click events
		               JTable target = (JTable)me.getSource();
		               int row = target.getSelectedRow(); // select a row
		              int value = JOptionPane.showOptionDialog(null, 
		            		  "Do you really want to delete #" + "Dessert"+ table.getValueAt(row, 0),
		            		  "Deletion",
		            		  JOptionPane.YES_NO_CANCEL_OPTION,
		            		  JOptionPane.WARNING_MESSAGE,
		            		  null,
		            		  options,
		            		  options[0]);
		              
		              if(value == 0) {
		            	  try {
							model.deleteDessert(results.get(row));
							JOptionPane.showMessageDialog(null,"Deleted!");
							removePage("addDessert");
							panels.remove("addDessert");
							addDessertPage();
							goTo("addDessert");
							stackOfStates.pop();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		              }
		            }
		         }
		      });
		}else {
			table = new JTable(null,columnNames);
		}
		table.setPreferredScrollableViewportSize(new Dimension(500,230));
        table.setFillsViewportHeight(true);
		JScrollPane sp = new JScrollPane(table);
		sp.setVisible(true);
		JPanel breakFastMenu = new JPanel(new GridLayout(1,3,50,0));
		breakFastMenu.add(buttons.get("addDessert"));
		breakFastMenu.add(labels.get("deleteLabel4"));
		breakFastMenu.add(buttons.get("returnRight4"));
		JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,500,50));
		mainMenu.add(labels.get("dessertTitle"));
		mainMenu.add(breakFastMenu);
		mainMenu.add(sp);
		panels.put("addDessert", mainMenu);
			
	}
	
	public void addFreshDrinkPage() throws Exception {
		String[] columnNames = {"N#","Name","Category","Price(FCFA)"};
		ArrayList<FreshDrink> results = model.getFreshDrinks();
		JTable table;
		if(results != null) {
			String values[][] = new String[results.size()][4];
			for(int i=0; i<results.size(); i++) {
				FreshDrink f1 = results.get(i);
				String number = Integer.toString(i+1);
				String price = Double.toString(f1.getPrice());
				String value[] = { number, f1.getName(),f1.getCategory().toString(), price};
				for(int j=0; j<=3; j++) {
					values[i][j] = value[j];
				}
			}
			table = new JTable(values,columnNames) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		        }
			};
			
			table.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 2) {
		            	Object[] options = {"Yes", "No","Cancel"};
		            	// to detect double click events
		               JTable target = (JTable)me.getSource();
		               int row = target.getSelectedRow(); // select a row
		              int value = JOptionPane.showOptionDialog(null, 
		            		  "Do you really want to delete #" + "Fresh Drink"+ table.getValueAt(row, 0),
		            		  "Deletion",
		            		  JOptionPane.YES_NO_CANCEL_OPTION,
		            		  JOptionPane.WARNING_MESSAGE,
		            		  null,
		            		  options,
		            		  options[0]);
		              
		              if(value == 0) {
		            	  try {
							model.deleteFreshDrink(results.get(row));
							JOptionPane.showMessageDialog(null,"Deleted!");
							removePage("addFreshDrink");
							panels.remove("addFreshDrink");
							addFreshDrinkPage();
							goTo("addFreshDrink");
							stackOfStates.pop();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		              }
		            }
		         }
		      });
		}else {
			table = new JTable(null,columnNames);
		}
		table.setPreferredScrollableViewportSize(new Dimension(500,230));
        table.setFillsViewportHeight(true);
		JScrollPane sp = new JScrollPane(table);
		sp.setVisible(true);
		JPanel breakFastMenu = new JPanel(new GridLayout(1,3,50,0));
		breakFastMenu.add(buttons.get("addFreshDrink"));
		breakFastMenu.add(labels.get("deleteLabel5"));
		breakFastMenu.add(buttons.get("returnLeft5"));
		JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,500,50));
		mainMenu.add(labels.get("freshDrinkTitle"));
		mainMenu.add(breakFastMenu);
		mainMenu.add(sp);
		panels.put("addFreshDrink", mainMenu);
			
	}
	
	public void addCafePage() throws Exception {
		String[] columnNames = {"N#","Name","Category","Price(FCFA)"};
		ArrayList<Cafe> results = model.getCafes();
		JTable table;
		if(results != null) {
			String values[][] = new String[results.size()][4];
			for(int i=0; i<results.size(); i++) {
				Cafe f1 = results.get(i);
				String number = Integer.toString(i+1);
				String price = Double.toString(f1.getPrice());
				String value[] = { number, f1.getName(),f1.getCategory().toString(), price};
				for(int j=0; j<=3; j++) {
					values[i][j] = value[j];
				}
			}
			table = new JTable(values,columnNames) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		        }
			};
			
			table.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 2) {
		            	Object[] options = {"Yes", "No","Cancel"};
		            	// to detect double click events
		               JTable target = (JTable)me.getSource();
		               int row = target.getSelectedRow(); // select a row
		              int value = JOptionPane.showOptionDialog(null, 
		            		  "Do you really want to delete #" + "Cafe"+ table.getValueAt(row, 0),
		            		  "Deletion",
		            		  JOptionPane.YES_NO_CANCEL_OPTION,
		            		  JOptionPane.WARNING_MESSAGE,
		            		  null,
		            		  options,
		            		  options[0]);
		              
		              if(value == 0) {
		            	  try {
							model.deleteCafe(results.get(row));
							JOptionPane.showMessageDialog(null,"Deleted!");
							removePage("addCafe");
							panels.remove("addCafe");
							addCafePage();
							goTo("addCafe");
							stackOfStates.pop();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		              }
		            }
		         }
		      });
		}else {
			table = new JTable(null,columnNames);
		}
		table.setPreferredScrollableViewportSize(new Dimension(500,230));
        table.setFillsViewportHeight(true);
		JScrollPane sp = new JScrollPane(table);
		sp.setVisible(true);
		JPanel breakFastMenu = new JPanel(new GridLayout(1,3,50,0));
		breakFastMenu.add(buttons.get("addCafe"));
		breakFastMenu.add(labels.get("deleteLabel6"));
		breakFastMenu.add(buttons.get("returnRight5"));
		JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,500,50));
		mainMenu.add(labels.get("cafeTitle"));
		mainMenu.add(breakFastMenu);
		mainMenu.add(sp);
		panels.put("addCafe", mainMenu);
			
	}
	public void invoicePage() throws Exception {
		ArrayList<Invoice> invoices = model.getInvoices();
		
		String invoiceList[] = new String[invoices.size()];
		
		for(int i=0; i < invoices.size(); i++) {
			Invoice p = invoices.get(i);
			BufferedReader txtReader = new BufferedReader(new FileReader(p.getDocInvoice()));
			String invoiceName = txtReader.readLine();
			invoiceList[i] = invoiceName;
		}
		
		JComboBox<String> selectInvoice = new JComboBox<>(invoiceList);
		comboBoxes.put("invoice", selectInvoice);
		InvoiceHandler invoiceHandler = new InvoiceHandler();
		selectInvoice.addActionListener( invoiceHandler );
		
		JLabel name = labels.get("invoiceTitle");
		
		JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER, 50,0));
		JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,800,10));
		JLabel select = new JLabel("SELECT TODAY'S INVOICE");
	
		title.add(buttons.get("returnLeft8"));
		title.add(name);
		mainMenu.add(title);
		mainMenu.add(select);
		mainMenu.add(selectInvoice);

		panels.put("invoice",mainMenu);
	}
	
	@SuppressWarnings("unchecked")
	public void setItems() throws Exception {
		
		ArrayList<Appetisez> appetisezs = model.getAppetisezs();
		ArrayList<Dish> dishes = model.getDishes();
		ArrayList<Dessert> desserts = model.getDesserts();
		ArrayList<Cafe> coffee = model.getCafes("coffee");
		ArrayList<Cafe> tea = model.getCafes("tea");
		ArrayList<Cafe> chocolate = model.getCafes("chocolate");
		ArrayList<FreshDrink> wine = model.getFreshDrinks("wine");
		ArrayList<FreshDrink> whiskey = model.getFreshDrinks("whiskey");
		ArrayList<FreshDrink> spirits = model.getFreshDrinks("spirits");
		ArrayList<FreshDrink> beer = model.getFreshDrinks("beer");
		ArrayList<FreshDrink> juice = model.getFreshDrinks("juice");
		ArrayList<FreshDrink> water = model.getFreshDrinks("water");
		
		items.put("APPETISEZ",(ArrayList<Item>)((ArrayList<?>)appetisezs));
		items.put("DISH",(ArrayList<Item>)(ArrayList<?>)dishes);
		items.put("DESSERT",(ArrayList<Item>)((ArrayList<?>)desserts));
		items.put("COFFEE",(ArrayList<Item>)(ArrayList<?>)coffee);
		items.put("TEA",(ArrayList<Item>)((ArrayList<?>)tea));
		items.put("CHOCOLATE",(ArrayList<Item>)(ArrayList<?>)chocolate);
		items.put("WINE",(ArrayList<Item>)((ArrayList<?>)wine));
		items.put("WHISKEY",(ArrayList<Item>)(ArrayList<?>)whiskey);
		items.put("SPIRITS",(ArrayList<Item>)((ArrayList<?>)spirits));
		items.put("BEER",(ArrayList<Item>)(ArrayList<?>)beer);
		items.put("JUICE",(ArrayList<Item>)((ArrayList<?>)juice));
		items.put("WATER",(ArrayList<Item>)(ArrayList<?>)water);
	}
	
	
		@SuppressWarnings("unchecked")
		public void lunchOrderPage() throws Exception {
			
			ArrayList<Appetisez> appetisezs = (ArrayList<Appetisez>)((ArrayList<?>)items.get("APPETISEZ"));
			ArrayList<Dish> dishes = (ArrayList<Dish>)((ArrayList<?>)items.get("DISH"));
			ArrayList<Dessert> desserts = (ArrayList<Dessert>)((ArrayList<?>)items.get("DESSERT"));
			ArrayList<Cafe> coffee = (ArrayList<Cafe>)((ArrayList<?>)items.get("COFFEE"));
			ArrayList<Cafe> tea = (ArrayList<Cafe>)((ArrayList<?>)items.get("TEA"));
			ArrayList<Cafe> chocolate = (ArrayList<Cafe>)((ArrayList<?>)items.get("CHOCOLATE"));
			ArrayList<FreshDrink> wine = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("WINE"));
			ArrayList<FreshDrink> whiskey = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("WHISKEY"));
			ArrayList<FreshDrink> spirits = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("SPIRITS"));
			ArrayList<FreshDrink> beer = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("BEER"));
			ArrayList<FreshDrink> juice = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("JUICE"));
			ArrayList<FreshDrink> water = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("WATER"));
			
			
			String appetisezList[] = new String[appetisezs.size()];
			String dishList[] = new String[dishes.size()];
			String dessertList[] = new String[desserts.size()];
			String coffeeList[] = new String[coffee.size()];
			String teaList[] = new String[tea.size()];
			String chocolateList[] = new String[chocolate.size()];
			String wineList[] = new String[wine.size()];
			String whiskeyList[] = new String[whiskey.size()];
			String spiritsList[] = new String[spirits.size()];
			String beerList[] = new String[beer.size()];
			String juiceList[] = new String[juice.size()];
			String waterList[] = new String[water.size()];
			for(int i=0; i < appetisezs.size(); i++) {
				Appetisez p = appetisezs.get(i);
				appetisezList[i] = p.getDescription() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < dishes.size(); i++) {
				Dish p = dishes.get(i);
				dishList[i] = p.getDescription() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < desserts.size(); i++) {
				Dessert p = desserts.get(i);
				dessertList[i] = p.getDescription() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < coffee.size(); i++) {
				Cafe p = coffee.get(i);
				coffeeList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < tea.size(); i++) {
				Cafe p = tea.get(i);
				teaList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			
			for(int i=0; i < chocolate.size(); i++) {
				Cafe p = chocolate.get(i);
				chocolateList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < wine.size(); i++) {
				FreshDrink p = wine.get(i);
				wineList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < whiskey.size(); i++) {
				FreshDrink p = whiskey.get(i);
				whiskeyList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < spirits.size(); i++) {
				FreshDrink p = spirits.get(i);
				spiritsList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < beer.size(); i++) {
				FreshDrink p = beer.get(i);
				beerList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < juice.size(); i++) {
				FreshDrink p = juice.get(i);
				juiceList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < water.size(); i++) {
				FreshDrink p = water.get(i);
				waterList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			
			
			
			
			JComboBox<String> selectAppetisez = new JComboBox<>(appetisezList);
			JComboBox<String> selectDish = new JComboBox<>(dishList);
			JComboBox<String> selectDessert = new JComboBox<>(dessertList);
			JComboBox<String> selectCoffee = new JComboBox<>(coffeeList);
			JComboBox<String> selectTea = new JComboBox<>(teaList);
			JComboBox<String> selectChocolate = new JComboBox<>(chocolateList);
			JComboBox<String> selectWine = new JComboBox<>(wineList);
			JComboBox<String> selectWhiskey = new JComboBox<>(whiskeyList);
			JComboBox<String> selectSpirit = new JComboBox<>(spiritsList);
			JComboBox<String> selectBeer = new JComboBox<>(beerList);
			JComboBox<String> selectJuice = new JComboBox<>(juiceList);
			JComboBox<String> selectWater = new JComboBox<>(waterList);
			
			comboBoxes.put("appetisezLunch", selectAppetisez);
			comboBoxes.put("dishLunch", selectDish);
			comboBoxes.put("dessertLunch", selectDessert);
			comboBoxes.put("coffeeLunch", selectCoffee);
			comboBoxes.put("teaLunch", selectTea);
			comboBoxes.put("chocolateLunch", selectChocolate);
			comboBoxes.put("wineLunch", selectWine);
			comboBoxes.put("whiskeyLunch", selectWhiskey);
			comboBoxes.put("spiritLunch", selectSpirit);
			comboBoxes.put("beerLunch", selectBeer);
			comboBoxes.put("juiceLunch", selectJuice);
			comboBoxes.put("waterLunch", selectWater);
			
			ComboBoxHandler comboBoxHandler = new ComboBoxHandler();
			selectAppetisez.addActionListener( comboBoxHandler );
			selectDish.addActionListener( comboBoxHandler );
			selectDessert.addActionListener( comboBoxHandler );
			selectCoffee.addActionListener( comboBoxHandler );
			selectTea.addActionListener( comboBoxHandler );
			selectChocolate.addActionListener( comboBoxHandler );
			selectWine.addActionListener( comboBoxHandler );
			selectWhiskey.addActionListener( comboBoxHandler );
			selectSpirit.addActionListener( comboBoxHandler );
			selectBeer.addActionListener( comboBoxHandler );
			selectJuice.addActionListener( comboBoxHandler );
			selectWater.addActionListener( comboBoxHandler );
			
			String[] columnNames = {"ID#","Type","Name","Price(FCFA)","Amount","Total"};
			DefaultTableModel tableModel = new DefaultTableModel();
			JTable table = new JTable(tableModel){
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		        }
			};
			tableModel.setColumnIdentifiers(columnNames);
			ArrayList<JPanel> lists = new ArrayList<JPanel>();
			ArrayList<JComboBox<String>> combo = new ArrayList<JComboBox<String>>();
			JLabel name[] = {labels.get("appetisezTitle1"),labels.get("dishTitle1"),labels.get("dessertTitle1"),labels.get("coffeeTitle1"),
					labels.get("teaTitle1"),labels.get("chocolateTitle1"),labels.get("wineTitle1"),labels.get("whiskeyTitle1"),labels.get("spiritTitle1"),
					labels.get("beerTitle1"),labels.get("juiceTitle1"),labels.get("waterTitle1")};
			combo.add(selectAppetisez);
			combo.add(selectDish);
			combo.add(selectDessert);
			combo.add(selectCoffee);
			combo.add(selectTea);
			combo.add(selectChocolate);
			combo.add(selectWine);
			combo.add(selectWhiskey);
			combo.add(selectSpirit);
			combo.add(selectBeer);
			combo.add(selectJuice);
			combo.add(selectWater);
			for (int i=0; i<12; i++) {
				JPanel l = new JPanel(new GridLayout(0,1,0,0));
				l.add(name[i]);
				l.add(combo.get(i));
				lists.add(l);
			}
			combo.clear();
			JScrollPane sp = new JScrollPane();
			table.setPreferredScrollableViewportSize(new Dimension(500,180));
	        table.setFillsViewportHeight(true);
			
			JPanel optionMenu = new JPanel(new GridLayout(0,4,0,0));
			for (int i=0; i<12; i++) {
				optionMenu.add(lists.get(i));
			}
			
			JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER, 50,0));
			JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,500,10));
			JPanel amountPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
			
			table.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 2) {
		            	Object[] options = {"Yes", "No","Cancel"};
		            	// to detect double click events
		               JTable target = (JTable)me.getSource();
		               int row = target.getSelectedRow(); // select a row
		               String type = (String) table.getValueAt(row, 1);
		               int id = Integer.parseInt((String)table.getValueAt(row, 0)) - 1;
		              int value = JOptionPane.showOptionDialog(null, 
		            		  "Do you really want to remove from the order: " + table.getValueAt(row, 2) + " x" + table.getValueAt(row, 4),
		            		  "Deletion",
		            		  JOptionPane.YES_NO_CANCEL_OPTION,
		            		  JOptionPane.WARNING_MESSAGE,
		            		  null,
		            		  options,
		            		  options[0]);
		              
		              if(value == 0) {
		            	  
							tableModel.removeRow(row);
							
							items.get(type).get(id).setAmount(0);
							JLabel total = labels.get("totalTitle1");
							double total2 = 0;
			                for(int i = 0; i < tableModel.getRowCount(); i++){
			                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
			                    total2 = Amount+total2;
			                }
			                JButton orderButton = buttons.get("addOrder1");
			                if(tableModel.getRowCount() == 0)
			                	orderButton.setVisible(false);
			                
							total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
							JOptionPane.showMessageDialog(null,"Deleted!");
							
		              }
		            }
		         }
		      });
			
		
			amountPanel.add(labels.get("totalTitle1"));
			amountPanel.add(buttons.get("addOrder1"));
			amountPanel.add(labels.get("deleteTitle1"));
			title.add(buttons.get("returnLeft6"));
			title.add(labels.get("lunchTitle"));
			mainMenu.add(title);
			mainMenu.add(sp.add(optionMenu));
			mainMenu.add(amountPanel);
			mainMenu.add(new JScrollPane(table));
			tables.put("lunchTable",table);
			panels.put("lunchOrder",mainMenu);
		}
		
		@SuppressWarnings("unchecked")
		public void dinnerOrderPage() throws Exception {
			ArrayList<Appetisez> appetisezs = (ArrayList<Appetisez>)((ArrayList<?>)items.get("APPETISEZ"));
			ArrayList<Dish> dishes = (ArrayList<Dish>)((ArrayList<?>)items.get("DISH"));
			ArrayList<Dessert> desserts = (ArrayList<Dessert>)((ArrayList<?>)items.get("DESSERT"));
			ArrayList<Cafe> coffee = (ArrayList<Cafe>)((ArrayList<?>)items.get("COFFEE"));
			ArrayList<Cafe> tea = (ArrayList<Cafe>)((ArrayList<?>)items.get("TEA"));
			ArrayList<Cafe> chocolate = (ArrayList<Cafe>)((ArrayList<?>)items.get("CHOCOLATE"));
			ArrayList<FreshDrink> wine = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("WINE"));
			ArrayList<FreshDrink> whiskey = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("WHISKEY"));
			ArrayList<FreshDrink> spirits = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("SPIRITS"));
			ArrayList<FreshDrink> beer = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("BEER"));
			ArrayList<FreshDrink> juice = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("JUICE"));
			ArrayList<FreshDrink> water = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("WATER"));
			
		
			
			String appetisezList[] = new String[appetisezs.size()];
			String dishList[] = new String[dishes.size()];
			String dessertList[] = new String[desserts.size()];
			String coffeeList[] = new String[coffee.size()];
			String teaList[] = new String[tea.size()];
			String chocolateList[] = new String[chocolate.size()];
			String wineList[] = new String[wine.size()];
			String whiskeyList[] = new String[whiskey.size()];
			String spiritsList[] = new String[spirits.size()];
			String beerList[] = new String[beer.size()];
			String juiceList[] = new String[juice.size()];
			String waterList[] = new String[water.size()];
			for(int i=0; i < appetisezs.size(); i++) {
				Appetisez p = appetisezs.get(i);
				appetisezList[i] = p.getDescription() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < dishes.size(); i++) {
				Dish p = dishes.get(i);
				dishList[i] = p.getDescription() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < desserts.size(); i++) {
				Dessert p = desserts.get(i);
				dessertList[i] = p.getDescription() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < coffee.size(); i++) {
				Cafe p = coffee.get(i);
				coffeeList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < tea.size(); i++) {
				Cafe p = tea.get(i);
				teaList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			
			for(int i=0; i < chocolate.size(); i++) {
				Cafe p = chocolate.get(i);
				chocolateList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < wine.size(); i++) {
				FreshDrink p = wine.get(i);
				wineList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < whiskey.size(); i++) {
				FreshDrink p = whiskey.get(i);
				whiskeyList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < spirits.size(); i++) {
				FreshDrink p = spirits.get(i);
				spiritsList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < beer.size(); i++) {
				FreshDrink p = beer.get(i);
				beerList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < juice.size(); i++) {
				FreshDrink p = juice.get(i);
				juiceList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < water.size(); i++) {
				FreshDrink p = water.get(i);
				waterList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			
			
			
			
			JComboBox<String> selectAppetisez2 = new JComboBox<>(appetisezList);
			JComboBox<String> selectDish2 = new JComboBox<>(dishList);
			JComboBox<String> selectDessert2 = new JComboBox<>(dessertList);
			JComboBox<String> selectCoffee2 = new JComboBox<>(coffeeList);
			JComboBox<String> selectTea2 = new JComboBox<>(teaList);
			JComboBox<String> selectChocolate2 = new JComboBox<>(chocolateList);
			JComboBox<String> selectWine2 = new JComboBox<>(wineList);
			JComboBox<String> selectWhiskey2 = new JComboBox<>(whiskeyList);
			JComboBox<String> selectSpirit2 = new JComboBox<>(spiritsList);
			JComboBox<String> selectBeer2 = new JComboBox<>(beerList);
			JComboBox<String> selectJuice2 = new JComboBox<>(juiceList);
			JComboBox<String> selectWater2 = new JComboBox<>(waterList);
			
			comboBoxes.put("appetisezDinner", selectAppetisez2);
			comboBoxes.put("dishDinner", selectDish2);
			comboBoxes.put("dessertDinner", selectDessert2);
			comboBoxes.put("coffeeDinner", selectCoffee2);
			comboBoxes.put("teaDinner", selectTea2);
			comboBoxes.put("chocolateDinner", selectChocolate2);
			comboBoxes.put("wineDinner", selectWine2);
			comboBoxes.put("whiskeyDinner", selectWhiskey2);
			comboBoxes.put("spiritDinner", selectSpirit2);
			comboBoxes.put("beerDinner", selectBeer2);
			comboBoxes.put("juiceDinner", selectJuice2);
			comboBoxes.put("waterDinner", selectWater2);
			
			ComboBoxHandler comboBoxHandler = new ComboBoxHandler();
			selectAppetisez2.addActionListener( comboBoxHandler );
			selectDish2.addActionListener( comboBoxHandler );
			selectDessert2.addActionListener( comboBoxHandler );
			selectCoffee2.addActionListener( comboBoxHandler );
			selectTea2.addActionListener( comboBoxHandler );
			selectChocolate2.addActionListener( comboBoxHandler );
			selectWine2.addActionListener( comboBoxHandler );
			selectWhiskey2.addActionListener( comboBoxHandler );
			selectSpirit2.addActionListener( comboBoxHandler );
			selectBeer2.addActionListener( comboBoxHandler );
			selectJuice2.addActionListener( comboBoxHandler );
			selectWater2.addActionListener( comboBoxHandler );
			
			String[] columnNames = {"ID#","Type","Name","Price(FCFA)","Amount","Total"};
			DefaultTableModel tableModel = new DefaultTableModel();
			JTable table = new JTable(tableModel){
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		        }
			};
			tableModel.setColumnIdentifiers(columnNames);
			ArrayList<JPanel> lists = new ArrayList<JPanel>();
			ArrayList<JComboBox<String>> combo = new ArrayList<JComboBox<String>>();
			JLabel name[] = {labels.get("appetisezTitle2"),labels.get("dishTitle2"),labels.get("dessertTitle2"),labels.get("coffeeTitle2"),
					labels.get("teaTitle2"),labels.get("chocolateTitle2"),labels.get("wineTitle2"),labels.get("whiskeyTitle2"),labels.get("spiritTitle2"),
					labels.get("beerTitle2"),labels.get("juiceTitle2"),labels.get("waterTitle2")};
			combo.add(selectAppetisez2);
			combo.add(selectDish2);
			combo.add(selectDessert2);
			combo.add(selectCoffee2);
			combo.add(selectTea2);
			combo.add(selectChocolate2);
			combo.add(selectWine2);
			combo.add(selectWhiskey2);
			combo.add(selectSpirit2);
			combo.add(selectBeer2);
			combo.add(selectJuice2);
			combo.add(selectWater2);
			for (int i=0; i<12; i++) {
				JPanel l = new JPanel(new GridLayout(0,1,0,0));
				l.add(name[i]);
				l.add(combo.get(i));
				lists.add(l);
			}
			combo.clear();
			JScrollPane sp = new JScrollPane();
			table.setPreferredScrollableViewportSize(new Dimension(500,180));
	        table.setFillsViewportHeight(true);
			
			JPanel optionMenu = new JPanel(new GridLayout(0,4,0,0));
			for (int i=0; i<12; i++) {
				optionMenu.add(lists.get(i));
			}
			
			
			
			JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER, 50,0));
			JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,500,10));
			JPanel amountPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
			
			table.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 2) {
		            	Object[] options = {"Yes", "No","Cancel"};
		            	// to detect double click events
		               JTable target = (JTable)me.getSource();
		               int row = target.getSelectedRow(); // select a row
		               String type = (String) table.getValueAt(row, 1);
		               int id = Integer.parseInt((String)table.getValueAt(row, 0)) - 1;
		              int value = JOptionPane.showOptionDialog(null, 
		            		  "Do you really want to remove from the order: " + table.getValueAt(row, 2) + " x" + table.getValueAt(row, 4),
		            		  "Deletion",
		            		  JOptionPane.YES_NO_CANCEL_OPTION,
		            		  JOptionPane.WARNING_MESSAGE,
		            		  null,
		            		  options,
		            		  options[0]);
		              
		              if(value == 0) {
		            	  
							tableModel.removeRow(row);
							items.get(type).get(id).setAmount(0);
							JLabel total = labels.get("totalTitle2");
							double total2 = 0;
			                for(int i = 0; i < tableModel.getRowCount(); i++){
			                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
			                    total2 = Amount+total2;
			                }
			                JButton orderButton = buttons.get("addOrder2");
			                if(tableModel.getRowCount() == 0)
			                	orderButton.setVisible(false);
			                
							total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
							JOptionPane.showMessageDialog(null,"Deleted!");
							
		              }
		            }
		         }
		      });
			
		
			amountPanel.add(labels.get("totalTitle2"));
			amountPanel.add(buttons.get("addOrder2"));
			amountPanel.add(labels.get("deleteTitle2"));
			title.add(buttons.get("returnRight6"));
			title.add(labels.get("dinnerTitle"));
			mainMenu.add(title);
			mainMenu.add(sp.add(optionMenu));
			mainMenu.add(amountPanel);
			mainMenu.add(new JScrollPane(table));
			tables.put("dinnerTable",table);
			panels.put("dinnerOrder",mainMenu);
		}
		
		@SuppressWarnings("unchecked")
		public void breakFastOrderPage() throws Exception {
			ArrayList<BreakFast> breakFasts = model.getBreakFasts();
			
			String breakFastList[] = new String[breakFasts.size()];
			
			for(int i=0; i < breakFasts.size(); i++) {
				BreakFast p = breakFasts.get(i);
				breakFastList[i] = p.getFormula() + "/" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			JComboBox<String> selectBreakFast = new JComboBox<>(breakFastList);
			comboBoxes.put("breakFast", selectBreakFast);
			BreakFastHandler breakFastHandler = new BreakFastHandler();
			selectBreakFast.addActionListener( breakFastHandler );
			
			JLabel name = labels.get("breakFast3Title");
			
				JPanel optionMenu = new JPanel(new GridLayout(0,1,0,0));
				optionMenu.add(name);
				optionMenu.add(selectBreakFast);
			
		
			JScrollPane sp = new JScrollPane();
			
			JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER, 50,0));
			JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,500,10));
			JLabel select = new JLabel("SELECT A BREAKFAST");
		
			title.add(buttons.get("returnLeft7"));
			title.add(labels.get("breakFast2Title"));
			mainMenu.add(title);
			mainMenu.add(select);
			mainMenu.add(sp.add(optionMenu));

			panels.put("breakFastOrder",mainMenu);
		}
	
		@SuppressWarnings("unchecked")
		public void drinksOrderPage() throws Exception {
			ArrayList<Cafe> coffee = (ArrayList<Cafe>)((ArrayList<?>)items.get("COFFEE"));
			ArrayList<Cafe> tea = (ArrayList<Cafe>)((ArrayList<?>)items.get("TEA"));
			ArrayList<Cafe> chocolate = (ArrayList<Cafe>)((ArrayList<?>)items.get("CHOCOLATE"));
			ArrayList<FreshDrink> wine = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("WINE"));
			ArrayList<FreshDrink> whiskey = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("WHISKEY"));
			ArrayList<FreshDrink> spirits = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("SPIRITS"));
			ArrayList<FreshDrink> beer = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("BEER"));
			ArrayList<FreshDrink> juice = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("JUICE"));
			ArrayList<FreshDrink> water = (ArrayList<FreshDrink>)((ArrayList<?>)items.get("WATER"));
			
			String coffeeList[] = new String[coffee.size()];
			String teaList[] = new String[tea.size()];
			String chocolateList[] = new String[chocolate.size()];
			String wineList[] = new String[wine.size()];
			String whiskeyList[] = new String[whiskey.size()];
			String spiritsList[] = new String[spirits.size()];
			String beerList[] = new String[beer.size()];
			String juiceList[] = new String[juice.size()];
			String waterList[] = new String[water.size()];
			
			
			for(int i=0; i < coffee.size(); i++) {
				Cafe p = coffee.get(i);
				coffeeList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < tea.size(); i++) {
				Cafe p = tea.get(i);
				teaList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			
			for(int i=0; i < chocolate.size(); i++) {
				Cafe p = chocolate.get(i);
				chocolateList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < wine.size(); i++) {
				FreshDrink p = wine.get(i);
				wineList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < whiskey.size(); i++) {
				FreshDrink p = whiskey.get(i);
				whiskeyList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < spirits.size(); i++) {
				FreshDrink p = spirits.get(i);
				spiritsList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < beer.size(); i++) {
				FreshDrink p = beer.get(i);
				beerList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < juice.size(); i++) {
				FreshDrink p = juice.get(i);
				juiceList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			for(int i=0; i < water.size(); i++) {
				FreshDrink p = water.get(i);
				waterList[i] = p.getName() + "-" + Double.toString(p.getPrice())+ "FCFA";
			}
			
			
			
			JComboBox<String> selectCoffee3 = new JComboBox<>(coffeeList);
			JComboBox<String> selectTea3 = new JComboBox<>(teaList);
			JComboBox<String> selectChocolate3 = new JComboBox<>(chocolateList);
			JComboBox<String> selectWine3 = new JComboBox<>(wineList);
			JComboBox<String> selectWhiskey3 = new JComboBox<>(whiskeyList);
			JComboBox<String> selectSpirit3 = new JComboBox<>(spiritsList);
			JComboBox<String> selectBeer3 = new JComboBox<>(beerList);
			JComboBox<String> selectJuice3 = new JComboBox<>(juiceList);
			JComboBox<String> selectWater3 = new JComboBox<>(waterList);
			
			
			comboBoxes.put("coffeeDrinks", selectCoffee3);
			comboBoxes.put("teaDrinks", selectTea3);
			comboBoxes.put("chocolateDrinks", selectChocolate3);
			comboBoxes.put("wineDrinks", selectWine3);
			comboBoxes.put("whiskeyDrinks", selectWhiskey3);
			comboBoxes.put("spiritDrinks", selectSpirit3);
			comboBoxes.put("beerDrinks", selectBeer3);
			comboBoxes.put("juiceDrinks", selectJuice3);
			comboBoxes.put("waterDrinks", selectWater3);
			
			ComboBoxHandler comboBoxHandler = new ComboBoxHandler();
			
			selectCoffee3.addActionListener( comboBoxHandler );
			selectTea3.addActionListener( comboBoxHandler );
			selectChocolate3.addActionListener( comboBoxHandler );
			selectWine3.addActionListener( comboBoxHandler );
			selectWhiskey3.addActionListener( comboBoxHandler );
			selectSpirit3.addActionListener( comboBoxHandler );
			selectBeer3.addActionListener( comboBoxHandler );
			selectJuice3.addActionListener( comboBoxHandler );
			selectWater3.addActionListener( comboBoxHandler );
			
			String[] columnNames = {"ID#","Type","Name","Price(FCFA)","Amount","Total"};
			DefaultTableModel tableModel = new DefaultTableModel();
			JTable table = new JTable(tableModel){
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		        }
			};
			tableModel.setColumnIdentifiers(columnNames);
			ArrayList<JPanel> lists = new ArrayList<JPanel>();
			ArrayList<JComboBox<String>> combo = new ArrayList<JComboBox<String>>();
			JLabel name[] = {labels.get("coffeeTitle3"),labels.get("teaTitle3"),labels.get("chocolateTitle3"),
					labels.get("wineTitle3"),labels.get("whiskeyTitle3"),labels.get("spiritTitle3"),
					labels.get("beerTitle3"),labels.get("juiceTitle3"),labels.get("waterTitle3")};
			
			combo.add(selectCoffee3);
			combo.add(selectTea3);
			combo.add(selectChocolate3);
			combo.add(selectWine3);
			combo.add(selectWhiskey3);
			combo.add(selectSpirit3);
			combo.add(selectBeer3);
			combo.add(selectJuice3);
			combo.add(selectWater3);
			for (int i=0; i<9; i++) {
				JPanel l = new JPanel(new GridLayout(0,1,0,0));
				System.out.println(name[i].getText());
				l.add(name[i]);
				l.add(combo.get(i));
				lists.add(l);
			}
			combo.clear();
			JScrollPane sp = new JScrollPane();
			table.setPreferredScrollableViewportSize(new Dimension(500,180));
	        table.setFillsViewportHeight(true);
			
			JPanel optionMenu = new JPanel(new GridLayout(0,3,0,0));
			for (int i=0; i<lists.size(); i++) {
				optionMenu.add(lists.get(i));
			}
			
			JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER, 50,0));
			JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,500,10));
			JPanel amountPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
			
			table.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 2) {
		            	Object[] options = {"Yes", "No","Cancel"};
		            	// to detect double click events
		               JTable target = (JTable)me.getSource();
		               int row = target.getSelectedRow(); // select a row
		               String type = (String) table.getValueAt(row, 1);
		               int id = Integer.parseInt((String)table.getValueAt(row, 0)) - 1;
		              int value = JOptionPane.showOptionDialog(null, 
		            		  "Do you really want to remove from the order: " + table.getValueAt(row, 2) + " x" + table.getValueAt(row, 4),
		            		  "Deletion",
		            		  JOptionPane.YES_NO_CANCEL_OPTION,
		            		  JOptionPane.WARNING_MESSAGE,
		            		  null,
		            		  options,
		            		  options[0]);
		              
		              if(value == 0) {
		            	  
							tableModel.removeRow(row);
							
							items.get(type).get(id).setAmount(0);
							JLabel total = labels.get("totalTitle3");
							double total2 = 0;
			                for(int i = 0; i < tableModel.getRowCount(); i++){
			                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
			                    total2 = Amount+total2;
			                }
			                JButton orderButton = buttons.get("addOrder3");
			                if(tableModel.getRowCount() == 0)
			                	orderButton.setVisible(false);
			                
							total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
							JOptionPane.showMessageDialog(null,"Deleted!");
							
		              }
		            }
		         }
		      });
			
		
			amountPanel.add(labels.get("totalTitle3"));
			amountPanel.add(buttons.get("addOrder3"));
			amountPanel.add(labels.get("deleteTitle3"));
			title.add(buttons.get("returnRight7"));
			title.add(labels.get("drinksTitle"));
			mainMenu.add(title);
			mainMenu.add(sp.add(optionMenu));
			mainMenu.add(amountPanel);
			mainMenu.add(new JScrollPane(table));
			tables.put("drinksTable",table);
			panels.put("drinksOrder",mainMenu);
		}
	private class HomeButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			if(event.getSource() == buttons.get("admin")) {
				removePage("home");
				goTo("admin");
				
			}
			
			if(event.getSource() == buttons.get("order")) {
				removePage("home");
				invalidate();
				goTo("order");
				validate();
				repaint();
				
			}
			
		}
		
	}
	
	private class ReturnButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
				String removePage = stackOfStates.pop();
				String nextPage = stackOfStates.pop();
				removePage(removePage);
				goTo(nextPage);
				
			
			
			
		}
		
	}
	
	private class AdminButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			if(event.getSource() == buttons.get("invoice")) {
				removePage("admin");
				goTo("invoice");

				
			}
			
			if(event.getSource() == buttons.get("item")) {
				removePage("admin");
				goTo("itemManage");

				
			}
			
		}
		
	}
	
	
	private class ItemManageButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			if(event.getSource() == buttons.get("breakFast2")) {
				removePage("itemManage");
				goTo("addBreakFast");

				
			}
			
			if(event.getSource() == buttons.get("appetisez2")) {
				removePage("itemManage");
				goTo("addAppetisez");
				
			}
			
			if(event.getSource() == buttons.get("dish2")) {
				removePage("itemManage");
				goTo("addDish");
				
			}
			
			if(event.getSource() == buttons.get("dessert2")) {
				removePage("itemManage");
				goTo("addDessert");
				
			}
			
			if(event.getSource() == buttons.get("freshDrink2")) {
				removePage("itemManage");
				goTo("addFreshDrink");
				
			}
			
			if(event.getSource() == buttons.get("cafe2")) {
				removePage("itemManage");
				goTo("addCafe");
				
			}
			
		}
		
	}
	
	private class ItemOrderButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if(event.getSource() == buttons.get("breakFast")) {
				removePage("order");
				goTo("breakFastOrder");

				
			}
			
			if(event.getSource() == buttons.get("lunch")) {
				removePage("order");
				goTo("lunchOrder");
				
			}
			
			if(event.getSource() == buttons.get("dinner")) {
				removePage("order");
				goTo("dinnerOrder");
				
			}
			
			
			
			if(event.getSource() == buttons.get("drinks")) {
				removePage("order");
				goTo("drinksOrder");
				
			}
			
			if(event.getSource() == buttons.get("cafe")) {
				removePage("order");
				goTo("cafeOrder");
				
			}
		}
		
	}
	
	private class OrderButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if(event.getSource() == buttons.get("addOrder1")) {
				String element[] = {"APPETISEZ","DISH","DESSERT","COFFEE",
						"TEA","CHOCOLATE","WINE","WHISKEY",
						"SPIRITS","BEER","JUICE","WATER"};
				ArrayList<Item> listOrder = new ArrayList<Item>();
				for(int i=0; i< items.size(); i++) {
					ArrayList<Item> item = items.get(element[i]);
					
					for(int j=0; j< item.size(); j++) {
						if(item.get(j).getAmount() != 0) {
							listOrder.add(item.get(j));
						}
					}
				}	
				
				
				
					try {
						Order.setCount(model.getLastInvoiceId());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Lunch lunchMenu = new Lunch();
					Order order = new Order();
					lunchMenu.setItems(listOrder);
					order.setMenu(lunchMenu);
					try {
						order.makeInvoice();
						model.insertInvoice(order.getInvoice());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null,order.getInvoice().getDocInvoice().getName()+" created succesfully");
					JTable t = tables.get("lunchTable");
					DefaultTableModel model = (DefaultTableModel) t.getModel();
					model.setRowCount(0);
					JLabel total = labels.get("totalTitle1");
					JButton orderButton = buttons.get("addOrder1");
					orderButton.setVisible(false);
					
					total.setText("TOTAL: 0.0 FCFA");
					for(int i=0; i< items.size(); i++) {
						ArrayList<Item> item = items.get(element[i]);
						
						for(int j=0; j< item.size(); j++) {
							item.get(j).setAmount(0);
						}
					}
						
				

				
			}
			
			if(event.getSource() == buttons.get("addOrder2")) {
				String element[] = {"APPETISEZ","DISH","DESSERT","COFFEE",
						"TEA","CHOCOLATE","WINE","WHISKEY",
						"SPIRITS","BEER","JUICE","WATER"};
				ArrayList<Item> listOrder = new ArrayList<Item>();
				for(int i=0; i< items.size(); i++) {
					ArrayList<Item> item = items.get(element[i]);
					
					for(int j=0; j< item.size(); j++) {
						if(item.get(j).getAmount() != 0) {
							listOrder.add(item.get(j));
						}
					}
				}	
				
					try {
						Order.setCount(model.getLastInvoiceId());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Dinner dinnerMenu = new Dinner();
					Order order = new Order();
					dinnerMenu.setItems(listOrder);
					order.setMenu(dinnerMenu);
					try {
						order.makeInvoice();
						model.insertInvoice(order.getInvoice());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null,order.getInvoice().getDocInvoice().getName()+" created succesfully");
					
					JTable t = tables.get("dinnerTable");
					DefaultTableModel model = (DefaultTableModel) t.getModel();
					model.setRowCount(0);
					JLabel total = labels.get("totalTitle2");
					JButton orderButton = buttons.get("addOrder2");
					orderButton.setVisible(false);
					
					total.setText("TOTAL: 0.0 FCFA");
					for(int i=0; i< items.size(); i++) {
						ArrayList<Item> item = items.get(element[i]);
						
						for(int j=0; j< item.size(); j++) {
							item.get(j).setAmount(0);
						}
					}
				

				
			}
			
			if(event.getSource() == buttons.get("addOrder3")) {
				String element[] = {"COFFEE","TEA","CHOCOLATE",
						"WINE","WHISKEY","SPIRITS",
						"BEER","JUICE","WATER"};
				ArrayList<Drink> drinksOrder = new ArrayList<Drink>();
				for(int i=0; i< 9; i++) {
					ArrayList<Drink> item = (ArrayList<Drink>)((ArrayList<?>)items.get(element[i]));
					
					for(int j=0; j< item.size(); j++) {
						if(item.get(j).getAmount() != 0) {
							drinksOrder.add(item.get(j));
						}
					}
				}	
				
					try {
						Order.setCount(model.getLastInvoiceId());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					Order order = new Order();
					order.setDrinks(drinksOrder);
					try {
						order.makeInvoice();
						model.insertInvoice(order.getInvoice());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null,order.getInvoice().getDocInvoice().getName()+" created succesfully");
					
					JTable t = tables.get("drinksTable");
					DefaultTableModel model = (DefaultTableModel) t.getModel();
					model.setRowCount(0);
					JLabel total = labels.get("totalTitle3");
					JButton orderButton = buttons.get("addOrder3");
					orderButton.setVisible(false);
					
					total.setText("TOTAL: 0.0 FCFA");
					for(int i=0; i< 9; i++) {
						ArrayList<Item> item = items.get(element[i]);
						
						for(int j=0; j< item.size(); j++) {
							item.get(j).setAmount(0);
						}
					}
				

				
			}
			
			
			
			
			
			
		}
		
	}
	
	private class BreakFastHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			JComboBox comboBox = (JComboBox) event.getSource();
			String item = (String)comboBox.getSelectedItem();
            int id = comboBox.getSelectedIndex();
            ArrayList<BreakFast> breakFasts;
			try {
				breakFasts = model.getBreakFasts();
				BreakFast breakFast = breakFasts.get(id);
				String amount = JOptionPane.showInputDialog("Enter the number of " + item);
				if(amount != null) {
	                breakFast.setAmount(Integer.parseInt(amount));
	                Object[] options = {"Yes", "No","Cancel"};
	                int value = JOptionPane.showOptionDialog(null, 
		            		  "Do you really want to order " + amount + " "+breakFast.getFormula()+" ?",
		            		  "Deletion",
		            		  JOptionPane.YES_NO_CANCEL_OPTION,
		            		  JOptionPane.WARNING_MESSAGE,
		            		  null,
		            		  options,
		            		  options[0]);
	                
	                if(value == 0) {
		                try {
							Order.setCount(model.getLastInvoiceId());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						Order order = new Order();
						order.setMenu(breakFast);
						try {
							order.makeInvoice();
							model.insertInvoice(order.getInvoice());
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(null,order.getInvoice().getDocInvoice().getName()+" created succesfully");
	                }
				
                }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
		}
		
	}
	
	private class InvoiceHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			JComboBox comboBox = (JComboBox) event.getSource();
			String item = (String)comboBox.getSelectedItem();
            int id = comboBox.getSelectedIndex();
            ArrayList<Invoice> invoices;
			try {
				
				invoices = model.getInvoices();
				Invoice invoice = invoices.get(id);
				
				Desktop.getDesktop().open(invoice.getDocInvoice());
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
		}
		
	}
	
	private class ComboBoxHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if(event.getSource() == comboBoxes.get("appetisezLunch")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("lunchTable").getModel();
                JLabel total = labels.get("totalTitle1");
                JButton orderButton = buttons.get("addOrder1");
                Appetisez appetisez = (Appetisez) items.get("APPETISEZ").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
               
                appetisez.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"APPETISEZ",appetisez.getDescription(),appetisez.getPrice(),amount,Double.toString(appetisez.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("dishLunch")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("lunchTable").getModel();
                JLabel total = labels.get("totalTitle1");
                JButton orderButton = buttons.get("addOrder1");
                Dish dish = (Dish) items.get("DISH").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
                dish.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"DISH",dish.getDescription(),dish.getPrice(),amount,Double.toString(dish.total())});
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("dessertLunch")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("lunchTable").getModel();
                JLabel total = labels.get("totalTitle1");
                JButton orderButton = buttons.get("addOrder1");
                Dessert dessert = (Dessert) items.get("DESSERT").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
            
                dessert.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"DESSERT",dessert.getDescription(),dessert.getPrice(),amount,Double.toString(dessert.total())});
	
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("coffeeLunch")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("lunchTable").getModel();
                JLabel total = labels.get("totalTitle1");
                JButton orderButton = buttons.get("addOrder1");
                Cafe coffee = (Cafe) items.get("COFFEE").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
                
                coffee.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"COFFEE",coffee.getName(),coffee.getPrice(),amount,Double.toString(coffee.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("teaLunch")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("lunchTable").getModel();
                JLabel total = labels.get("totalTitle1");
                JButton orderButton = buttons.get("addOrder1");
                Cafe tea = (Cafe) items.get("TEA").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
                
                tea.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"TEA",tea.getName(),tea.getPrice(),amount,Double.toString(tea.total())});
	               
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("chocolateLunch")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("lunchTable").getModel();
                JLabel total = labels.get("totalTitle1");
                JButton orderButton = buttons.get("addOrder1");
                Cafe chocolate = (Cafe) items.get("CHOCOLATE").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
               
                chocolate.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"CHOCOLATE",chocolate.getName(),chocolate.getPrice(),amount,Double.toString(chocolate.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("wineLunch")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("lunchTable").getModel();
                JLabel total = labels.get("totalTitle1");
                JButton orderButton = buttons.get("addOrder1");
                FreshDrink wine = (FreshDrink) items.get("WINE").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
                
                wine.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"WINE",wine.getName(),wine.getPrice(),amount,Double.toString(wine.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("whiskeyLunch")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("lunchTable").getModel();
                JLabel total = labels.get("totalTitle1");
                JButton orderButton = buttons.get("addOrder1");
                FreshDrink whiskey = (FreshDrink) items.get("WHISKEY").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);

                whiskey.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"WHISKEY",whiskey.getName(),whiskey.getPrice(),amount,Double.toString(whiskey.total())});
	               
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("spiritLunch")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("lunchTable").getModel();
                JLabel total = labels.get("totalTitle1");
                JButton orderButton = buttons.get("addOrder1");
                FreshDrink spirit = (FreshDrink) items.get("SPIRITS").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
              
                spirit.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"SPIRITS",spirit.getName(),spirit.getPrice(),amount,Double.toString(spirit.total())});
	            
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("beerLunch")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("lunchTable").getModel();
                JLabel total = labels.get("totalTitle1");
                JButton orderButton = buttons.get("addOrder1");
                FreshDrink beer = (FreshDrink) items.get("BEER").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
        
                beer.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"BEER",beer.getName(),beer.getPrice(),amount,Double.toString(beer.total())});
	               
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("juiceLunch")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("lunchTable").getModel();
                JLabel total = labels.get("totalTitle1");
                JButton orderButton = buttons.get("addOrder1");
                FreshDrink juice = (FreshDrink) items.get("JUICE").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
              
                juice.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"JUICE",juice.getName(),juice.getPrice(),amount,Double.toString(juice.total())});
	               
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("waterLunch")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("lunchTable").getModel();
                JLabel total = labels.get("totalTitle1");
                JButton orderButton = buttons.get("addOrder1");
                FreshDrink water = (FreshDrink) items.get("WATER").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
              
                water.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"WATER",water.getName(),water.getPrice(),amount,Double.toString(water.total())});
	               
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
		
			if(event.getSource() == comboBoxes.get("appetisezDinner")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("dinnerTable").getModel();
                JLabel total = labels.get("totalTitle2");
                JButton orderButton = buttons.get("addOrder2");
                Appetisez appetisez = (Appetisez) items.get("APPETISEZ").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
               
                appetisez.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"APPETISEZ",appetisez.getDescription(),appetisez.getPrice(),amount,Double.toString(appetisez.total())});
	               
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("dishDinner")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("dinnerTable").getModel();
                JLabel total = labels.get("totalTitle2");
                JButton orderButton = buttons.get("addOrder2");
                Dish dish = (Dish) items.get("DISH").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
              
                dish.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"DISH",dish.getDescription(),dish.getPrice(),amount,Double.toString(dish.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("dessertDinner")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("dinnerTable").getModel();
                JLabel total = labels.get("totalTitle2");
                JButton orderButton = buttons.get("addOrder2");
                Dessert dessert = (Dessert) items.get("DESSERT").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
               
                dessert.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"DESSERT",dessert.getDescription(),dessert.getPrice(),amount,Double.toString(dessert.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("coffeeDinner")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("dinnerTable").getModel();
                JLabel total = labels.get("totalTitle2");
                JButton orderButton = buttons.get("addOrder2");
                Cafe coffee = (Cafe) items.get("COFFEE").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
             
                coffee.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"COFFEE",coffee.getName(),coffee.getPrice(),amount,Double.toString(coffee.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("teaDinner")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("dinnerTable").getModel();
                JLabel total = labels.get("totalTitle2");
                JButton orderButton = buttons.get("addOrder2");
                Cafe tea = (Cafe) items.get("TEA").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
               
                tea.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"TEA",tea.getName(),tea.getPrice(),amount,Double.toString(tea.total())});
	               
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("chocolateDinner")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("dinnerTable").getModel();
                JLabel total = labels.get("totalTitle2");
                JButton orderButton = buttons.get("addOrder2");
                Cafe chocolate = (Cafe) items.get("CHOCOLATE").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
                
                chocolate.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"CHOCOLATE",chocolate.getName(),chocolate.getPrice(),amount,Double.toString(chocolate.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("wineDinner")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("dinnerTable").getModel();
                JLabel total = labels.get("totalTitle2");
                JButton orderButton = buttons.get("addOrder2");
                FreshDrink wine = (FreshDrink) items.get("WINE").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
              
                wine.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"WINE",wine.getName(),wine.getPrice(),amount,Double.toString(wine.total())});
	            
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("whiskeyDinner")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("dinnerTable").getModel();
                JLabel total = labels.get("totalTitle2");
                JButton orderButton = buttons.get("addOrder2");
                FreshDrink whiskey = (FreshDrink) items.get("WHISKEY").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
                
                whiskey.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"WHISKEY",whiskey.getName(),whiskey.getPrice(),amount,Double.toString(whiskey.total())});
	               
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("spiritDinner")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("dinnerTable").getModel();
                JLabel total = labels.get("totalTitle2");
                JButton orderButton = buttons.get("addOrder2");
                FreshDrink spirit = (FreshDrink) items.get("SPIRITS").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
               
                spirit.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"SPIRITS",spirit.getName(),spirit.getPrice(),amount,Double.toString(spirit.total())});
	               
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("beerDinner")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("dinnerTable").getModel();
                JLabel total = labels.get("totalTitle2");
                JButton orderButton = buttons.get("addOrder2");
                FreshDrink beer = (FreshDrink) items.get("BEER").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
                
                beer.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"BEER",beer.getName(),beer.getPrice(),amount,Double.toString(beer.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("juiceDinner")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("dinnerTable").getModel();
                JLabel total = labels.get("totalTitle2");
                JButton orderButton = buttons.get("addOrder2");
                FreshDrink juice = (FreshDrink) items.get("JUICE").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
                
                juice.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"JUICE",juice.getName(),juice.getPrice(),amount,Double.toString(juice.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("waterDinner")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("dinnerTable").getModel();
                JLabel total = labels.get("totalTitle2");
                JButton orderButton = buttons.get("addOrder2");
                FreshDrink water = (FreshDrink) items.get("WATER").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
               
                water.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"WATER",water.getName(),water.getPrice(),amount,Double.toString(water.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("coffeeDrinks")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("drinksTable").getModel();
                JLabel total = labels.get("totalTitle3");
                JButton orderButton = buttons.get("addOrder3");
                Cafe coffee = (Cafe) items.get("COFFEE").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
             
                coffee.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"COFFEE",coffee.getName(),coffee.getPrice(),amount,Double.toString(coffee.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("teaDrinks")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("drinksTable").getModel();
                JLabel total = labels.get("totalTitle3");
                JButton orderButton = buttons.get("addOrder3");
                Cafe tea = (Cafe) items.get("TEA").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
               
                tea.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"TEA",tea.getName(),tea.getPrice(),amount,Double.toString(tea.total())});
	               
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("chocolateDrinks")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("drinksTable").getModel();
                JLabel total = labels.get("totalTitle3");
                JButton orderButton = buttons.get("addOrder3");
                Cafe chocolate = (Cafe) items.get("CHOCOLATE").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
                
                chocolate.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"CHOCOLATE",chocolate.getName(),chocolate.getPrice(),amount,Double.toString(chocolate.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("wineDrinks")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("drinksTable").getModel();
                JLabel total = labels.get("totalTitle3");
                JButton orderButton = buttons.get("addOrder3");
                FreshDrink wine = (FreshDrink) items.get("WINE").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
              
                wine.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"WINE",wine.getName(),wine.getPrice(),amount,Double.toString(wine.total())});
	            
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("whiskeyDrinks")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("drinksTable").getModel();
                JLabel total = labels.get("totalTitle3");
                JButton orderButton = buttons.get("addOrder3");
                FreshDrink whiskey = (FreshDrink) items.get("WHISKEY").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
                
                whiskey.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"WHISKEY",whiskey.getName(),whiskey.getPrice(),amount,Double.toString(whiskey.total())});
	               
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("spiritDrinks")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("drinksTable").getModel();
                JLabel total = labels.get("totalTitle3");
                JButton orderButton = buttons.get("addOrder3");
                FreshDrink spirit = (FreshDrink) items.get("SPIRITS").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
               
                spirit.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"SPIRITS",spirit.getName(),spirit.getPrice(),amount,Double.toString(spirit.total())});
	               
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("beerDrinks")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("drinksTable").getModel();
                JLabel total = labels.get("totalTitle3");
                JButton orderButton = buttons.get("addOrder3");
                FreshDrink beer = (FreshDrink) items.get("BEER").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
                
                beer.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"BEER",beer.getName(),beer.getPrice(),amount,Double.toString(beer.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("juiceDrinks")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("drinksTable").getModel();
                JLabel total = labels.get("totalTitle3");
                JButton orderButton = buttons.get("addOrder3");
                FreshDrink juice = (FreshDrink) items.get("JUICE").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
                
                juice.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"JUICE",juice.getName(),juice.getPrice(),amount,Double.toString(juice.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
			
			if(event.getSource() == comboBoxes.get("waterDrinks")) {
				JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                DefaultTableModel tableModel = (DefaultTableModel) tables.get("drinksTable").getModel();
                JLabel total = labels.get("totalTitle3");
                JButton orderButton = buttons.get("addOrder3");
                FreshDrink water = (FreshDrink) items.get("WATER").get(id);
                String amount = JOptionPane.showInputDialog("Enter the number of " + item);
               
                water.setAmount(Integer.parseInt(amount));
                if(amount != null) {
	                int number = id + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"WATER",water.getName(),water.getPrice(),amount,Double.toString(water.total())});
	                
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                orderButton.setVisible(true);
	                repaint();

				
                }
			}
		
		
		
		
			
			
			
			
		}
	}
	
	
	
	private class ItemAdditionButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			if(event.getSource() == buttons.get("addBreakFast")) {
				JTextField formulaField = new JTextField();
		        JTextField priceField = new JTextField();
		        JPanel form = new JPanel(new GridLayout(0,1));
		        form.add(new JLabel("Formula: "));
		        form.add(formulaField);
		        form.add(new JLabel("Price: "));
		        form.add(priceField);
		        int result = JOptionPane.showConfirmDialog(null,
		        		form,
		        		"Add Break-Fast",
		        		JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		        if(result == JOptionPane.OK_OPTION) {
		        	try {
						model.insertBreakFast(new BreakFast( formulaField.getText(),Double.parseDouble(priceField.getText())));
						removePage("addBreakFast");
						panels.remove("addBreakFast");
						addBreakFastPage();
						goTo("addBreakFast");
						stackOfStates.pop();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        

				
			}
			
			if(event.getSource() == buttons.get("addAppetisez")) {
				JTextField descriptionField = new JTextField();
		        JTextField priceField = new JTextField();
		        JPanel form = new JPanel(new GridLayout(0,1));
		        form.add(new JLabel("Description: "));
		        form.add(descriptionField);
		        form.add(new JLabel("Price: "));
		        form.add(priceField);
		        int result = JOptionPane.showConfirmDialog(null,
		        		form,
		        		"Add Appetisez",
		        		JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		        if(result == JOptionPane.OK_OPTION) {
		        	try {
						model.insertAppetisez(new Appetisez( descriptionField.getText(),Double.parseDouble(priceField.getText())));
						removePage("addAppetisez");
						panels.remove("addAppetisez");
						addAppetisezPage();
						goTo("addAppetisez");
						stackOfStates.pop();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        

				
			}
			
			if(event.getSource() == buttons.get("addDish")) {
				JTextField descriptionField = new JTextField();
		        JTextField priceField = new JTextField();
		        JPanel form = new JPanel(new GridLayout(0,1));
		        form.add(new JLabel("Description: "));
		        form.add(descriptionField);
		        form.add(new JLabel("Price: "));
		        form.add(priceField);
		        int result = JOptionPane.showConfirmDialog(null,
		        		form,
		        		"Add Dish",
		        		JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		        if(result == JOptionPane.OK_OPTION) {
		        	try {
						model.insertDish(new Dish( descriptionField.getText(),Double.parseDouble(priceField.getText())));
						removePage("addDish");
						panels.remove("addDish");
						addDishPage();
						goTo("addDish");
						stackOfStates.pop();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        

				
			}
			
			if(event.getSource() == buttons.get("addDessert")) {
				JTextField descriptionField = new JTextField();
		        JTextField priceField = new JTextField();
		        JPanel form = new JPanel(new GridLayout(0,1));
		        form.add(new JLabel("Description: "));
		        form.add(descriptionField);
		        form.add(new JLabel("Price: "));
		        form.add(priceField);
		        int result = JOptionPane.showConfirmDialog(null,
		        		form,
		        		"Add Dessert",
		        		JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		        if(result == JOptionPane.OK_OPTION) {
		        	try {
						model.insertDessert(new Dessert( descriptionField.getText(),Double.parseDouble(priceField.getText())));
						removePage("addDessert");
						panels.remove("addDessert");
						addDessertPage();
						goTo("addDessert");
						stackOfStates.pop();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        

				
			}
			
			if(event.getSource() == buttons.get("addFreshDrink")) {
				String[] items = {"wine","whiskey","spirits","beer","juice","water"};
		        JComboBox<String> category = new JComboBox<>(items);
				JTextField nameField = new JTextField();
		        JTextField priceField = new JTextField();
		        JPanel form = new JPanel(new GridLayout(0,1));
		        form.add(new JLabel("Name: "));
		        form.add(nameField);
		        form.add(new JLabel("Category "));
		        form.add(category);
		        form.add(new JLabel("Price: "));
		        form.add(priceField);
		        int result = JOptionPane.showConfirmDialog(null,
		        		form,
		        		"Add FreshDrink",
		        		JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		        if(result == JOptionPane.OK_OPTION) {
		        	try {
						model.insertFreshDrink(new FreshDrink(FreshDrinkCategory.valueOf(category.getSelectedItem().toString()),nameField.getText(),Double.parseDouble(priceField.getText())));
						removePage("addFreshDrink");
						panels.remove("addFreshDrink");
						addFreshDrinkPage();
						goTo("addFreshDrink");
						stackOfStates.pop();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        

				
			}
			
			if(event.getSource() == buttons.get("addCafe")) {
				String[] items = {"coffee","tea","chocolate"};
		        JComboBox<String> category = new JComboBox<>(items);
				JTextField nameField = new JTextField();
		        JTextField priceField = new JTextField();
		        JPanel form = new JPanel(new GridLayout(0,1));
		        form.add(new JLabel("Name: "));
		        form.add(nameField);
		        form.add(new JLabel("Category "));
		        form.add(category);
		        form.add(new JLabel("Price: "));
		        form.add(priceField);
		        int result = JOptionPane.showConfirmDialog(null,
		        		form,
		        		"Add Cafe",
		        		JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		        if(result == JOptionPane.OK_OPTION) {
		        	try {
						model.insertCafe(new Cafe(CafeCategory.valueOf(category.getSelectedItem().toString()),nameField.getText(),Double.parseDouble(priceField.getText())));
						removePage("addCafe");
						panels.remove("addCafe");
						addCafePage();
						goTo("addCafe");
						stackOfStates.pop();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        

				
			}
			
			try {
				refresh();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	

}
