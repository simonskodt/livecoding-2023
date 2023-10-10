package Prøve2;

public class Tree {
    protected String type; 
    protected double height;
    
    public Tree(String type) {
        this.type = type;
    }
    
    public void grow() {
        this.height += 0.5;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public String getType() {
        return this.type;
    }
    
    @Override
    public String toString() {
        return "Et " + this.height + "m hoejt " + this.type + "trae";
    }
}