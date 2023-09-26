import java.io.*;

public class StopWatch{
    public static void main(String[] args) throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        
        int n = Integer.parseInt(reader.readLine());
        
        if( n % 2 == 1) {
            System.out.println("still running");
            return;
        }
        
        int time = 0;
        for(int i = 0; i < n; i += 2){
            int startTime = Integer.parseInt(reader.readLine());
            int stopTime = Integer.parseInt(reader.readLine());
            time += (stopTime - startTime);
        }
        
        System.out.println(time);
        reader.close();
    }
}