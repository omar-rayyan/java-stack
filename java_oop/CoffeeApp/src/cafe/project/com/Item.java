package cafe.project.com;

public class Item {
    String name;
    double price;
    int index;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
