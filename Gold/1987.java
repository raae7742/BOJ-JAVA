import java.util.*;
import java.io.*;

public class Main {
    static int r, c, max = 0;
    
    static char[][] board;
    static boolean[][] visited;
    
    static Set<Character> set = new HashSet<>();
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      r = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      
      board = new char[r][c];
      visited = new boolean[r][c];
      
      for (int i = 0; i < r; i++) {
          String input = br.readLine();
          for (int j = 0; j < c; j++) {
              board[i][j] = input.charAt(j);
          }
      }
      
      visited[0][0] = true;
      set.add(board[0][0]);
      backtracking(0, 0, 1);
      
      System.out.print(max);
      br.close();
    }
    
    private static void backtracking(int x, int y, int cnt) {
        max = Math.max(max, cnt);
        
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if (newX < 0 || newX >= r) continue;
            if (newY < 0 || newY >= c) continue;
            if (visited[newX][newY]) continue;
            if (set.contains(board[newX][newY])) continue;

            visited[newX][newY] = true;
            set.add(board[newX][newY]);
            backtracking(newX, newY, cnt+1);
            visited[newX][newY] = false;
            set.remove(board[newX][newY]);
        }
    }
}
