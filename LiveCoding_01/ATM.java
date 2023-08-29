import java.util.Scanner;

class ATM {
    // Balance, withdraw , deposit, valuta, withdraw valuta ,saldo, input, exit
    public static void main (String[] args){
        int balance;
        int deposit;
        int withdraw;
        int chosenNumber;
        boolean programIsRunning = true;
        Scanner scanner;
        
        System.out.println("VELKOMMEN TIL ITU's BANK!");
        
        balance = 1000;
    
        scanner = new Scanner(System.in);
        
        while (programIsRunning){
            System.out.println("---------------------------------");
            System.out.println("Du har nu følgende valgmuligheder");
            System.out.println("Tast '0' for at se din balance");
            System.out.println("Tast '1' for at indsætte penge");
            System.out.println("Tast '2' for at hæve penge");
            System.out.println("Tast '5' for at stoppe programmet");
            
            chosenNumber = scanner.nextInt();
            System.out.println("---------------------------------");
            if (chosenNumber == 0) {
                System.out.println("Du har valgt at se din saldo");
                System.out.print("Din balance er " + balance);
                System.out.println(" kr.");        
            } else if (chosenNumber == 1) {
                System.out.println("Du har valgt at indsætte penge");
                deposit = scanner.nextInt();
                balance = balance + deposit; 
                System.out.println("din nye saldo er nu " + balance + " kr.");
            } else if (chosenNumber == 2){
                System.out.println("Du har valgt hæve penge, hvor mange?");
                withdraw = scanner.nextInt();
                if (withdraw > balance){
                  System.out.println("hov hov, så mange penge har du ikke!!");  
                } else {
                    balance = balance - withdraw;
                    System.out.println("Du har hævet " + withdraw + " kr.");
                }
            }else if (chosenNumber == 5){
                programIsRunning = false;   
            }
            else {
                System.out.println("Banken forstår det ikke, prøv igen");
            }
        }
        System.out.println("Programmet er nu stoppet");
    }
}