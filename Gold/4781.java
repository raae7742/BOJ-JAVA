import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);
            
            if (n == 0 && m == 0) break;
            int[][] candies = new int[n][2];        // 0: 칼로리, 1: 가격
            int[] dp = new int[m+1];
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                candies[i][0] = Integer.parseInt(st.nextToken());
                candies[i][1] = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);
            }

            for (int i = 0; i < n; i++) {
                for (int j = candies[i][1]; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - candies[i][1]] + candies[i][0]);
                }
            }
            
            System.out.println(dp[m]);
        }
        
        br.close();
    }
}
