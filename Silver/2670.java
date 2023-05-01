import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static double arr[], dp[];
    
    public static void main(String args[]) throws IOException {
        input();
        
        dp = new double[n];
        dp[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] * arr[i];
            
            if (dp[i] < arr[i]) dp[i] = arr[i];
        }
        
        double answer = 0f;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.printf("%.3f", answer);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        
        br.close();
    }
}
