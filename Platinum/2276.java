import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m, answer = 0;

    static int[][] bucket;
    static boolean[][] visited;

    static PriorityQueue<Pos> pq = new PriorityQueue<>();
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String args[]) throws IOException {
        input();
        
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n-1 || j == 0 || j == m-1) {
                    visited[i][j] = true;
                    pq.add(new Pos(i, j, bucket[i][j]));
                }
            }
        }
        
        while (!pq.isEmpty()) {
            Pos pos = pq.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                if (bucket[nx][ny] > pos.threshold) {
                    pq.add(new Pos(nx, ny, bucket[nx][ny]));
                } 
                else {
                    answer += (pos.threshold - bucket[nx][ny]);
                    pq.add(new Pos(nx, ny, pos.threshold));
                }
                
            }
        }
        
        System.out.println(answer);
        
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        bucket = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                bucket[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        br.close();
    }
    
    static class Pos implements Comparable<Pos> {
        int x;
        int y;
        int threshold;
        
        public Pos(int x, int y, int water) {
            this.x = x;
            this.y = y;
            this.threshold = water;
        }
        
        @Override
        public int compareTo(Pos p) {
            return this.threshold - p.threshold;
        }
    }
}
