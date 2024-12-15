package library.exam.com;

public interface BorrowManager {
	
	void returnItem(User user);
	void borrowItem(User user);
	boolean isAvailable();
	void displayAvailability();
}