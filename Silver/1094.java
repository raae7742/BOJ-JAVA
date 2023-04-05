import java.io.*;
import java.util.*;

public class Main {
    
    static int x;
    static PriorityQueue<Integer> sticks = new PriorityQueue<>();
    static int sum;
    
    public static void main(String args[]) throws IOException {
        input();
        
        sticks.add(64);
        sum = 64;
        cutStick();
        
        System.out.println(sticks.size());
    }
    
    private static void cutStick() {
        while (sum != x) {
            int len = sticks.poll();
            
            if (sum - (len / 2) >= x) {
                sum -= len/2;
                sticks.add(len/2);
            } else {
                sticks.add(len/2);
                sticks.add(len/2);
            }
        }
    }
    
    private static void input() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      x = Integer.parseInt(br.readLine());
      
      br.close();
    }
}
