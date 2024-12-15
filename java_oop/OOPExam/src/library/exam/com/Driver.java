package library.exam.com;

public class Driver {

	public static void main(String[] args) {
		Book thousandNightsAndNight = new Book("Thousand Nights and a Night");
		Book laylaAndWolf = new Book("Layla and the Wolf");
		User omar = new User("omarrayyan", 100.50);
		
		thousandNightsAndNight.displayAvailability();
		
		System.out.println();
		
		thousandNightsAndNight.borrowItem(omar);
		laylaAndWolf.borrowItem(omar);
		
		
		System.out.println();
		
		thousandNightsAndNight.displayAvailability();
		
		System.out.println();
		
		omar.displayBorrowedBooks();
		
		System.out.println();
		
		thousandNightsAndNight.returnItem(omar);
		
		System.out.println();
		
		omar.displayBorrowedBooks();
	}

}
