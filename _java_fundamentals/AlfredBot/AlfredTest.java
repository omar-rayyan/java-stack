public class AlfredTest {
    /*
    * This main method will always be the launch point for a Java application
    * For now, we are using the main to test all our 
    * AlfredQuotes methods.
    */
    public static void main(String[] args) {
        // Make an instance of AlfredQuotes to access all its methods.
        AlfredQuotes alfredBot = new AlfredQuotes();
        
        // Make some test greetings, providing any necessary data
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        
        String alexisTest = alfredBot.respondBeforeAlexis(
                            "Alexis! Play some low-fi beats."
                            );
        String alfredTest = alfredBot.respondBeforeAlexis(
            "I can't find my yo-yo. Maybe Alfred will know where it is.");
        String notRelevantTest = alfredBot.respondBeforeAlexis(
            "Maybe that's what Batman is about. Not winning. But failing.."
        );
        
        // Test basicGreeting
        System.out.println("Testing basicGreeting:");
        System.out.println(alfredBot.basicGreeting());
        System.out.println();

        // Test guestGreeting with a name
        System.out.println("Testing guestGreeting with name:");
        System.out.println(alfredBot.guestGreeting("Beth Kane"));
        System.out.println();

        // Test dateAnnouncement
        System.out.println("Testing dateAnnouncement:");
        System.out.println(alfredBot.dateAnnouncement());
        System.out.println();

        // Test respondBeforeAlexis
        System.out.println("Testing respondBeforeAlexis:");
        System.out.println("Case with 'Alexis':");
        System.out.println(alfredBot.respondBeforeAlexis("Alexis! Play some music."));
        System.out.println("Case with 'Alfred':");
        System.out.println(alfredBot.respondBeforeAlexis("Alfred, where are my socks?"));
        System.out.println("Case with no keywords:");
        System.out.println(alfredBot.respondBeforeAlexis("I need to focus on my training."));
        System.out.println();

        // Test overloaded guestGreeting
        System.out.println("Testing overloaded guestGreeting (name and day period):");
        System.out.println(alfredBot.guestGreeting("Bruce Wayne", "evening"));
        System.out.println();

        // Test overloaded guestGreeting with no parameters
        System.out.println("Testing overloaded guestGreeting (no parameters):");
        System.out.println(alfredBot.guestGreeting());
        System.out.println();
    }
}