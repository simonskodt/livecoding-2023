import java.util.*;

class GætEtDyr{
    public static void main(String[] args){
        Map<String, String> animalHints = new HashMap<>(); //Key er navnet på dyret, value er hintet. 
                
        animalHints.put("Elefant", "Jeg har en lang snabel");
        animalHints.put("Pingvin", "Jeg kan ikke flyve, men jeg er god til at svømme");
        animalHints.put("Giraf", "Jeg har en meget lang hals");
        animalHints.put("Hund", "Jeg er menneskets bedste ven");
        
        Scanner scanner = new Scanner(System.in);
        
        int correctAnswers = 0; 
        
        ArrayList<String> animalNames = new ArrayList<String>();
        
        for(String key : animalHints.keySet()){
            animalNames.add(key);
        }
        
        //Collections.shuffle(animalNames);
        animalNames = rystPosen(animalNames);
        
        for (String animalName : animalNames){
            System.out.println(animalHints.get(animalName));
            System.out.println("Hvilket dyr tænker jeg på??");
            String answer = scanner.nextLine();
            
            if(isAnswerCorrect(animalName, answer)){ 
                //Linjen ovenfor kalder metoden isAnswerCorrect() som står under, metoden bliver kaldt med værdierne animalName (key) og answer (answer)
                
                System.out.println("Du har gættet rigtigt");
                correctAnswers++; //Inkrementering af correctAnswers, svarer til: correctAnswers = correctAnswers + 1;
            }else{
                System.out.println("Du har gættet forkert");
            }
            System.out.println("----------------------------------");
        }

        System.out.println("Du har gættet " + correctAnswers + " ud af 4 rigtige");
    }
    
    static boolean isAnswerCorrect(String key, String answer){
        return key.equalsIgnoreCase(answer); //Underøger om key er det samme som aswer, returnere true hvis det er tilfældet.
    }
    
    static ArrayList<String> rystPosen(ArrayList<String> animalNames){
        ArrayList<String> shuffledList = new ArrayList<String>();
        
        for(int i = animalNames.size(); i > 0 ; i--){
            Random r = new Random(); //Laver en ny instans a Random klassen (OO - programering) 
            int index = r.nextInt(animalNames.size()); // 0 inklusiv -> 4 eklusivt
            
            String name = animalNames.remove(index); //Fjerner OG returnere et element fra liste 
            shuffledList.add(name); //Tilføjer det vi fjernede fra den gamle liste til den shufflede liste
        }
        
        return shuffledList;
    }
} 