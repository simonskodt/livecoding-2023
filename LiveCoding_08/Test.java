public class Test {
    static void test() throws Exception {
        Menu menu = Menu.createMenuFromFile("./Øvelsesseddel-11-fil.txt", "Julios Pizze");
        System.out.println(menu + "\n");

        System.out.println("All products below 70kr: ");
        System.out.println(menu.cheaperThan2(70) + "\n");

        System.out.println("Average: ");
        System.out.println(menu.getAveragePrice2() + "\n");

        System.out.println("Cheapest: ");
        System.out.println(menu.getCheapest2() + "\n");

        System.out.println("Most expensive: ");
        System.out.println(menu.getMostExpensive2() + "\n");

        System.out.println("All vegetarian:");
        System.out.println(menu.getAllVegetarianItems() + "\n");

        System.out.println("All vegan:");
        System.out.println(menu.getAllVeganItems() + "\n");

        System.out.println("Get #042a:");
        System.out.println(menu.get2("042a") + "\n");

        System.out.println("Get all products with an id containing a letter: ");
        System.out.println(menu.getItemsWithLetterInId2() + "\n");

        System.out.println("Find all products within the range 10-19:");
        System.out.println(menu.getItemsWithId102() + "\n");

        Menu.saveMenu(menu, "./pizzit.txt");
        Menu loadedMenu = Menu.loadMenu("./pizzit.txt");
        System.out.println(loadedMenu + "\n");

        System.out.println("Most expensive from loaded menu: ");
        System.out.println(loadedMenu.getMostExpensive() + "\n");
    }

}