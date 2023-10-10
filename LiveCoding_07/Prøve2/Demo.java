package Prøve2;

public class Demo {
    public static void test0() {
        Forest forest = new Forest("Amager faelled");
        FruitTree fTree = new FruitTree("aeble");
        forest.plant(fTree);
        forest.grow();
        try {
            System.out.println(forest.tallest());
        } catch (Exception e) {
            System.out.println("Der skete en fejl");
        }
    }

    public static void test1() {
        FruitTree fTree = new FruitTree("paere");
        fTree.grow();
        System.out.println("Forventes 1 stk. frugt");
        System.out.println("==========");
        System.out.println(fTree);
    }
}