package Prøve2;

import java.util.List;
import java.util.ArrayList;

public class Forest {

    private String name;
    private List<Tree> trees;

    public Forest(String name) {
        this.name = name;
        this.trees = new ArrayList<>();
    }

    public void plant(Tree tree) {
        this.trees.add(tree);
    }

    public void grow() {
        for (Tree tree : this.trees) {
            tree.grow();
        }
    }

    public void display() {
        System.out.println("'" + this.name + "' indeholder:");
        for (Tree tree : this.trees) {
            System.out.println("- " + tree.toString());
        }
        System.out.println();
    }

    public Tree tallest() {
        Tree tallest = null;
        for (Tree tree : this.trees) {
            if (tallest == null || tree.getHeight() > tallest.getHeight()) {
                tallest = tree;
            }
        }
        return tallest;
    }

    public void display(String type) {
        System.out.println("'" + this.name + "' indeholder foelgende " + type + "trae(er):");
        for (Tree tree : this.trees) {
            if (tree.getType().equals(type)) {
                System.out.println("- " + tree.toString());
            }
        }
        System.out.println();
    }
}