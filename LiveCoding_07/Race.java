import java.util.List;
import java.util.ArrayList;

public class Race {
    private String name;
    private List<Car> cars;
    
    public Race(String name) {
        this.name = name;
        this.cars = new ArrayList<>();
    }
    
    public void addCar(Car car) {
        this.cars.add(car);
    }
    
    public void accelerate() {
        for (Car car : this.cars) {
            car.accelerate();
        }
    }
    
    public void display() {
        System.out.println("Følgende biler deltager i '" + this.name + "':");
        for (Car car : this.cars) {
            System.out.println("- " + car.toString());
        }
        System.out.println();
    }
    
    public Car leading() {
        Car leadingCar = null;
        
        for (Car car : this.cars) {
            if (leadingCar == null || leadingCar.getSpeed() < car.getSpeed()) {
                leadingCar = car;
            }
        }
        
        return leadingCar;
    }
    
}