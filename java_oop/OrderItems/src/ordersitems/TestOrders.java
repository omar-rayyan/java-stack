package ordersitems;

import java.util.ArrayList;

public class TestOrders {

	public static void main(String[] args) {
		Item item1 = new Item("mocha", 2.5);
		Item item2 = new Item("latte", 4.2);
		Item item3 = new Item("drip coffee", 1.5);
		Item item4 = new Item("cappuccino", 5.3);
		
		ArrayList<Item> items1 = new ArrayList<>();
        items1.add(item1);
        items1.add(item2);
		Order order1 = new Order("Cindhuri", false, items1);
		
		ArrayList<Item> items2 = new ArrayList<>();
        items2.add(item1);
        items2.add(item4);
		Order order2 = new Order("Jimmy", false, items2);
		
		ArrayList<Item> items3 = new ArrayList<>();
        items3.add(item1);
        items3.add(item2);
		Order order3 = new Order("Noah", false, items3);
		
		ArrayList<Item> items4 = new ArrayList<>();
		items4.add(item4);
        items4.add(item3);
		Order order4 = new Order("Sam", false, items4);
		
		System.out.println(order1);
		System.out.println(order1.total);
		
		order3.items.add(item4);
		
		order4.items.add(item2);
		
		order1.setOrderReadyStatus(true);
		
		order4.items.add(item2);
		order4.items.add(item2);
		
		order2.setOrderReadyStatus(true);
	}

}
