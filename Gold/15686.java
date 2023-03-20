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
    
    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static List<Pos> houses = new ArrayList<>();
    static List<Pos> chickens = new ArrayList<>();
    static boolean[] visited;
    
    private static void dfs(int cnt, int idx) {
        if (cnt == m) {
            int total = 0;
            for (int i = 0; i < houses.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (visited[j]) {
                        int dist = Math.abs(houses.get(i).x - chickens.get(j).x)
                                + Math.abs(houses.get(i).y - chickens.get(j).y);
                        min = Math.min(min, dist);
                    }
                }
                total += min;
            }
            answer = Math.min(total, answer);
            return;
        }
        
        for (int i = idx; i < chickens.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cnt+1, i+1);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      int[][] map = new int[n][n];
      
      for (int i = 0; i < n; i++) {
          st = new StringTokenizer(br.readLine());
          for (int j = 0; j < n; j++) {
              map[i][j] = Integer.parseInt(st.nextToken());
              
              if (map[i][j] == 1) houses.add(new Pos(i, j));
              else if (map[i][j] == 2) chickens.add(new Pos(i, j));
          }
      }
      
      visited = new boolean[chickens.size()];
      dfs(0, 0);
      
      System.out.println(answer);
    }
}
