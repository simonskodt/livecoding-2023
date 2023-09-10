import java.util.Scanner;

public class ColdPuterScience{
    public static void main(String[] args){
        // n number of temperatures collected 
        // line with temperatures white space seperated
        // output a integer

        int n;
        int daysBelowZeroDegrees = 0;
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int t = scanner.nextInt();
            if(t < 0){
                daysBelowZeroDegrees++;
            }
        }

        System.out.println(daysBelowZeroDegrees);
    }
}