public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 2.5;
        double lattePrice = 2;
        double cappuccinoPrice = 3.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Shatha";
        String customer2 = "Omar";
        String customer3 = "Nasri";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Shatha"
        if (isReadyOrder1) {
            System.out.println(customer1 + readyMessage);
            System.out.println(displayTotalMessage + dripCoffeePrice);
        } else {
            System.out.println(customer1 + pendingMessage);
        }

        System.out.println(generalGreeting + customer2);
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + cappuccinoPrice);
        } else {
            System.out.println(customer2 + pendingMessage);
        }

        double shathaTotal = lattePrice * 2;
        System.out.println(generalGreeting + customer1);
        if (isReadyOrder3) {
            System.out.println(customer1 + readyMessage);
            System.out.println(displayTotalMessage + shathaTotal);
        } else {
            System.out.println(customer1 + pendingMessage);
        }

        System.out.println(generalGreeting + customer3);
        double newTotal = lattePrice - dripCoffeePrice;
        System.out.println(customer3 + ", " + displayTotalMessage + newTotal);

        mochaPrice = 4.0;
        isReadyOrder2 = false;
        System.out.println("Testing new price of mocha: " + mochaPrice);
        if (!isReadyOrder2) {
            System.out.println(customer2 + pendingMessage + " (updated status)");
        }
    }
}