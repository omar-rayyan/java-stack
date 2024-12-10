package HelloHuman.project.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
	
    @RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String name, @RequestParam(value="last_name", required=false) String lastName, @RequestParam(value="times", required=false) String times) {
    	int repeatTimes = 1;
    	
        if (times != null && !times.isEmpty()) {
            try {
                repeatTimes = Integer.parseInt(times);
            } catch (NumberFormatException e) {
                return "Invalid 'times' value. Please provide a valid integer.";
            }
        }
        
        String response = new String();
        
        for (int i = 0; i < repeatTimes; i++) {
        	if (name != null && !name.isEmpty()) {
                if (lastName != null && !lastName.isEmpty()) {
                	response += "Hello " + name + " " + lastName + " ";
                } else {
                	response += "Hello " + name + " ";
                }
            } else { 
        		response += "Hello Human\n" + " ";
        	}
        }
        
        return response.trim();
    }
}