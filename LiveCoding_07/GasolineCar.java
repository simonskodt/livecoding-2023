
public class GasolineCar extends Car {
    private double tank;
    
    public GasolineCar() {
        super("Benzin bil");
        tank = 10;
    }
    
    @Override
    public void accelerate() {
        super.accelerate();
        tank -= 1;
    }
    
    @Override
    public String toString() {
        return super.toString() + " med " + this.tank + "L tilbage.";
    }
}