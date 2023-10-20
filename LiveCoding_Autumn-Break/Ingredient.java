
public abstract class Ingredient {
    protected String name;
    protected String unit;
    protected int amount;
    
    public Ingredient(String name, String unit, int amount) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }
    
    public void doubleUp() {
        this.amount *= 2;
    }
    
    public abstract int energy();
    
    @Override
    public String toString() {
        return this.amount + this.unit + " " + this.name;
    }
}