import java.util.Scanner;

class Timeloop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        for (int i = 0; i < N; i++) {
            // comment here
            System.out.println(i+1 + " Abracadabra");
        }
    }
}