import java.util.Random;

class Opgave4{
    
    static public String findShortestName(String nameA, String nameB){
        Random r = new Random();
        int randomNumber = r.nextInt(2); //Giver et tal mellem 0 og 1
        
        if (nameA.length() == nameB.length()){
            if (randomNumber == 0){
                return nameA;
            }else{
                return nameB;
            }
        }else{
            if(nameA.length() < nameB.length()){
            return nameA;
        }else{
            return nameB;
            }
        }
    }
    
    static public void findShortestCombinedName(String nameAMiddle, String nameALast, String nameBMidlee, String nameBLast){
        String shortestLastName = findShortestName(nameALast, nameBLast); // Bo
        
        if (shortestLastName.equals(nameALast)) { // 
            String shortestMiddleName = findShortestName(nameBMidlee, nameBLast);
            printName(shortestMiddleName, nameALast);
        }else {
            String shortestMiddleName = findShortestName(nameAMiddle, nameALast);
            printName(shortestMiddleName, nameBLast);
        } 
    }
    
    private static void printName(String middleName, String lastName) {
        String fullName = String.format("%s %s", middleName, lastName);
        System.out.println(fullName);
    }

    static public void test1(){
        String first_name = "Lars";
        String second_name = "Mette";
        
        String shortestName = findShortestName(first_name, second_name);
        System.out.println(shortestName);
    }
    
        static public void test2(){
        String first_name = "Pete";
        String second_name = "Line";
        
        String shortestName = findShortestName(first_name, second_name);
        System.out.println(shortestName);
    }
    
    public static void main(String[] args) {
        // middleName, otherMiddleName, lastName, otherLastName

        System.out.println("--- TEST 1 ---");
        findShortestCombinedName("Johann", "Mikkelsen", "Skødt", "Brorson");
        // Should be: "Mikkelsen Skødt"
        String line = String.format("Lengths: (Brorson Skødt, %s) and (Mikkelsen Skødt, %s)", 
            "Brorson Skødt".length()-1,
            "Mikkelsen Skødt".length()-1);
        System.out.println(line + "\n");

        System.out.println("--- TEST 2 ---");
        findShortestCombinedName("Ry", "Mortensen", "Kaspersen", "Strå");
        // Should be: "Ry Strå"
        line = String.format("Lengths: (Kaspersen Strå, %s) and (Ry Strå, %s)", 
            "Kaspersen Strå".length()-1,
            "Ry Strå".length()-1);
        System.out.println(line + "\n");
        
        System.out.println("--- TEST 3 ---");
        findShortestCombinedName("Torben", "Hans", "Gunt", "Larsen");
        // Should be: "Hans Gunt"
        line = String.format("Lengths: (Larsen Gunt, %s) and (Hans Gunt, %s)", 
            "Larsen Gunt".length()-1,
            "Hans Gunt".length()-1);
        System.out.println(line + "\n");
        
        System.out.println("--- TEST 4 :: Equals length last name ---");
        findShortestCombinedName("Christian", "Ludvig", "Hansen", "Møller");
        
        // Should be: "Hans Gunt"
        line = String.format("Lengths: (Møller Hansen, %s), (Ludvig Hansen, %s),\n    (Hansen Møller, %s) and (Christian Møller, %s)", 
            "Møller Hansen".length()-1,
            "Ludvig Hansen".length()-1,
            "Hansen Møller".length()-1,
            "Christian Møller".length()-1);
        System.out.println(line + "\n");
    }

}