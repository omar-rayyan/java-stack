package DisplayDate.project.com;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DateController {
	
	@RequestMapping("")
	public String index() {
	    return "index.jsp";
	}
	
	@RequestMapping("date")
	public String date(Model model) {
        LocalDate currentDate = LocalDate.now();
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy");
        String formattedDate = currentDate.format(dateFormatter);
        model.addAttribute("currentDate", formattedDate);
        
	    return "date.jsp";
	}
	
	@RequestMapping("time")
	public String time(Model model) {
		LocalTime currentTime = LocalTime.now();
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedTime = currentTime.format(formatter);
        
        model.addAttribute("currentTime", formattedTime);
        
	    return "time.jsp";
	}
}
