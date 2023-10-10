
public class Demo {
    public static void test() {
        Race race = new Race("København Grand Prix");
        GasolineCar gasCar = new GasolineCar();
        race.addCar(gasCar);
        race.accelerate();
        
        Car c1 = new Car("Citroen Berlingo");
        Car c2 = new Car("Citroen Berlingo");
        race.addCar(c1);
        race.addCar(c2);
        
        race.accelerate();
        race.display();
        System.out.println(race.leading());
    }
}