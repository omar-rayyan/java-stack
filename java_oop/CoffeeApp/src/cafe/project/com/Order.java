package cafe.project.com;
import java.util.ArrayList;

public class Order {
	String name;
	double total;
	boolean ready;
	ArrayList<Item> items;
	
	public Order(String name, boolean ready, ArrayList<Item> items) {
		for (Item item : items) {
			this.addItem(item);
		}
		this.name = name;
		this.ready = ready;
		this.items = items;
	}
	
	public void addItem(Item item) {
        items.add(item);
        total += item.price;
    }
	
	public void setOrderReadyStatus(boolean status) {
		this.ready = status;
	}
}
