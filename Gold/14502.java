import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max = 0;
    static int[][] map;     // 0: 빈칸, 1: 벽, 2: 바이러스
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String args[]) throws IOException {
        input();
        
        dfs(1, 1, 0);
        
        System.out.println(max);
    }
    
    private static void dfs(int x, int y, int cnt) {
        if (cnt >= 3) {
            diffuse();
            return;   
        }
        
        if (x > n) return;
        
        int nx = x;
        int ny = y+1;
        
        if (ny > m) {
            nx = x+1;
            ny = 1;
        }
        
        if (map[x][y] == 0) {
            map[x][y] = 1;
            dfs(nx, ny, cnt + 1);
            map[x][y] = 0;
        }
        
        dfs(nx, ny, cnt);

    }
    
    private static void diffuse() {
        int[][] temp = new int[n+1][m+1];
        Queue<Virus> q = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                temp[i][j] = map[i][j];
                if (temp[i][j] == 2) q.add(new Virus(i, j));
            }
        }
        
        while (!q.isEmpty()) {
            Virus v = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];
                
                if (nx <= 0 || nx > n || ny <= 0 || ny > m) continue;
                if (temp[nx][ny] == 1 || temp[nx][ny] == 2) continue;
                
                temp[nx][ny] = 2;
                q.add(new Virus(nx, ny));
            }
        }
        
        checkSafeArea(temp);
    }
    
    private static void checkSafeArea(int[][] temp) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (temp[i][j] == 0) cnt++;
            }
        }
        
        max = Math.max(max, cnt);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        br.close();
    }
    
    static class Virus {
        int x;
        int y;
        
        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
