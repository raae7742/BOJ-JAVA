import java.util.*;
import java.io.*;

public class Main {
    static int n, answer = 0;
    static int[][] house;
    
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 1, 0}; 
    
    public static void main(String args[]) throws IOException {
        input();
        
        dfs(0, 1, 0);
        
        System.out.println(answer);
    }
    
    // type: 0 == 가로, 1 == 대각선, 2 == 세로
    private static void dfs(int x, int y, int type) {
        if (x == n-1 && y == n-1) {
            answer += 1;
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (type == 0 && i == 2) continue;
            if (type == 2 && i == 0) continue;
            
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
            if (house[newX][newY] != 0) continue;
            if (i == 1 && (house[newX-1][newY] != 0 || house[newX][newY-1] != 0))
                continue;
            
            dfs(newX, newY, i);
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        house = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        br.close();
    }
}
