package PathVariables.project.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
@RequestMapping("/daikichi")
public class PathVariablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathVariablesApplication.class, args);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
    public String daikichi(){
      return "Welcome!";
    }
	
	@RequestMapping(value="/today", method=RequestMethod.GET)
    public String today(){
      return "Today you will find luck in all your endeavors!";
    }
	
	@RequestMapping(value="/tomorrow", method=RequestMethod.GET)
    public String tomorrow(){
      return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }
	
	@RequestMapping(value="/travel/{destination}", method=RequestMethod.GET)
	public String travel(@PathVariable("destination") String destination) {
		return "Congratulations! You will soon travel to " + destination + "!";
	}
	
	@RequestMapping(value="/loto/{num}", method=RequestMethod.GET)
	public String loto(@PathVariable("num") String num) {

        try {
            int number = Integer.parseInt(num);
            if (number % 2 == 0) {
                return "You will take a grand journey in the near future but be wary of tempting offers.";
            } else {
                return "You have enjoyed the fruits of your labor, but now is a great time to spend time with family and friends.";
            }
        } catch (NumberFormatException e) {
            return "Invalid 'num' value. Please provide a valid integer.";
        }
	}

}
