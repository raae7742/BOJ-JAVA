import java.io.*;
import java.util.*;

public class Main {
    static int t, w;
    static int[] trees;
    
    public static void main(String args[]) throws IOException {
        input();

        int[][] dp = new int[t+1][w+1];

        for (int i = 1; i <= t; i++) {
            dp[i][0] = dp[i-1][0];
            if (trees[i] == 1) dp[i][0] += 1;
        }
        
        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= w; j++) {
                // 짝수 번 움직이면 현재 위치 = 나무 1
                if (j % 2 == 0) {
                    if (trees[i] == 1) {
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                    }
                    else {
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    }
                    continue;
                }
                
                // 홀수 번 움직이면 현재 위치 = 나무 2
                if (trees[i] == 1) {
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i-1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i <= w; i++) {
            answer = Math.max(answer, dp[t][i]);
        }

        System.out.println(answer);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        
        trees = new int[t+1];
        trees[0] = 1;
        
        for (int i = 1; i <= t; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        br.close();
    }
}
