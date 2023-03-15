import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
    }
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      int[][] area = new int[n][m];
      for (int i = 0; i < k; i++) {
          st = new StringTokenizer(br.readLine());
          int x1 = Integer.parseInt(st.nextToken());
          int y1 = Integer.parseInt(st.nextToken());
          int x2 = Integer.parseInt(st.nextToken());
          int y2 = Integer.parseInt(st.nextToken());
          
          for (int x = x1; x < x2; x++) {
              for (int y = y1; y < y2; y++) {
                  area[x][y] = 1;
              }
          }
      }
      
      int count = 0;
      List<Integer> widthList = new ArrayList();
      boolean[][] visited = new boolean[n][m];
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if (!visited[i][j] && area[i][j] == 0) {
                  int width = 1;
                  count++;
                  Queue<Node> q = new LinkedList();
                  q.add(new Node(i, j));
                  visited[i][j] = true;
                  
                  while (!q.isEmpty()) {
                      Node node = q.poll();
                      
                      for (int d = 0; d < 4; d++) {
                          int x = node.getX() + dx[d];
                          int y = node.getY() + dy[d];
                          
                          if (x < 0 || x >= n) continue;
                          if (y < 0 || y >= m) continue;
                          if (!visited[x][y] && area[x][y] == 0) {
                              width++;
                              visited[x][y] = true;
                              q.add(new Node(x, y));
                          }
                      }
                  }
                  widthList.add(width);
              }
          }
      }
      System.out.println(count);
      
      Collections.sort(widthList);
      for (int i = 0; i < widthList.size(); i++) {
          System.out.print(widthList.get(i) + " ");
      }
    }
}
