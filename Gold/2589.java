import java.util.*;
import java.io.*;

public class Main {
    static class Pos {
        int x;
        int y;
        int cnt;
        
        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
        
        public int getCnt() {
            return this.cnt;
        }
    }
    
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    
    private static int bfs(int x, int y, int n, int m, char[][] map) {
        boolean[][] visited = new boolean[n][m];
        int result = 0;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y, 0));
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int newX = pos.getX() + dx[i];
                int newY = pos.getY() + dy[i];
                int newCnt = pos.getCnt() + 1;
                
                if (newX < 0 || newX >= n) continue;
                if (newY < 0 || newY >= m) continue;
                if (visited[newX][newY] || map[newX][newY] == 'W') continue;
                
                q.add(new Pos(newX, newY, newCnt));
                result = (newCnt > result) ? newCnt : result;
                visited[newX][newY] = true;
            }
        }
        
        return result;
    }
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      char[][] map = new char[n][m];
      
      for (int i = 0; i < n; i++) {
          String input = br.readLine();
          for (int j = 0; j < m; j++) {
              map[i][j] = input.charAt(j);
          }
      }
      
      int answer = 0;
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if (map[i][j] == 'L') {
                  int result = bfs(i, j, n, m, map);
                  answer = (result > answer) ? result : answer;
              }
          }
      }
      
      System.out.println(answer);
    }
}
