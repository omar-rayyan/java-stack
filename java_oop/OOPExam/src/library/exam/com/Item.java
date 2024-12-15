package library.exam.com;

import java.time.LocalDate;

public abstract class Item implements BorrowManager{
	private String itemType;
	protected String itemName;
	private boolean available;
	private User borrowedBy;
	private LocalDate dueDate;
	private Double rentPrice;
	private LocalDate borrowedDate;
	
	public Item(String itemType, Double rentPrice, String itemName) {
		this.itemType = itemType;
		this.itemName = itemName;
		available = true;
		borrowedBy = null;
		dueDate = null;
		this.rentPrice = rentPrice;
	}
	
	public void borrowItem(User user) {
		LocalDate currentDate = LocalDate.now();
		LocalDate dueDate = currentDate.plusDays(7);
		user.borrowedItems.add(this);
		this.setAvailable(false);
		this.setBorrowedBy(user);
		this.setDueDate(dueDate);
		this.setBorrowedDate(currentDate);
		System.out.println(this.itemName + " " + this.getItemType() + " was borrowed by " + user.getUsername() + " for $" + this.getRentPrice() + " until " + this.getDueDate());
	}
	
	public void returnItem(User user) {
		Double owedAmount = this.getRentPrice() + lateFeeCalculation();
		user.money -= owedAmount;
		user.borrowedItems.remove(this);
		this.setAvailable(true);
		this.setBorrowedBy(null);
		this.setDueDate(null);
		System.out.println(user.getUsername() + " returned " + this.itemName + " " + this.getItemType() + " they borrowed for $" + owedAmount + " on " + this.getBorrowedDate());
	}
	
	public void displayAvailability() {
		String availability = this.isAvailable()? "available" : "not available";
		System.out.println("The " + this.itemName + " " + this.getItemType() + " is " + availability + " for renting.");
	}
	
	public abstract Double lateFeeCalculation();
	
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public User getBorrowedBy() {
		return borrowedBy;
	}
	public void setBorrowedBy(User borrowedBy) {
		this.borrowedBy = borrowedBy;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public LocalDate getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(LocalDate borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	
}
