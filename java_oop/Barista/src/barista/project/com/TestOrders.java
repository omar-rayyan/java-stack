package barista.project.com;

import java.util.ArrayList;

public class TestOrders {

	public static void main(String[] args) {
		Item item1 = new Item("mocha", 2.5);
		Item item2 = new Item("latte", 4.2);
		Item item3 = new Item("drip coffee", 1.5);
		Item item4 = new Item("cappuccino", 5.3);
		
		Order order1 = new Order("Cindhuri");
		order1.addItem(item1);
        order1.addItem(item2);
		
        Order order2 = new Order("Jimmy");
        order2.addItem(item1);
        order2.addItem(item4);
		
        Order order3 = new Order("Noah");
        order3.addItem(item1);
        order3.addItem(item2);
		
        Order order4 = new Order("Sam");
        order4.addItem(item4);
		order4.addItem(item3);
		
		order3.getItems().add(item4);
		
		order4.getItems().add(item2);
		
		order1.setOrderReadyStatus(true);
		
		order4.getItems().add(item2);
		order4.getItems().add(item2);
		
		order2.setOrderReadyStatus(true);
		
		System.out.println(order2.getStatusMessage());
		
		order1.display();
		order2.display();
		order3.display();
		order4.display();
	}

}
