import java.util.*;
import java.io.*;

public class Main {
    static int[][] paper = new int[10][10];
    static int[] confetties = { 0, 5, 5, 5, 5, 5 };
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String args[]) throws IOException {
        input();
        
        dfs(0, 0, 0);
        
        
        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
    
    private static void dfs(int x, int y, int cnt) {
        if (answer <= cnt) return;
        
        if (x >= 9 && y > 9) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        if (y > 9) {
            dfs(x+1, 0, cnt);
            return;
        }
        
        if (paper[x][y] != 1) {
            dfs(x, y+1, cnt);
            return;
        }
        
        for (int i = 5; i >= 1; i--) {
            if (confetties[i] <= 0) continue;
            
            if (checkSize(x, y, i)) {
                setPaper(x, y, i, 0);
                confetties[i] -= 1;
                
                dfs(x, y+1, cnt+1);
                
                setPaper(x, y, i, 1);
                confetties[i] += 1;
            }
        }
    }
    
    private static boolean checkSize(int x, int y, int size) {
        for (int newX = x; newX < x + size; newX++) {
            for (int newY = y; newY < y + size; newY++) {
                if (newX < 0 || newX >= 10 || newY < 0 || newY >= 10) {
                    return false;
                }
                
                if (paper[newX][newY] != 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static void setPaper(int x, int y, int size, int num) {
        for (int newX = x; newX < x + size; newX++) {
            for (int newY = y; newY < y + size; newY++) {
                paper[newX][newY] = num;
            }
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        br.close();
    }
}
