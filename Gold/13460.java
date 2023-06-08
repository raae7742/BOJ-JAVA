import java.util.*;
import java.io.*;

public class Main {
    static int n, m, answer = 11;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dir = new int[10];
    
    static Ball red, blue;
    
    public static void main(String args[]) throws IOException {
        input();
        
        dfs(0);
        dir[0] = 2;
        roll();
        
        if (answer > 10) answer = -1;
        System.out.println(answer);
    }
    
    private static void dfs(int cnt) {
        if (cnt >= 10) {
            roll();
            return;
        }
        
        for (int d = 0; d < 4; d++) {
            dir[cnt] = d;
            dfs(cnt+1);
        }
    }
    
    private static void roll() {
        char[][] temp = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = board[i][j];
            }
        }
        
        int redX = red.x;
        int redY = red.y;
        int blueX = blue.x;
        int blueY = blue.y;
        boolean arrived = false;
        
        for (int i = 0; i < 10; i++) {
            if (i+1 >= answer) return;
            int d = dir[i];
            
            int nbx = blueX + dx[d];
            int nby = blueY + dy[d];
            int nrx = redX + dx[d];
            int nry = redY + dy[d];
            
            while (true) {
                boolean blueMovable = nbx >= 0 && nbx < n && nby >= 0 && nby < m;
                if (blueMovable) blueMovable = temp[nbx][nby] != '#' && temp[nbx][nby] != 'R';
                
                if (blueMovable) {
                    if (temp[nbx][nby] == 'O') return;
                    
                    temp[nbx][nby] = 'B';
                    temp[blueX][blueY] = '.';
                    blueX = nbx;
                    blueY = nby;
                    
                    nbx += dx[d];
                    nby += dy[d];
                }
                
                boolean redMovable = nrx >= 0 && nrx < n && nry >= 0 && nry < m;
                if (redMovable) redMovable = temp[nrx][nry] != '#' && temp[nrx][nry] != 'B';
                
                if (redMovable) {
                    if (temp[nrx][nry] == 'O') {
                        arrived = true;
                        temp[redX][redY] = '.';
                        nrx = -100;
                        nry = -100;
                        continue;
                        
                    }
                    
                    temp[nrx][nry] = 'R';
                    temp[redX][redY] = '.';
                    redX = nrx;
                    redY = nry;
                    
                    nrx += dx[d];
                    nry += dy[d];
                }
                
                if (!blueMovable && !redMovable) break;
            }
            
            if (arrived) {
                answer = i+1;
                return;
            }
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            
                if (board[i][j] == 'R') {
                    red = new Ball(i, j);
                }
                else if (board[i][j] == 'B') {
                    blue = new Ball(i, j);
                }
            }
        }
        
        br.close();
    }
    
    static class Ball {
        int x;
        int y;
        
        public Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
