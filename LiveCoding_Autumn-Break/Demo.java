
public class Demo {
    public static void demo() {
        Cocktail cocktail = new Cocktail("Espresso Martini");
        
        cocktail.add(new EnergeticIngredient("espresso", "cl",
            10/2, 4/2, 54/2, 56/2));
        cocktail.add(new AlcoholicIngredient("vodka-null", "cl", 8/2,
            0, 0, 0, 0));
        cocktail.add(new AlcoholicIngredient("kahlua-zero", "cl", 8/2,
            0, 30/2, 0, 0));
        
        cocktail.doubleUp();
        cocktail.recipe();    
    }
}