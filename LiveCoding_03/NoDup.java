import java.util.*;

public class NoDup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        
        String[] sentence = scanner.nextLine().split(" ");
        
        for (String word : sentence) {
            set.add(word);
        }
        
        if (sentence.length == set.size()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}