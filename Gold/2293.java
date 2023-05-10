import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] coins, dp;
    
    public static void main(String args[]) throws IOException {
        input();
        
        dp = new int[k+1];
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            if (coins[i] > k) continue;
            dp[coins[i]] += 1;
            for (int j = coins[i]+1; j <= k; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        
        System.out.println(dp[k]);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        br.close();
    }
}
