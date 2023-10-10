import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Prøve1{
    public static boolean calculate(int number){
        return number == 10;
    }

    public static void test0(){
        System.out.println(calculate(10));
        System.out.println(calculate(5));
    }

    public static boolean calculate(int number, int winner, int joker){
        return (number == winner || number == joker);
    }

    public static void test1(){
        System.out.println(calculate(4, 8, 16));
        System.out.println(calculate(8, 8, 16));
        System.out.println(calculate(16, 8, 16));
    }

    public static int getWinnerAmount(List<Integer> numbers, int winner, int joker){
        int count = 0;
        for(int number : numbers){
            if(calculate(number, winner, joker)){
                count += 1;
            }
        }
        return count;
    }

    public static void test2(){
        List<Integer> numbers = new ArrayList<Integer>();
				numbers.add(10);
				numbers.add(5);
				numbers.add(60);
        numbers.add(7);
				numbers.add(25);
				numbers.add(10);
        System.out.println(getWinnerAmount(numbers, 10, 25));
    }

    public static Map<String, Integer> getMap(){
        Map<String, Integer> names = new HashMap<>();
        names.put("Sebastian", 5);
        names.put("Claus", 10);
        return names;        
    }

    public static void test3(){
        Map<String, Integer> names = getMap();
        int valueSebastian = names.get("Sebastian");
        System.out.println(valueSebastian);
        int valueClaus = names.get("Claus");
        System.out.println(valueClaus);
    }

    public static void print(Map<String, Integer> contestants, int winner, int joker){
        System.out.println("Lotteriresultater:");
        // for(String name : contestants.keySet()){
            // int lottoNumber = contestants.get(name);
            // if(calculate(lottoNumber, winner, joker)){
                // System.out.println("- " + name + " vandt!");
            // } else {
                // System.out.println("- " + name + " tabte!");
            // }
        // }
        for(Map.Entry<String, Integer> entry : contestants.entrySet()){
            int lottoNumber = entry.getValue(); 
            if(calculate(lottoNumber, winner, joker)){
                System.out.println("- " + entry.getKey() + " vandt!");
            } else {
                System.out.println("- " + entry.getKey() + " tabte!");                
            }
        }
    }

    public static void test4(){
        Map<String, Integer> map = getMap();
        print(map, 2, 5);
    }

    public static void testAll(){
        test0();
        test1();
        test2();
        test3();
        test4();
    }
}
