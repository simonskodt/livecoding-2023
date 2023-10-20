
public class EnergeticIngredient extends Ingredient {
    protected int protein;
    protected int carbs;
    protected int fat;

    public EnergeticIngredient(String name, String unit, int amount, int protein, int carbs, int fat) {
        super(name, unit, amount);
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }
    
    @Override
    public void doubleUp() {
        super.doubleUp();
        this.protein *= 2;
        this.carbs *= 2;
        this.fat *= 2;
    }
    
    @Override
    public int energy() {
        int proteinKJ = this.protein * 17;
        int carbsKJ = this.carbs * 17;
        int fatKJ = this.fat * 37;
        
        int totalEnergy = proteinKJ + carbsKJ + fatKJ;
        
        return totalEnergy;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" (" + energy() + "kJ) ");
        
        if (protein != 0)
            sb.append("[protein:" + this.protein + "g] ");
        if (carbs != 0)
            sb.append("[carbs:" + this.carbs + "g] ");
        if (fat != 0)
            sb.append("[fat:" + this.fat + "g] ");
        
        return super.toString() + sb;
    }
}