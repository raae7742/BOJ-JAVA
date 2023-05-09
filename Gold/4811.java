import java.io.*;
import java.util.*;

public class Main {
    static long[][] dp = new long[31][31];
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            
            System.out.println(dfs(n, 0));
        }
        
        br.close();
    }
    
    private static long dfs(int w, int h) {
        if (w == 0 && h == 0) return 1;
        
        if (dp[w][h] != 0) return dp[w][h];
        
        long result = 0;
        if (w != 0) result += dfs(w-1, h+1);
        if (h != 0) result += dfs(w, h-1);
        
        dp[w][h] = result;
        return dp[w][h];
    }
}
