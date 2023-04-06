import java.util.*;
import java.io.*;

public class Main {
    static int cnt = 0, maxWidth = 0, maxSize = 0, m, n;
    static int[][] map;
    static int[][] visited;
    static List<Integer> widths = new ArrayList<>();
    
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    
    public static void main(String args[]) throws IOException{
        input();
        
        visited = new int[m][n];
        widths.add(0, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {
                    visited[i][j] = ++cnt;
                    calculateWidth(i, j);
                }
            }
        }
        
        maxSize = maxWidth;
        calculateMaxSize();
        
        System.out.println(cnt);
        System.out.println(maxWidth);
        System.out.println(maxSize);
    }
    
    private static void calculateWidth(int x, int y) {
        if (widths.size() <= cnt) {
            widths.add(cnt, 1);
        } else {
            widths.set(cnt, widths.get(cnt)+1);
        }
        maxWidth = Math.max(maxWidth, widths.get(cnt));

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
            if (visited[newX][newY] != 0) continue;
            if ((map[x][y] & (0001 << i)) != 0) continue;
            
            visited[newX][newY] = cnt;
            calculateWidth(newX, newY);
        }
    }
    
    private static void calculateMaxSize() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                    if (visited[i][j] == visited[newX][newY]) continue; 
                    int result = widths.get(visited[i][j]) + widths.get(visited[newX][newY]);
                    maxSize = Math.max(maxSize, result);
                }
            }
        }
    }
    
    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        br.close();
    }
}
