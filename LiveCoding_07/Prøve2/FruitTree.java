package Prøve2;

public class FruitTree extends Tree {
    protected int fruits;

    public FruitTree(String type) {
        super(type);
    }

    @Override
    public void grow() {
        super.grow();
        if (this.fruits > 0) {
            this.fruits *= 2;
        } else if (this.fruits == 0 || this.fruits < 0) {
            if (this.fruits % 2 == 0) {
                this.fruits += 2;
            } else {
                this.fruits++;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " med " + this.fruits + " frugt(er)";
    }
}