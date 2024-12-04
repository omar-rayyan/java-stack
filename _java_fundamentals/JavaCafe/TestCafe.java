import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {
        CafeUtil cafe = new CafeUtil();

        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", cafe.getStreakGoal());
        System.out.printf("Purchases needed by week 5: %s \n\n", cafe.getStreakGoal(5));

        System.out.println("----- Order Total Test -----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n", cafe.getOrderTotal(lineItems));

        System.out.println("----- Display Menu Test -----");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        cafe.displayMenu(menu);

        System.out.println("\n----- Overloaded Display Menu Test -----");
        ArrayList<Double> prices = new ArrayList<Double>();
        prices.add(1.5);
        prices.add(3.5);
        prices.add(4.5);
        prices.add(3.5);
        boolean result = cafe.displayMenu(menu, prices);
        System.out.println("Menu and prices match: " + result);

        System.out.println("\n----- Add Customer Test -----");
        ArrayList<String> customers = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            cafe.addCustomer(customers);
            System.out.println("\n");
        }

        System.out.println("----- Price Chart Test -----");
        cafe.printPriceChart("Colombian Coffee Grounds", 15.00, 3);

        System.out.println("----- Discount Price Chart Test -----");
        cafe.printDiscountPriceChart("Espresso", 2.00, 4);

        System.out.println("----- Add Multiple Customers Test -----");
        cafe.addCustomers(customers);
    }
}