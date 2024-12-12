package SimpleReceipt.project.com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleReceipt {
	
	@RequestMapping("/")
	public String index(Model model) {
	    
	    String name = "Omar Rayyan";
	    String itemName = "Mansaf Plate";
	    double price = 55.25;
	    String description = "Delicious Jordanian dish.";
	    String vendor = "JordanianKitchen";
	
	    // Your code here! Add values to the view model to be rendered
	    model.addAttribute("name", name);
	    model.addAttribute("itemName", itemName);
	    model.addAttribute("price", price);
	    model.addAttribute("description", description);
	    model.addAttribute("vendor", vendor);
	    
	    return "index.jsp";
	}
}