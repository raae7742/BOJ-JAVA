import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dp;
    static int[] before;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        br.close();
        
        dp = new int[n+1];
        before = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 0;
        
        int answer = dfs(n);
        System.out.println(answer);
        
        int idx = n;
        for (int i = 0; i <= answer; i++) {
            System.out.print(idx + " ");
            idx = before[idx];
        }
    }
    
    private static int dfs(int x) {
        if (dp[x] != -1) return dp[x];
        
        int result = Integer.MAX_VALUE;
        if (x % 3 == 0) {
            int temp = dfs(x/3) + 1;
            if (temp < result) {
                result = temp;
                before[x] = x/3;
            }
        }
        if (x % 2 == 0) {
            int temp = dfs(x/2) + 1;
            if (temp < result) {
                result = temp;
                before[x] = x/2;
            }

        }
    
        int temp = dfs(x-1) + 1;
        if (temp < result) {
            result = temp;
            before[x] = x-1;
        }

        dp[x] = result;
        return dp[x];
    }
}
