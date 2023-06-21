import java.util.*;
import java.io.*;

public class Main {
    static int n, answer = -1;
    static int[][] schedule;

    public static void main(String args[]) throws IOException {
        input();
        
        dfs(0, 0);
        
        System.out.println(answer);
    }
    
    private static void dfs(int day, int total) {
        if (day == n) {
            answer = Math.max(answer, total);
            return;
        }
        
        if (day > n) {
            return;
        }
        
        dfs(day+1, total);
        dfs(day+schedule[day][0], total+schedule[day][1]);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        schedule = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
}
