import java.util.*;
import java.io.*;

public class Main {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    static class Node {
        int x;
        int y;
        
        public Node (int x, int y) {
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
    
    public static void bfs(int[][] path, int n, int m) {
        int[][] visited = new int[n][m];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (path[i][j] == 1 && visited[i][j] == 0) {
                    answer++;
                    Queue<Node> q = new LinkedList();
                    q.add(new Node(i, j));
                    visited[i][j] = 1;
                    
                    while (!q.isEmpty()) {
                        Node node = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = node.getX() + dir[k][0];
                            int y = node.getY() + dir[k][1];
                            
                            if (x < 0 || x >= n) continue;
                            if (y < 0 || y >= m) continue;
                            if (visited[x][y] == 0 && path[x][y] == 1) {
                                visited[x][y] = 1;
                                q.add(new Node(x, y));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int t = Integer.parseInt(br.readLine());
      while (t-- > 0) {
          StringTokenizer st = new StringTokenizer(br.readLine());
          int m = Integer.parseInt(st.nextToken());
          int n = Integer.parseInt(st.nextToken());
          int k = Integer.parseInt(st.nextToken());
          
          int[][] map = new int[n][m];
          for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            map[y][x] = 1;
          }
          
          bfs(map, n, m);
      }
      
      br.close();
    }
}
