
public class Car {
    protected String model;
    protected double speed;
    
    public Car(String model) {
        this.model = model;
    }
    
    public void accelerate() {
        this.speed += 4.5;
    }
    
    public double getSpeed() {
        return this.speed;
    }
    
    @Override
    public String toString() {
        return "En " + this.model + " der kører " + this.speed + "km/t";
    }
}