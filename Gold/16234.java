import java.util.*;
import java.io.*;

public class Main {
    static class Pos {
        int x;
        int y;
        
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int n, l, r;
    static int[][] map;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };
    static boolean[][] visited;

    private static boolean bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        List<Pos> list = new ArrayList<>();

        q.add(new Pos(x, y));
        visited[x][y] = true;
        int cnt = 1;
        int sum = map[x][y];
        
        while(!q.isEmpty()) {
            Pos p = q.poll();
            list.add(p);
            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];
                
                if (newX < 0 || newX >= n) continue;
                if (newY < 0 || newY >= n) continue;
                if (visited[newX][newY]) continue;
                
                int diff = Math.abs(map[p.x][p.y] - map[newX][newY]);
                if (diff >= l && diff <= r) {
                    q.add(new Pos(newX, newY));
                    visited[newX][newY] = true;
                    cnt++;
                    sum += map[newX][newY];
                }
            }
        }

        if (cnt == 1) return false;
        
        for (Pos p : list) {
            map[p.x][p.y] = sum / cnt;
        }
        return true;
    }

    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      l = Integer.parseInt(st.nextToken());
      r = Integer.parseInt(st.nextToken());
      map = new int[n][n];
      
      for (int i = 0; i < n; i++) {
          st = new StringTokenizer(br.readLine());
          for (int j = 0; j < n; j++) {
              map[i][j] = Integer.parseInt(st.nextToken());
          }
      }
      
      int answer = 0;
      
      while (true) {
          boolean isOpen = false;
          visited = new boolean[n][n];
          for (int i = 0; i < n; i++) {
              for (int j = 0; j < n; j++) {
                  if (!visited[i][j])
                      if (bfs(i, j)) isOpen = true;
              }
          }
          if (!isOpen) break;
          answer++;
      }
      System.out.println(answer);
    }
}
