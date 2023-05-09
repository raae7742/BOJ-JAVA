import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer = 1;
    static int[][] board, dp;
    static boolean[][] visited;
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static boolean isInfinite = false;
    
    public static void main(String args[]) throws IOException {
        input();
        
        visited[0][0] = true;
        dfs(0, 0, 1);

        if (isInfinite) {
            System.out.println(-1);
            return;
        }
        
        System.out.println(answer);
    }
    
    private static void dfs(int x, int y, int cnt) {
        answer = Math.max(answer, cnt);
        dp[x][y] = cnt;
        
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i] * board[x][y];
            int newY = y + dy[i] * board[x][y];
            
            if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
            if (board[newX][newY] == -1) continue;
       
            if (visited[newX][newY]) {
                isInfinite = true;
                return;
            }
            
            if (dp[newX][newY] > cnt) continue;

            visited[newX][newY] = true;
            dfs(newX, newY, cnt + 1);
            visited[newX][newY] = false;
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'H') {
                    board[i][j] = -1;
                } 
                else {
                    board[i][j] = line.charAt(j) - '0';
                }
            }
        }
        
        br.close();
    }
}
