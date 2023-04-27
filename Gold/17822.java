import java.io.*;
import java.util.*;

public class Main {
    static int n, m, t;
    static Rotate[] rotates;
    static int[][] disk;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String args[]) throws IOException {
        input();
        
        for (int i = 0; i < t; i++) {
            rotate(rotates[i]);
            
            remove();

        }

        System.out.println(getAnswer());
    }
    
    private static void rotate(Rotate r) {
        for (int i = r.x; i <= n; i += r.x) {
            for (int j = 0; j < r.k; j++) {
                if (r.d == 0) {                     // 시계 방향
                    int temp = disk[i][m];
                    for (int k = m; k > 1; k--) {
                        disk[i][k] = disk[i][k-1];
                    }
                    disk[i][1] = temp;
                } 
                else {                              // 반시계 방향
                    int temp = disk[i][1];
                    for (int k = 1; k < m; k++) {
                        disk[i][k] = disk[i][k+1];
                    }
                    disk[i][m] = temp;
                }
            }
        }
    }
    
    private static void remove() {
        boolean canRemove = false;
        int sum = 0, cnt = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (disk[i][j] == -1) continue;
                
                sum += disk[i][j];
                cnt += 1;
                
                boolean[][] visited = new boolean[n+1][m+1];
                visited[i][j] = true;
                
                boolean removed = dfs(i, j, disk[i][j], visited);
                if (removed) canRemove = true;
            }
        }
        if (!canRemove) {
            double avg = (double)sum / (double)cnt;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (disk[i][j] < 0) continue;
                    if (disk[i][j] > avg) {
                        disk[i][j] -= 1;
                    }
                    else if (disk[i][j] < avg) {
                        disk[i][j] += 1;
                    }
                }
            }
        }
    }
    
    private static boolean dfs(int x, int y, int num, boolean[][] visited) {
        boolean canRemove = false;
        
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if (newX < 1 || newX > n) continue;
            
            if (newY < 1) newY = m;
            if (newY > m) newY = 1;
            if (visited[newX][newY]) continue;
            
            if (num == disk[newX][newY]) {
                canRemove = true;
                disk[x][y] = -1;
                disk[newX][newY] = -1;

                visited[newX][newY] = true;
                dfs(newX, newY, num, visited);
            }
        }
        
        
        return canRemove;
    }
    
    private static int getAnswer() {
        int sum = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (disk[i][j] == -1) continue;
                sum += disk[i][j];
            }
        }
        
        return sum;
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        
        disk = new int[n+1][m+1];
        rotates = new Rotate[t];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                disk[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            rotates[i] = new Rotate(x, d, k);
        }
            
        br.close();
    }
    
    static class Rotate {
        int x;
        int d;
        int k;
        
        public Rotate(int x, int d, int k) {
            this.x = x;
            this.d = d;
            this.k = k;
        }
    }
}
