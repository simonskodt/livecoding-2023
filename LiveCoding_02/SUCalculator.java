import java.util.Scanner;

public class SUCalculator{

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("------- Velkommen til SU Calculator -------");
        System.out.println("Indtast din SU her");

        double SU = s.nextDouble();
        s.nextLine();

        System.out.println("Din SU er: " + SU);

        String chosenValuta = s.nextLine();

        System.out.println("Du har valgt " + chosenValuta);

        double result = Calculate(SU, chosenValuta.trim());

        if (result == -1){
            System.out.println("Fjollet bruger, prøv igen");
        }else{
            System.out.println("Din SU er " + result + " i " + chosenValuta);
        }
    }

    public static double Calculate(double SU, String chosenValuta){
        double result = 0.0;
        if (chosenValuta.equalsIgnoreCase("Rupiah")){
            result = SU * 2198.40;
        }else if(chosenValuta.equalsIgnoreCase("Yen")){
            result = SU * 1.05;
        }
        else if(chosenValuta.equalsIgnoreCase("Eur")){
            result = SU * (1 / 7.46);
        }else{
            return -1;
        }
        return result; 
    }
}