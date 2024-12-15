package library.exam.com;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Magazine extends Item {
	
	public Magazine(String magazineName) {
	    super("Magazine", 2.30, magazineName);
	}

	@Override
	public Double lateFeeCalculation() {
	    LocalDate dueDate = this.getDueDate();
	    LocalDate currentDate = LocalDate.now();
	    long daysOverdue = ChronoUnit.DAYS.between(dueDate, currentDate);
	    if (daysOverdue <= 0) {
	        return 0.0;
	    }
	    Double lateFee = this.getRentPrice() * 0.1 * daysOverdue;
	    return lateFee;
	}
}
