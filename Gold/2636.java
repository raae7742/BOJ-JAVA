import java.io.*;
import java.util.*;

public class Main {
    static int n, m, out = -1, time = 0;
    static int[][] cheeze;     // 0: 빈칸, 1: 치즈
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String args[]) throws IOException {
        input();
        
        int idx = 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (cheeze[i][j] != 0) continue;
                
                boolean isHole = checkIsHole(i, j, idx);
                if (!isHole) out = idx;
                idx += 1;
                
            }
        }
        
        while(true) {
            time += 1;
            
            List<Pos> removes = new ArrayList<>();
            int cnt = 0;
            
            for (int i = 2; i < n; i++) {
                for (int j = 2; j < m; j++) {
                    if (cheeze[i][j] != 1) continue;
                    
                    cnt++;
                    boolean isEdge = false;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if (cheeze[nx][ny] == out) {
                            isEdge = true;
                            break;
                        }
                    }
                    
                    if (isEdge) removes.add(new Pos(i, j));
                }
            }
            
            for (Pos p : removes) {
                cheeze[p.x][p.y] = out;
            }
            
            for (int i = 2; i < n; i++) {
                for (int j = 2; j < m; j++) {
                    if (cheeze[i][j] == out || cheeze[i][j] == 1) continue;
                    
                    boolean isHole = true;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if (cheeze[nx][ny] == out) {
                            isHole = false;
                            break;
                        }
                    }
                    
                    if (isHole) continue;
                    
                    Queue<Pos> q = new LinkedList<>();
                    q.add(new Pos(i, j));
                    cheeze[i][j] = out;
                    
                    while (!q.isEmpty()) {
                        Pos p = q.poll();
                        
                        for (int d = 0; d < 4; d++) {
                            int nx = p.x + dx[d];
                            int ny = p.y + dy[d];
                            
                            if (cheeze[nx][ny] == 1 || cheeze[nx][ny] == out) continue;
                            
                            cheeze[nx][ny] = out;
                            q.add(new Pos(nx, ny));
                        }
                    }
                }
            }
            
            if (cnt == removes.size()) {
                System.out.println(time);
                System.out.println(cnt);
                break;
            }
        }
    }
    
    private static boolean checkIsHole(int i, int j, int idx) {
        boolean isHole = true;
        
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(i, j));
        cheeze[i][j] = idx;
        
        while (!q.isEmpty()) {
            Pos p = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                
                if (nx < 1 || nx > n || ny < 1 || ny > m) {
                    isHole = false;
                    continue;
                }
                if (cheeze[nx][ny] != 0) continue;
                
                cheeze[nx][ny] = idx;
                q.add(new Pos(nx, ny));
            }
        }
        
        return isHole;
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cheeze = new int[n+1][m+1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                cheeze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        br.close();
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
