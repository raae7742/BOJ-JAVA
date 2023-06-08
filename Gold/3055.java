import java.util.*;
import java.io.*;

public class Main {
    static int r, c, answer = -1;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static Queue<Hedge> q = new LinkedList<>();
    
    public static void main(String args[]) throws IOException {
        input();
        
        int time = 0;
        while (true) {
            time += 1;
            
            moveWater();
            
            Queue<Hedge> next = new LinkedList<>();
            while (!q.isEmpty()) {
                Hedge cur = q.poll();
                
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                    if (visited[nx][ny] || map[nx][ny] == '*' || map[nx][ny] == 'X') continue;
                    
                    if (map[nx][ny] == 'D') {
                        answer = time;
                        break;
                    }
                    
                    visited[nx][ny] = true;
                    next.add(new Hedge(nx, ny));
                }
                
                if (answer != -1) break;
            }
            
            if (answer != -1) break;
            if (next.isEmpty()) break;
            
            while (!next.isEmpty()) {
                q.add(next.poll());
            }
        }
        
        if (answer == -1)  {
            System.out.println("KAKTUS");
        }
        else {
            System.out.println(answer);
        }
    }
    
    private static void moveWater() {
        char[][] temp = new char[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = map[i][j];
            }
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*') {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                        if (map[nx][ny] == 'D' || map[nx][ny] == 'X') continue;
                        
                        temp[nx][ny] = '*';
                    }
                }
            }
        }
        
        map = temp;
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new char[r][c];
        visited = new boolean[r][c];
        
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
                
                if (map[i][j] == 'S') {
                    q.add(new Hedge(i, j));
                    visited[i][j] = true;
                }
            }        
        }
        
        br.close();
    }
    
    static class Hedge {
        int x;
        int y;
        
        public Hedge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
