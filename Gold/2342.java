import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> todo = new ArrayList<>();
    static int[] player = { 0, 0 };
    
    public static void main(String args[]) throws IOException {
        input();
        
        if (todo.size() == 0) {
            System.out.println(0);
            return;
        }
        
        int[][][] dp = new int[todo.size()][5][5];
        dp[0][todo.get(0)][0] = 2;
        dp[0][0][todo.get(0)] = 2;
        
        for (int t = 1; t < todo.size(); t++) {
            for (int l = 0; l <= 4; l++) {
                for (int r = 0; r <= 4; r++) {
                    if (l == r) continue;
                    int cur = todo.get(t);
                    
                    if (l == cur) {
                        int min = Integer.MAX_VALUE;
                        for (int i = 0; i <= 4; i++) {
                            if (dp[t-1][i][r] == 0) continue;
                            
                            int power;
                            if (i == l) {
                                power = 1;
                            }
                            else if (i == 0) {
                                power = 2;
                            }
                            else if (Math.abs(l-i) == 2) {
                                power = 4;
                            }
                            else {
                                power = 3;
                            }
                            
                            min = Math.min(min, dp[t-1][i][r] + power);
                        }
                        
                        if (min == Integer.MAX_VALUE) continue;
                        dp[t][l][r] = min;
                        
                        continue;
                    }
                    
                    if (r == cur) {
                        int min = Integer.MAX_VALUE;
                        for (int i = 0; i <= 4; i++) {
                            if (dp[t-1][l][i] == 0) continue;
                            
                            int power;
                            if (r == i) {
                                power = 1;
                            }
                            else if (i == 0) {
                                power = 2;
                            }
                            else if (Math.abs(r-i) == 2) {
                                power = 4;
                            }
                            else {
                                power = 3;
                            }
                            min = Math.min(min, dp[t-1][l][i] + power);
                        }
                        
                        if (min == Integer.MAX_VALUE) continue;
                        dp[t][l][r] = min;

                        continue;
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (dp[todo.size()-1][i][j] == 0) continue;
                answer = Math.min(answer, dp[todo.size()-1][i][j]);
            }
        }
        
        System.out.println(answer);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int num;
        while ((num = Integer.parseInt(st.nextToken())) != 0) {
            todo.add(num);
        }
        
        br.close();
    }
}
