import java.io.*;
import java.util.*;

public class Main {
    static int t;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            
            int cnt = 0;
            for (int j = 5; j <= num; j *= 5) {
                cnt += num / j;
            }

            System.out.println(cnt);
        }
    }
}
