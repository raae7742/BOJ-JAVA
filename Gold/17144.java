import java.util.*;
import java.io.*;

public class Main {
    static int r, c, t, cleaner = -1, answer = 0;
    static int[][] house;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    
    public static void main(String args[]) throws IOException {
        input();
        
        while (t-- != 0) {
            diffuse();
            operate();
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (house[i][j] > 0) answer += house[i][j];
            }
        }
        
        System.out.println(answer);
    }
    
    private static void diffuse() {
        int[][] temp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = house[i][j];
            }
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 미세먼지가 있다면,
                if (house[i][j] < 0 ) continue;
                
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    
                    // 칸이 없거나, 인접한 방향에 공기청정기가 있다면 continue
                    if (newX < 0 || newX >= r) continue;
                    if (newY < 0 || newY >= c) continue;
                    if (house[newX][newY] < 0) continue;
                    
                    temp[newX][newY] += house[i][j] / 5;
                    cnt++;
                }
                
                temp[i][j] -= (house[i][j] / 5) * cnt;
            }
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                house[i][j] = temp[i][j];
            }
        }
    }
    
    private static void operate() {
        // 반시계 방향으로 순회
        for (int i = cleaner - 1; i > 0; i--) {
            house[i][0] = house[i-1][0];
        }
        
        for (int i = 0; i < c-1; i++) {
            house[0][i] = house[0][i+1];
        }
        
        for (int i = 0; i < cleaner; i++) {
            house[i][c-1] = house[i+1][c-1];
        }
        
        for (int i = c-1; i > 1; i--) {
            house[cleaner][i] = house[cleaner][i-1];
        }
        
        house[cleaner][1] = 0;
        
        // 시계 방향으로 순회
        for (int i = cleaner+2; i < r-1; i++) {
            house[i][0] = house[i+1][0];
        }
        
        for (int i = 0; i < c-1; i++) {
            house[r-1][i] = house[r-1][i+1];
        }
        
        for (int i = r-1; i > cleaner+1; i--) {
            house[i][c-1] = house[i-1][c-1];
        }
        
        for (int i = c-1; i > 0; i--) {
            house[cleaner+1][i] = house[cleaner+1][i-1];
        }
        
        house[cleaner+1][1] = 0;
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        house = new int[r][c];
      
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
                if (cleaner == -1 && house[i][j] == -1)
                    cleaner = i;
            }
        }
    }
}
