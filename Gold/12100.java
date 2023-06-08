import java.util.*;
import java.io.*;

public class Main {
    static int n, answer = 2;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dir = new int[5];
    
    public static void main(String args[]) throws IOException {
        input();
        
        dfs(0);
        
        System.out.println(answer);
    }
    
    private static void dfs(int cnt) {
        if (cnt >= 5) {
            move();
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            dir[cnt] = i;
            dfs(cnt+1);
        }
    }
    
    private static void move() {
        int[][] temp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = board[i][j];
            }
        }
        
        for (int i = 0; i < 5; i++) {
            boolean[][] combined = new boolean[n][n];
            
            switch(dir[i]) {
                case 0: //top
                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < n; y++) {
                            if (temp[x][y] == 0) continue;
                            
                            int cx = x;
                            int nx = x-1;
                            while (true) {
                                if (nx < 0 || nx >= n) break;
                                
                                if (temp[nx][y] == 0) {
                                    temp[nx][y] += temp[cx][y];
                                    temp[cx][y] = 0;
                                }
                                else if (temp[nx][y] == temp[cx][y] && !combined[nx][y] && !combined[cx][y]) {
                                    temp[nx][y] += temp[cx][y];
                                    temp[cx][y] = 0;
                                    combined[nx][y] = true;
                                } else {
                                    break;
                                }
                                
                                cx = nx;
                                nx -= 1;
                            }
                        }
                    }
                    break;
                case 1: //down
                    for (int x = n-1; x >= 0; x--) {
                        for (int y = 0; y < n; y++) {
                            if (temp[x][y] == 0) continue;
                            
                            int cx = x;
                            int nx = x+1;
                            while (true) {
                                if (nx < 0 || nx >= n) break;
                                
                                if (temp[nx][y] == 0) {
                                    temp[nx][y] += temp[cx][y];
                                    temp[cx][y] = 0;
                                }
                                else if (temp[nx][y] == temp[cx][y] && !combined[nx][y] && !combined[cx][y]) {
                                    temp[nx][y] += temp[cx][y];
                                    temp[cx][y] = 0;
                                    combined[nx][y] = true;
                                } else {
                                    break;
                                }
                                
                                cx = nx;
                                nx += 1;
                            }
                        }
                    }
                    break;
                case 2: //left
                    for (int y = 0; y < n; y++) {
                        for (int x = 0; x < n; x++) {
                            if (temp[x][y] == 0) continue;
                            
                            int cy = y;
                            int ny = y-1;
                            while (true) {
                                if (ny < 0 || ny >= n) break;
                                
                                if (temp[x][ny] == 0) {
                                    temp[x][ny] += temp[x][cy];
                                    temp[x][cy] = 0;
                                }
                                else if (temp[x][ny] == temp[x][cy] && !combined[x][ny] && !combined[x][cy]) {
                                    temp[x][ny] += temp[x][cy];
                                    temp[x][cy] = 0;
                                    combined[x][ny] = true;
                                } else {
                                    break;
                                }
                                
                                cy = ny;
                                ny -= 1;
                            }
                        }
                    }
                    break;
                case 3: // right
                    for (int y = n-1; y >= 0; y--) {
                        for (int x = 0; x < n; x++) {
                            if (temp[x][y] == 0) continue;
                            
                            int cy = y;
                            int ny = y+1;
                            while (ny >= 0 && ny < n) {
                                if (temp[x][ny] == 0) {
                                    temp[x][ny] += temp[x][cy];
                                    temp[x][cy] = 0;
                                }
                                else if (temp[x][ny] == temp[x][cy] && !combined[x][ny] && !combined[x][cy]) {
                                    temp[x][ny] += temp[x][cy];
                                    temp[x][cy] = 0;
                                    combined[x][ny] = true;
                                } else {
                                    break;
                                }
                                
                                cy = ny;
                                ny += 1;
                            }
                        }
                    }
                    break;
            }
        }
        
        findMax(temp);
    }
    
    private static void findMax(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, arr[i][j]);
            }
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        board = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }        
        }
        
        br.close();
    }
}
