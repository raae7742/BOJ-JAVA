import java.util.*;
import java.io.*;

public class Main {
    private static StringBuffer sb = new StringBuffer();
    
    private static boolean isPossible(int x, int y, int size, int[][] video) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (video[x][y] != video[i][j]) return false;
            }
        }
        
        return true;
    }
    
    private static void compressVideo(int x, int y, int size, int[][] video) {
        if (isPossible(x, y, size, video)) {
            sb.append(video[x][y]);
            return;
        }
        
        sb.append('(');
        compressVideo(x, y, size / 2, video);
        compressVideo(x, y + size / 2, size / 2, video);
        compressVideo(x + size / 2, y, size / 2, video);
        compressVideo(x + size / 2, y + size / 2, size / 2, video);
        
        sb.append(')');        
        
    }
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[][] video = new int[n][n];
      
      for (int i = 0; i < n; i++) {
          String input = br.readLine();
          for (int j = 0; j < n; j++) {
              video[i][j] = input.charAt(j) - '0';
          }
      }
      
      compressVideo(0, 0, n, video);
      System.out.println(sb.toString());
      
      br.close();
      
    }
}
