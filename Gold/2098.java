import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] w, dp;
    static final int notPossible = 16000000;
    static final int notVisited = notPossible * 2;
    
    public static void main(String args[]) throws IOException {
        input();
        
        dp = new int[n][(1 << n) - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], notVisited);
        }
        
        System.out.println(dfs(0, 1));
    }
    
    private static int dfs(int cur, int visited) {
        if (visited == (1 << n) - 1) {
            if (w[cur][0] == 0) return notPossible;
            return w[cur][0];
        }
        
        if (dp[cur][visited] != notVisited) {
            return dp[cur][visited];
        }
        
        for (int i = 0; i < n; i++) {
            if (w[cur][i] == 0) continue;
            if ((visited & (1 << i)) != 0) continue;
            
            int nextVisited = visited | (1 << i);
            dp[cur][visited] = Math.min(dp[cur][visited], dfs(i, nextVisited) + w[cur][i]);
        }
        
        return dp[cur][visited];
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        br.close();
    }
}
