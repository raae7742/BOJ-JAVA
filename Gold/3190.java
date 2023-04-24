import java.io.*;
import java.util.*;

public class Main {
    static int n, k, l, time = 0, len = 1;
    
    static int[][] board;
    static int[][] dir;
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String args[]) throws IOException {
        input();
        
        int curDir = 0;
        int curX = 1;
        int curY = 1;
        boolean isGameOver = false;
        Queue<Pos> q = new LinkedList<>();
        
        board[curX][curY] = 2;
        q.add(new Pos(curX, curY));
        
        for (int i = 0; i < l; i++) {
            int x = dir[i][0];
            int c = dir[i][1];
            
            while (time < x) {
                // 계속 이동
                time += 1;
                curX += dx[curDir];
                curY += dy[curDir];
                
                // 만약 벽에 부딪치면 게임 오버
                if (curX > n || curX < 1 || curY > n || curY < 1) {
                    isGameOver = true;
                    break;
                }
                
                if (board[curY][curX] != 1) {   // 사과가 없다면
                    if (q.size () > len) {
                        Pos tail = q.poll();
                        board[tail.y][tail.x] = 0;
                    }
                } else {
                    len += 1;
                }
                
                if (board[curY][curX] == 2) {
                    isGameOver = true;
                    break;
                }
                
                board[curY][curX] = 2;
                q.add(new Pos(curX, curY));
            }
            
            if (isGameOver) break;
            
            if (c == 'D') {
                curDir += 1;
                if (curDir > 3) curDir = 0;
            } else {
                curDir -= 1;
                if (curDir < 0) curDir = 3;
            }
        }
        
        while (!isGameOver) {
            // 계속 이동
            time += 1;
            curX += dx[curDir];
            curY += dy[curDir];
            
            // 만약 벽에 부딪치면 게임 오버
            if (curX > n || curX < 1 || curY > n || curY < 1) {
                isGameOver = true;
                break;
            }
            
            if (board[curY][curX] != 1) {   // 사과가 없다면
                if (q.size () > len) {
                    Pos tail = q.poll();
                    board[tail.y][tail.x] = 0;
                }
            } else {
                len += 1;
            }
                
            if (board[curY][curX] == 2) {
                isGameOver = true;
                break;
            }
            
            board[curY][curX] = 2;
            q.add(new Pos(curX, curY));
        }
        
        System.out.println(time);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        board = new int[n+1][n+1];
        
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            
            board[row][col] = 1;
        }
        
        l = Integer.parseInt(br.readLine());
        dir = new int[l][2];
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int c = st.nextToken().charAt(0);
            
            dir[i][0] = x;
            dir[i][1] = c;
        }
    }
    
    static class Pos {
        int x;
        int y;
        
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
