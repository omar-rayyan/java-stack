package ordersitems;
import java.util.ArrayList;

public class Order {
	String name;
	double total;
	boolean ready;
	ArrayList<Item> items;
	
	public Order(String name, boolean ready, ArrayList<Item> items) {
		for (Item item : items) {
			this.total += item.price;
		}
		this.name = name;
		this.ready = ready;
		this.items = items;
	}
	
	public void setOrderReadyStatus(boolean status) {
		this.ready = status;
	}
}
