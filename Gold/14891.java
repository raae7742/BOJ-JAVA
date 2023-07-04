import java.util.*;
import java.io.*;

public class Main {
    static int k, answer = 0;
    static int[][] rotates;
    static int[][] gears = new int[5][8];
    
    public static void main(String args[]) throws IOException {
        input();
        
        for (int i = 0; i < k; i++) {
            int idx = rotates[i][0];
            int dir = rotates[i][1];    // 1: 시계 방향, -1: 반시계 방향
            
            int left = idx - 1;
            int right = idx + 1;
            int reversed = (dir == 1) ? -1 : 1;
            
            if (left > 0 && gears[idx][6] != gears[left][2]) dfsLeft(left, reversed);
            if (right <= 4 && gears[idx][2] != gears[right][6]) dfsRight(right, reversed);
            rotate(idx, dir);
        }
        
        for (int i = 1; i <= 4; i++) {
            if (gears[i][0] == 0) continue;
            answer += (int) Math.pow(2, i-1);
        }
        
        System.out.println(answer);
    }
    
    private static void dfsLeft(int idx, int dir) {
        int left = idx - 1;
        int reversed = (dir == 1) ? -1 : 1;
        
        if (left >= 0 && gears[idx][6] != gears[left][2]) dfsLeft(left, reversed);
        rotate(idx, dir);
        
    }
    
    private static void dfsRight(int idx, int dir) {
        int right = idx + 1;
        int reversed = (dir == 1) ? -1 : 1;
        
        if (right < 5 && gears[idx][2] != gears[right][6]) dfsRight(right, reversed);
        rotate(idx, dir);
    }
    
    private static void rotate(int idx, int dir) {
        int[] temp = new int[8];
        for (int i = 0; i < 8; i++) {
            int nd = i + dir;
            if (nd < 0) nd = 7;
            if (nd >= 8) nd = 0;
            
            temp[nd] = gears[idx][i];
        }
        
        for (int i = 0; i < 8; i++) {
            gears[idx][i] = temp[i];
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = str.charAt(j) - '0';
            }
        }
        
        k = Integer.parseInt(br.readLine());
        rotates = new int[k][2];
        
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rotates[i][0] = Integer.parseInt(st.nextToken());
            rotates[i][1] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
}
