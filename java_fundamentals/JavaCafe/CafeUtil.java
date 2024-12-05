import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CafeUtil {

    public int getStreakGoal() {
        return getStreakGoal(10);
    }

    public int getStreakGoal(int numWeeks) {
        int total = 0;
        for (int i = 1; i <= numWeeks; i++) {
            total += i;
        }
        return total;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d %s%n", i, menuItems.get(i));
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        }
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d %s -- %s%n", i, menuItems.get(i), currency.format(prices.get(i)));
        }
        return true;
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Enter your name please");
        String username = System.console().readLine();
        System.out.printf("Hello, %s!%n", username);
        System.out.printf("There are %d people in front of you.%n", customers.size());
        customers.add(username);
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            System.out.printf("%d - %s%n", i, currency.format(price * i));
        }
    }

    public void printDiscountPriceChart(String product, double price, int maxQuantity) {
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            double discountedPrice = price * i - (0.50 * (i - 1));
            System.out.printf("%d - %s%n", i, currency.format(discountedPrice));
        }
    }

    public void addCustomers(ArrayList<String> customers) {
        System.out.println("Enter customer names one by one. Type 'q' to quit.");
        String username;
        while (!(username = System.console().readLine()).equals("q")) {
            customers.add(username);
            System.out.printf("Added %s to the list.%n", username);
        }
        System.out.println(customers);
    }
}