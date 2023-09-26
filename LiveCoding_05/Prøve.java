import java.util.*;

public class Prøve {

    // 1. Er det gode smørpriser?

    static boolean isReasonablePrice(int price) {
        return price < 20;
    }

    static void test0() {
        System.out.println(isReasonablePrice(15)); 
        System.out.println(isReasonablePrice(22));
    }

    static boolean isReasonablePrice(int price, int low, int high) {
        return (price >= low && price <= high);
    }
    
    static void test1() {
        System.out.println("false = " + isReasonablePrice(8, 9, 25));
        System.out.println("true = " + isReasonablePrice(16, 9, 25));
        System.out.println("false = " + isReasonablePrice(32, 9, 25));
    }
    
    // 2. Hvilke priser er rimelige?
    
    static List<Integer> isReasonablePrices(List<Integer> prices, int low, int high) {
        List<Integer> goodPrices = new ArrayList<>();
        
        for (Integer price : prices) {
            if (isReasonablePrice(price, low, high)) {
                goodPrices.add(price);
            }
        }
        
        return goodPrices;
    }
    
    static void test2() {
        List<Integer> lst = new ArrayList<>();
        lst.add(5);
        lst.add(17);
        lst.add(18);
        lst.add(28);
        
        List<Integer> goodList = isReasonablePrices(lst, 10, 25);
        
        System.out.println(goodList.size());
        
        for (Integer i : goodList) {
            System.out.println(i);
        }
    }
    
    // 3. Smørproduktnavne og deres priser
    
    static Map<String, Integer> getMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Lurpak", 15);
        map.put("Smørbar", 20);
        map.put("Kærgården", 25);
        
        return map;
    }
    
    static void test3() {
        Map<String, Integer> map = getMap();
        
        System.out.println("Lurpak: " + map.get("Lurpak"));
        System.out.println("Kærgården: " + map.get("Kærgården"));
    }
    
    // 4. pæn udskrivning af smørprodukter og deres priser
    
    static void printButterPrices(Map<String, Integer> prices, List<String> names) {
        System.out.println("Her er dine smørproduktmuligheder: ");
        for (String s : names) {
            if (prices.containsKey(s)) {
                System.out.println("- " + s + "(" + prices.get(s) + " kr)");
            } else {
                System.out.println("- " + s + "(?? kr)");
            }
        }
    }
    
    static void test4() {
        List<String> products = new ArrayList<>();
        products.add("Lurpak");
        products.add("Smørbar");
        products.add("Kærgården");
        products.add("Egelykke");
        
        printButterPrices(getMap(), products);
    }
}