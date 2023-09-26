import java.util.*;

public class Pet{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // map<key, value>
        Map<Integer, Integer> contestants = new HashMap<Integer, Integer>();
        for(int i = 0; i < 5; i++){
            
            int grade = 0;
            for(int j = 0; j < 4; j++){
                grade += scanner.nextInt();
            }

            contestants.put(i+1,grade);
        }
        
        int highestGrade = 0;
        int contestant = -1;
                
        // for(type var : collection)
        for(Map.Entry<Integer, Integer> entry : contestants.entrySet()){
            int grade = entry.getValue();
            if( grade > highestGrade){
                contestant = entry.getKey();
                highestGrade = grade;
            }
        }
        
        System.out.println(contestant + " " + highestGrade);
    }
}