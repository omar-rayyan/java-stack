package cafe.project.com;
import java.util.Scanner;
import java.util.ArrayList;

public class CoffeeKiosk {
    ArrayList<Item> menu;
    ArrayList<Order> orders;

    public CoffeeKiosk() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addMenuItem(String name, double price) {
        Item item = new Item(name, price);
        item.setIndex(menu.size());
        menu.add(item);
    }

    public void displayMenu() {
        System.out.println("======= Menu =======");
        for (Item item : menu) {
            System.out.println(item.getIndex() + " " + item.name + " -- $" + item.price);
        }
        System.out.println("===================");
    }

    public void newOrder() {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter customer name for new order:");
        String name = scanner.nextLine();
        Order order = new Order(name, false, new ArrayList<>());

        displayMenu();

        System.out.println("Please enter a menu item index or 'q' to quit:");
        String itemNumber = scanner.nextLine();

        while (!itemNumber.equals("q")) {
            try {
                int index = Integer.parseInt(itemNumber);
                if (index >= 0 && index < menu.size()) {
                    order.addItem(menu.get(index));
                } else {
                    System.out.println("Invalid menu index. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'q' to quit.");
            }
            System.out.println("Please enter another menu item index or 'q' to quit:");
            itemNumber = scanner.nextLine();
        }

        orders.add(order);
        System.out.println("Order for " + order.name + " has been placed:");
        for (Item item : order.items) {
            System.out.println("- " + item.name + " ($" + item.price + ")");
        }
        System.out.println("Total: $" + order.total);
    }
}
