import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Menu implements Serializable {
    private String name;
    private List<MenuItem> items;

    public Menu(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int size() {
        return items.size();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return "'" + name + "' contains " + size() + " items"; 
    }

    public static Menu createMenuFromFile(String filename, String name) throws Exception {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        Menu menu = new Menu(name);

        while (sc.hasNextLine()) {
            String[] info = sc.nextLine().split(",");

            MenuItem item = 
                new MenuItem(info[0].trim(), info[1].trim(), Integer.parseInt(info[2].trim()));
            menu.addItem(item);
        }

        return menu;
    }
    
    public static void saveMenu(Menu menu, String filename) throws Exception {
        File file = new File(filename);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(menu);
        oos.close();
        fos.close();
    }
    
    public static Menu loadMenu(String filename) throws Exception {
        FileInputStream fs = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fs);

        return (Menu) ois.readObject();
    }

    // 1.
    public List<MenuItem> cheaperThan(int price) {
        List<MenuItem> menuItems = new ArrayList<>();
        for (MenuItem item : items) {
            if (item.getPrice() < price) {
                menuItems.add(item);
            }
        }
        return menuItems;
    }

    public List<MenuItem> cheaperThan2(int price) {
        return items.stream()
                    .filter(item -> item.getPrice() < price)
                    .collect(Collectors.toList());
    }

    // 2.
    public List<MenuItem> containsWord(String word) {
        List<MenuItem> menuItems = new ArrayList<>();
        for (MenuItem item : items) {
            if (item.getName().toLowerCase().contains(word.toLowerCase())) {
                menuItems.add(item);
            }
        }

        return menuItems;
    }

    public List<MenuItem> containsWord2(String word) {
        return items.stream()
                    .filter(item -> item.getName().toLowerCase().equals(word.toLowerCase()))
                    .collect(Collectors.toList());
    }

    // 3.
    public List<MenuItem> getAllVegetarianItems() {
        return containsWord("vegetar");
    }

    // 4.
    public List<MenuItem> getAllVeganItems() {
        return containsWord("vegansk");
    }

    // 5.
    public double getAveragePrice() {
        int avgPrice = 0;

        for (MenuItem item : items) {
            avgPrice += item.getPrice();
        }

        return avgPrice / size();
    }

    public double getAveragePrice2() {
        double avg = items.stream()
                            .mapToDouble(item -> item.getPrice())
                            .average()
                            .orElse(0.0);
                            
        return Math.floor(avg);
    }

    // 6.
    public MenuItem getCheapest() {
        MenuItem cheapestItem = items.get(0);

        for (MenuItem item : items) {
            if (item.getPrice() < cheapestItem.getPrice()) {
                cheapestItem = item;
            }
        }

        return cheapestItem;
    }

    public MenuItem getCheapest2() {
        return items.stream()
        .min(Comparator.comparing(MenuItem::getPrice))
        .orElseThrow(NoSuchElementException::new);
    }

    // 7.
    public MenuItem getMostExpensive() {
        MenuItem mostExpensiveItem = items.get(0);

        for (MenuItem item : items) {
            if (mostExpensiveItem.getPrice() < item.getPrice()) {
                mostExpensiveItem = item;
            }
        }

        return mostExpensiveItem;
    }

    public MenuItem getMostExpensive2() {
        return items.stream()
                    .max(Comparator.comparing(MenuItem::getPrice))
                    .orElseThrow(NoSuchElementException::new);
    }

    // 8.
    public MenuItem get(String id) {
        for (MenuItem item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }

        return null;
    }

    public MenuItem get2(String id) {
        return items.stream()
                    .filter(item -> item.getId().equals(id))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
    }

    // 9.
    public List<MenuItem> getItemsWithLetterInId() {
        List<MenuItem> menuItems = new ArrayList<>();
        for (MenuItem item : items) {
            if (item.getId().matches(".*[a-zA-Z].*")) {
                menuItems.add(item);
            }
        }

        return menuItems;
    }

    public List<MenuItem> getItemsWithLetterInId2() {
        return items.stream()
                    .filter(item -> item.getId().matches(".*[a-zA-Z].*"))
                    .collect(Collectors.toList());
    }

    // 10.
    public List<MenuItem> getItemsWithId10() {
        List<MenuItem> menuItems = new ArrayList<>();
        for (MenuItem item : items) {
            if (item.getId().matches("0[1][0-9].*")) {
                menuItems.add(item);
            }
        }

        return menuItems;
    }
    
    public List<MenuItem> getItemsWithId102() {
        return items.stream()
                    .filter(item -> item.getId().matches(".*0[1][0-9].*"))
                    .collect(Collectors.toList());   
    }
}