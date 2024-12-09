package barista.project.com;
import java.util.ArrayList;

public class Order {
	private String name;
	private boolean ready;
	private ArrayList<Item> items;
	
	public Order() {
		ArrayList<Item> items = new ArrayList<>();
		this.setName("Guest");
		this.setReady(false);
		this.setItems(items);
	}
	
	public Order(String name) {
		ArrayList<Item> items = new ArrayList<>();
		this.setName(name);
		this.setReady(false);
		this.setItems(items);
	}
	
	public Order(String name, boolean ready, ArrayList<Item> items) {
		this.setName(name);
		this.setReady(ready);
		this.setItems(items);
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void setOrderReadyStatus(boolean status) {
		this.setReady(status);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public String getStatusMessage() {
		return isReady()? "Your order is ready." : "Thank you for waiting. Your order will be ready soon.";
	}
	
	public double getOrderTotal() {
		double total = 0;
		for (Item item : items) {
			total += item.getPrice();
		}
		return total;
	}
	
	public void display() {
		System.out.println("===========");
		System.out.println("Customer Name: " + name);
		for (Item item : items) {
			System.out.println(item.getName() + " - " + item.getPrice());
		}
		System.out.println("Total: " + getOrderTotal());
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}
}
