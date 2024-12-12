package Counter.project.com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class CounterController {

	@RequestMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("visits") == null) {
            session.setAttribute("visits", 1);
        } else {
            Integer currentVisits = (Integer) session.getAttribute("visits");
            session.setAttribute("visits", currentVisits + 1);
        }
		
        return "index.jsp";
	}
	
	@RequestMapping("new_index")
	public String newIndex(HttpSession session) {
		if (session.getAttribute("visits") == null) {
            session.setAttribute("visits", 2);
        } else {
            Integer currentVisits = (Integer) session.getAttribute("visits");
            session.setAttribute("visits", currentVisits + 2);
        }
		
        return "new_index.jsp";
	}
	
	@RequestMapping("counter")
	public String counter(HttpSession session) {
		if (session.getAttribute("visits") == null) {
            session.setAttribute("visits", 0);
        }
		
        return "counter.jsp";
	}
	
	@RequestMapping("reset")
	public String reset(HttpSession session) {
		session.setAttribute("visits", 0);
		
        return "redirect:/counter";
	}
	
}
