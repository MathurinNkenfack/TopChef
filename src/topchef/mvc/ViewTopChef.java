package topchef.mvc;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ViewTopChef {
	public static void main(String[] args){
		JFrame frame = new JFrame("Top Chef");
		ImageIcon logo = new ImageIcon("image/chef2.png");
		ImageIcon lunchIcon = new ImageIcon("image/lunch.png");
		JLabel lunchTitle = new JLabel(lunchIcon, SwingConstants.CENTER);
		JLabel total = new JLabel("TOTAL: 0.0 FCFA");
		JLabel appetisezTitle = new JLabel("APPETISEZ", SwingConstants.CENTER);
		JLabel dishTitle = new JLabel("DISH", SwingConstants.CENTER);
		JLabel dessertTitle = new JLabel("DESSERT", SwingConstants.CENTER);
		JLabel coffeeTitle = new JLabel("COFFEE", SwingConstants.CENTER);
		JLabel teaTitle = new JLabel("TEA", SwingConstants.CENTER);
		JLabel chocolateTitle = new JLabel("CHOCOLATE", SwingConstants.CENTER);
		JLabel wineTitle = new JLabel("WINE", SwingConstants.CENTER);
		JLabel whiskyTitle = new JLabel("WHISKY", SwingConstants.CENTER);
		JLabel spiritTitle = new JLabel("SPIRIT", SwingConstants.CENTER);
		JLabel beerTitle = new JLabel("BEER", SwingConstants.CENTER);
		JLabel juiceTitle = new JLabel("JUICE", SwingConstants.CENTER);
		JLabel waterTitle = new JLabel("WATER", SwingConstants.CENTER);
		JLabel deleteTitle = new JLabel("DOUBLE-CLICK TO DELETE", SwingConstants.CENTER);
		String appetisez[] = {"Chips-200F","Groundnut","Fruits salade"}; 
		String dish[] = {"Chicken","Potatoes","Fruit Salade", "NDOLE"};
		String dessert[] = {"Puff-Puff","Banana Cake","Coco Cake", "Orange Cake"};
		String coffee[] = {"Africa Coffee","Capuchino","Dark Coffee","Milk-Coffee"};
		String tea[] = {"Citronelle","Lipton"};
		String chocolate[] = {"Chocolate Chaud", "Chocolate au Lait", "Matinal"};
		String wine[] = {"matango","Le Barron", "El Maso"};
		String whiskey[] = {"JB","Jack-Daniel","Jonny Walker"};
		String spirit[] = {"Vodka", "Ethyl-Ethanol"};
		String beer[] = {"Castel","Origin","Isenbeck","Kadji"};
		String juice[] = {"Top Geradine","Coca-cola","Sprite","Fanta","Vinto"};
		String water[] = {"Eau Gazeuse", "Eau plat", "Eau Citronner"};
		
		JButton addButton = new JButton("ORDER");
		addButton.setBackground(Color.green);
		addButton.setVisible(false);
		JComboBox<String> selectAppetisez = new JComboBox<>(appetisez);
		JComboBox<String> selectDish = new JComboBox<>(dish);
		JComboBox<String> selectDessert = new JComboBox<>(dessert);
		JComboBox<String> selectCoffee = new JComboBox<>(coffee);
		JComboBox<String> selectTea = new JComboBox<>(tea);
		JComboBox<String> selectChocolate = new JComboBox<>(chocolate);
		JComboBox<String> selectWine = new JComboBox<>(wine);
		JComboBox<String> selectWhiskey = new JComboBox<>(whiskey);
		JComboBox<String> selectSpirit = new JComboBox<>(spirit);
		JComboBox<String> selectBeer = new JComboBox<>(beer);
		JComboBox<String> selectJuice = new JComboBox<>(juice);
		JComboBox<String> selectWater = new JComboBox<>(water);
		String[] columnNames = {"N#","Type","Name","Price(FCFA)","Amount","Total"};
		DefaultTableModel tableModel = new DefaultTableModel();
		JTable table = new JTable(tableModel);
		tableModel.setColumnIdentifiers(columnNames);
		
		
		selectDessert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Get the source of the component, which is our combo
                // box.
                JComboBox comboBox = (JComboBox) event.getSource();
                String item = (String)comboBox.getSelectedItem();
                int id = comboBox.getSelectedIndex();
                String amount = JOptionPane.showInputDialog("Enter the number of " + item + "s");
                if(amount != null) {
	                double totalamount = Double.parseDouble(amount)*500;
	                int number = tableModel.getRowCount() + 1;
	                String n = Integer.toString(number);
	                tableModel.addRow(new Object[] {n,"DESSERT",item,"500",amount,Double.toString(totalamount)});
	                double total2 = 0;
	                for(int i = 0; i < tableModel.getRowCount(); i++){
	                    double Amount = Double.parseDouble(tableModel.getValueAt(i, 5)+"");
	                    total2 = Amount+total2;
	                }
	                total.setText("TOTAL: " + Double.toString(total2) +" FCFA");
	                addButton.setVisible(true);
	                frame.repaint();
                }
                
            }
            }
		);
		ArrayList<JPanel> lists = new ArrayList<JPanel>();
		ArrayList<JComboBox<String>> combo = new ArrayList<JComboBox<String>>();
		JLabel name[] = {appetisezTitle,dishTitle,dessertTitle,coffeeTitle,
				teaTitle,chocolateTitle,wineTitle,whiskyTitle,spiritTitle,
				beerTitle,juiceTitle,waterTitle};
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
		table.setPreferredScrollableViewportSize(new Dimension(500,230));
        table.setFillsViewportHeight(true);
        
		JScrollPane p = new JScrollPane(table);
		p.setVisible(true);
		
		JPanel optionMenu = new JPanel(new GridLayout(0,4,0,0));
		for (int i=0; i<12; i++) {
			optionMenu.add(lists.get(i));
		}
		
		JPanel mainMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,500,0));
		JPanel amountPanel = new JPanel(new GridLayout(1,2,10,10));
		
		deleteTitle.setForeground(Color.RED);
		amountPanel.add(total);
		amountPanel.add(addButton);
		mainMenu.add(lunchTitle);
		mainMenu.add(optionMenu);
		mainMenu.add(amountPanel);
		mainMenu.add(deleteTitle);
		mainMenu.add(p);
		

		Font fontTitle1 = new Font("Mali", Font.BOLD, 25);
		
		JLabel title = new JLabel("Top Chef", SwingConstants.CENTER);
		Font titleFont = new Font("Mali", Font.BOLD, 25);
		title.setFont(titleFont);
		title.setIcon(logo);
		title.setHorizontalTextPosition(SwingConstants.CENTER);
		title.setVerticalTextPosition(SwingConstants.BOTTOM);
		frame.getContentPane().add(BorderLayout.NORTH, title);
		frame.add(BorderLayout.CENTER, mainMenu);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 700);
		frame.setVisible(true);
				

}
	}
