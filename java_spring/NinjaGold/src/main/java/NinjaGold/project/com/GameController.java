package NinjaGold.project.com;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class GameController {
	
	@RequestMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("game") == null) {
			ArrayList<String> activities = new ArrayList<>(); 
			session.setAttribute("name", null);
	        session.setAttribute("gold", "N/A");
	        session.setAttribute("moves", "N/A");
	        session.setAttribute("activities", activities);
	        session.setAttribute("game", true);
		}
	    if (session.getAttribute("scoreboard") == null) {
	    	ArrayList<HashMap<String, Object>> scoreboard = new ArrayList<>();
	        session.setAttribute("scoreboard", scoreboard);
	    } else {
	    	ArrayList<HashMap<String, Object>> scoreboard = (ArrayList<HashMap<String, Object>>) session.getAttribute("scoreboard");
	        scoreboard.sort((user1, user2) -> {
	            Integer score1 = (Integer) user1.get("score");
	            Integer score2 = (Integer) user2.get("score");
	            return score2.compareTo(score1);
	        });

	        session.setAttribute("scoreboard", scoreboard);
	    }
	    return "index.jsp";
	}
	
	@RequestMapping(value = "play", method = RequestMethod.POST)
	public String play(HttpSession session, @RequestParam(value="name") String name) {
	    session.setAttribute("name", name);
        session.setAttribute("gold", 0);
        session.setAttribute("moves", 0);
	    return "redirect:/";
	}
	
	@RequestMapping(value = "process_money", method = RequestMethod.POST)
    public String processMoney(HttpSession session, 
       @RequestParam(value = "gold-min") int goldMin, 
       @RequestParam(value = "gold-max") int goldMax,
       @RequestParam(value = "facility") String facility) {
        
        Random random = new Random();
        int gold = random.nextInt((goldMax - goldMin) + 1) + goldMin;

        int currentGold = (int) session.getAttribute("gold");
        int currentMoves = (int) session.getAttribute("moves");
        session.setAttribute("gold", currentGold + gold);
        session.setAttribute("moves", currentMoves + 1);

        String outcome = (gold > 0) ? "Earned" : "Lost";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = LocalDateTime.now().format(formatter);

        String message;
        if (!"casino".equals(facility)) {
            message = String.format("%s %d golds from the %s! (%s)", outcome, gold, facility, currentTime);
        } else {
            message = String.format("Entered a casino and %s %d golds.. Ouch.. (%s)", outcome, gold, currentTime);
        }

        ArrayList<HashMap<String, String>> activities = (ArrayList<HashMap<String, String>>) session.getAttribute("activities");
        if (activities == null) {
            activities = new ArrayList<>();
        }
        HashMap<String, String> activity = new HashMap<>();
        activity.put("type", outcome);
        activity.put("message", message);
        activities.add(activity);
        session.setAttribute("activities", activities);

        if ((int) session.getAttribute("moves") == 15) {
            session.setAttribute("game", false);
            String username = (String) session.getAttribute("name");
            boolean userFound = false;

            ArrayList<HashMap<String, Object>> scoreboard = (ArrayList<HashMap<String, Object>>) session.getAttribute("scoreboard");
            if (scoreboard == null) {
                scoreboard = new ArrayList<>();
            }
            for (HashMap<String, Object> user : scoreboard) {
                if (user.get("username").equals(username)) {
                    int currentScore = (int) user.get("score");
                    if (currentScore < (int) session.getAttribute("gold")) {
                        user.put("score", session.getAttribute("gold"));
                    }
                    userFound = true;
                    break;
                }
            }
            if (!userFound) {
                HashMap<String, Object> newUser = new HashMap<>();
                newUser.put("username", username);
                newUser.put("score", session.getAttribute("gold"));
                scoreboard.add(newUser);
            }

            scoreboard.sort((u1, u2) -> ((Integer) u2.get("score")).compareTo((Integer) u1.get("score")));
            session.setAttribute("scoreboard", scoreboard);
        }

        return "redirect:/";
    }
	
	@RequestMapping(value="play_again", method=RequestMethod.POST)
	public String play_again(HttpSession session) {
		String[] sessionKeys = {"name", "gold", "moves", "activities", "game"};

        for (String key : sessionKeys) {
            session.removeAttribute(key);
        }
	    return "redirect:/";
	}
	
	@RequestMapping("view_scoreboard")
	public String view_scoreboard() {
	    return "scoreboard.jsp";
	}
	
	@RequestMapping("clear")
	public String clear(HttpSession session) {
		session.invalidate();
	    return "redirect:/";
	}
}