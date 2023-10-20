 
public class AlcoholicIngredient extends EnergeticIngredient {
    protected int alcohol; 

    public AlcoholicIngredient(String name, String unit, int amount, int protein, int carbs, int fat, int alcohol) {
        super(name, unit, amount, protein, carbs, fat);
        this.alcohol = alcohol;
    }
    
    public boolean isAlcoholic() {
        return this.alcohol > 0;
    }
    
    @Override
    public void doubleUp() {
        super.doubleUp();
        this.alcohol *= 2;
    }
    
    @Override
    public int energy() {
        int alcoholKJ = this.alcohol * 29;
        
        return super.energy() + alcoholKJ;
    }
    
    @Override
    public String toString() {
        if (isAlcoholic())
            return super.toString() + "[alcohol:" + this.alcohol + "g]";
        else
            return super.toString();
    }
}
