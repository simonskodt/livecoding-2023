import java.io.Serializable;

public class MenuItem implements Serializable {
    
    private String id;
    private String name;
    private int price;
    
    public MenuItem(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return id + ", '" + name + "' (" + price + "kr)";
    }
}