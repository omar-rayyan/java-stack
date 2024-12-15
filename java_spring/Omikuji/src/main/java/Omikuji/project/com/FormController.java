package Omikuji.project.com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class FormController {
	
	@RequestMapping("")
	public String root() {
		return "redirect:/omikuji";
	}
	
	@RequestMapping(value="omikuji", method=RequestMethod.GET)
	public String showForm() {
		return "omikuji_form.jsp";
	}
	
	@RequestMapping(value="/sendOmikuji", method=RequestMethod.POST)
	public String processOmikujiForm(HttpSession session,
		    @RequestParam(value="number") String number,
		    @RequestParam(value="city") String city,
		    @RequestParam(value="person") String person,
		    @RequestParam(value="hobby") String hobby,
		    @RequestParam(value="animal") String animal,
		    @RequestParam(value="message") String message) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("animal", animal);
		session.setAttribute("message", message);
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping(value="omikuji/show", method=RequestMethod.GET)
	public String showFormResult(HttpSession session) {
		if (session.getAttribute("number") == null) {
			return "redirect:/omikuji";
		}
		return "omikuji_result.jsp";
	}
}
