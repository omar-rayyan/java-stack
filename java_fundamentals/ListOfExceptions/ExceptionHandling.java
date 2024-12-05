import java.util.ArrayList;

public class ExceptionHandling {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println("Successfully casted value: " + castedValue);
            } catch (ClassCastException e) {
                System.out.println("Error: Unable to cast value at index " + i);
                System.out.println("Value: " + myList.get(i));
                System.out.println("Exception: " + e.getMessage());
            }
        }

        System.out.println("Program finished iterating through the list.");
    }
}
