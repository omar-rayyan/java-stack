package library.exam.com;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Book extends Item {
	
	public Book(String bookName) {
	    super("Book", 5.50, bookName);
	}

	@Override
	public Double lateFeeCalculation() {
	    LocalDate dueDate = this.getDueDate();
	    LocalDate currentDate = LocalDate.now();
	    long daysOverdue = ChronoUnit.DAYS.between(dueDate, currentDate);
	    if (daysOverdue <= 0) {
	        return 0.0;
	    }
	    Double lateFee = this.getRentPrice() * 0.2 * daysOverdue;
	    return lateFee;
	}

}
