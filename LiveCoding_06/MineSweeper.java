import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    public static int[][] produceMap(int size){
        Random r = new Random();
        int[][] map = new int[size][size];
        // i-rækker
        for(int i = 0; i < size; i++){
            // j-kolonner
            for(int j = 0; j < size; j++){
                double placeBomb = r.nextDouble();
                if(placeBomb <= 0.1){
                    map[i][j] = 1;                
                } else {
                    map[i][j] = 0;
                }
            }
        }
        return map;
    }

    public static boolean choose(int[][] map, int x, int y){
        int choosenSpot = map[x][y];
        if(choosenSpot == 1){
            map[y][x] = 2; 
            return false;
        } else {
            map[y][x] = -1;
            return true;
        }   
    }

    public static void printMap(int[][] map){
        for(int i = 0; i < map[i].length - 1; i ++){
            for(int j = 0; j < map[j].length - 1; j++){
                int spot = map[i][j];
                if(spot == -1){
                    System.out.print("   ");
                } else if(spot == 2){
                    System.out.print(" B ");
                } else {
                    System.out.print(" X "); 
                }   
            }
            System.out.println();
        }
    }

    public static boolean complete(int[][] map){
        boolean onlyBombsUnchecked = true;
        for(int i = 0; i < map[i].length - 1; i++){
            for(int j = 0; j < map[j].length - 1; j++){
                int location = map[i][j];
                if (location != -1 || location != 1){
                    onlyBombsUnchecked = false;
                }
            }
        }
        return onlyBombsUnchecked;
    }

    static void playSweeper(){
        boolean playAgain = true;
        while(playAgain){
            // først kalder vi vores funktion der afleverer brættet tilbage:
            // (her kan vi styre størrelsen af vores minesweeper bræt.)
            int[][] map = produceMap(5); 
            // samt laver en scanner der tillader os at læse brugerinput:
            Scanner s = new Scanner(System.in);
            // Vi fortsætter med at spille I al tid indtil vi møder en bombe eller 
            // bliver færdige, det bruger vi to variable til at holde styr på:
            boolean running = true;
            boolean hit_bomb = false;
            while(running){
                // vi starter lige med at printe kortet og beder brugeren inputte x og y
                printMap(map); 
                System.out.println("----- Skriv næste x og y ----");
                int x = s.nextInt();
                int y = s.nextInt();
                // herefter kalder vi vores funktion der vælger det næste felt.
                // (hvis den returnerer false betyder det vi har ramt en bombe)
                hit_bomb = !choose(map, x, y); 
                boolean complete = complete(map); // Vi tjekker om alle felter er valgte
                // hvis vi har ramt en bombe eller er færdige skal vi stoppe
                if(hit_bomb || complete) running = false; 
            }
            // ramte vi bomben skriver vi det ud og printer kortet,
            // ellers betyder det man kom igennem uden at ramme en bombe.
            if(hit_bomb){
                System.out.println("Du ramte en bombe!");
                printMap(map);
            } else {
                System.out.println("Du kom hele vejen igennem!");
            }
        }
    }
}