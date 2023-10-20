import java.util.List;
import java.util.ArrayList;

public class Cocktail {
    private String name;
    private List<Ingredient> ingredients;
    
    public Cocktail(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
    }
    
    public void add(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
    
    public void doubleUp() {
        for (Ingredient ingredient : this.ingredients) {
            ingredient.doubleUp();
        }
    }
    
    public int totalEnergy() {
        int totalEnergy = 0;
        
        for (Ingredient ingredient : this.ingredients) {
            totalEnergy += ingredient.energy();
        }
        
        return totalEnergy;
    }
    
    public void line(char c) {
        for (int i = 0; i < this.name.length(); i++) {
            System.out.print(c);
        }
        System.out.println();
    }
    
    public void recipe() {
        System.out.println(this.name);
        line('=');
        for (Ingredient ingredient : this.ingredients) {
            System.out.println(ingredient.toString());
        }
        line('-');
        System.out.println(totalEnergy() + " kJ in TOTAL");
        System.out.print("Safe-4-Kids: ");
        if (safe4Kids()) {
            System.out.println("Yes!");
        } else {
            System.out.println("No!");
        }
    }
    
    public boolean safe4Kids() {
        for (Ingredient ingredient : this.ingredients) {
            if (ingredient instanceof AlcoholicIngredient) {
                AlcoholicIngredient algoIngre =
                    (AlcoholicIngredient) ingredient;
                if (algoIngre.isAlcoholic()) {
                    return false;
                }
            }
        }
        
        return true;
    }
}