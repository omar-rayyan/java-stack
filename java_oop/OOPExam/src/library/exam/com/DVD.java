package library.exam.com;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DVD extends Item {
	
	public DVD(String dvdName) {
	    super("DVD", 7.40, dvdName);
	}

	@Override
	public Double lateFeeCalculation() {
	    LocalDate dueDate = this.getDueDate();
	    LocalDate currentDate = LocalDate.now();
	    long daysOverdue = ChronoUnit.DAYS.between(dueDate, currentDate);
	    if (daysOverdue <= 0) {
	        return 0.0;
	    }
	    Double lateFee = this.getRentPrice() * 0.3 * daysOverdue;
	    return lateFee;
	}
}