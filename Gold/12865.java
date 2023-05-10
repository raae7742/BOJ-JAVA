import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] objects;
    static int[][] dp;
    
    public static void main(String args[]) throws IOException {
        input();
        
        dp = new int[k+1][n+1];
        
        // dp[i][j]: 무게가 i일 때, j번째 item까지 고려한 경우
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1];
                
                if (objects[j][0] > i) continue;
                dp[i][j] = Math.max(dp[i][j], dp[i-objects[j][0]][j-1] + objects[j][1]);
            }
        }
        
        System.out.println(dp[k][n]);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        objects = new int[n+1][2];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            objects[i][0] = Integer.parseInt(st.nextToken());
            objects[i][1] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
}
