import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr, dp;
    
    public static void main(String args[]) throws IOException {
        input();
        
        int answer = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
            }
            
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.println(answer);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
}
