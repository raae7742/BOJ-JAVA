import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x, y, k;
    static int[][] map;
    static int[] commands;
    static Dice dice;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String args[]) throws IOException {
        input();
        
        for (int i = 0; i < k; i++) {
            dice.roll(commands[i]);
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        dice = new Dice(x, y);
        
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        commands = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < k; j++) {
            commands[j] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
    
    static class Dice {
        int x;
        int y;
        int[] values = {0, 0, 0, 0, 0, 0, 0};
        int cur = 6;
        int top = 2;
        int bot = 5;
        int right = 3;
        int left = 4;
        
        public Dice (int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public void roll(int dir) {
            switch (dir) {
                case 1:             // 동
                    if (y+1 >= m) return;
                    this.y += 1;
                    left = cur;
                    cur = right;
                    right = 7 - left;
                    break;
                case 2:             // 서
                    if (y-1 < 0) return;
                    this.y -= 1;
                    right = cur;
                    cur = left;
                    left = 7 - right;
                    break;
                case 3:             // 북
                    if (x-1 < 0) return;
                    this.x -= 1;
                    bot = cur;
                    cur = top;
                    top = 7 - bot;
                    break;
                case 4:             // 남
                    if (x+1 >= n) return;
                    this.x += 1;
                    top = cur;
                    cur = bot;
                    bot = 7 - top;
                    break;
            }
            
            if (map[dice.x][dice.y] == 0) {
                map[dice.x][dice.y] = dice.values[dice.cur];
            }
            else {
                dice.values[dice.cur] = map[dice.x][dice.y];
                map[dice.x][dice.y] = 0;
            }
            
            System.out.println(dice.values[7-dice.cur]);
        }
    }
}
