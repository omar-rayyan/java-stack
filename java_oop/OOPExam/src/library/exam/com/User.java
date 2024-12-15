package library.exam.com;

import java.util.ArrayList;

public class User {
	private String username;
	protected ArrayList<Item> borrowedItems;
	protected Double money;
	
	public User(String username, Double money) {
		this.username = username;
		this.borrowedItems = new ArrayList<>();
		this.money = money;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void displayBorrowedBooks(){
		System.out.println("====== Borrowed books by " + this.username + " ======");
		for(Item item : borrowedItems) {
			System.out.println("- (" + item.getItemType() + ") " + item.itemName + " - borrowed on: " + item.getBorrowedDate() + " - Due to return on: " + item.getDueDate());
		}
		System.out.println("===========================================");
	}
}
