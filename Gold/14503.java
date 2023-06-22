import java.util.*;
import java.io.*;

public class Main {
    static int n, m, answer = 0;
    static Robot robot;
    static int[][] rooms;
    
    // 0: 북, 1: 동, 2: 남, 3: 서
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    
    public static void main(String args[]) throws IOException {
        input();
        
        while(true) {
            //1
            if (rooms[robot.r][robot.c] == 0) {
                rooms[robot.r][robot.c] = 2;
                answer++;
            }
            
            // check nearby rooms
            int idx = 0, nd = robot.d - 1;
            boolean cleanable = false;
            
            while (idx < 4) {
                if (nd < 0) nd = 3;
                int nr = robot.r + dx[nd];
                int nc = robot.c + dy[nd];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                
                if (rooms[nr][nc] == 0) {
                    robot.r = nr;
                    robot.c = nc;
                    robot.d = nd;
                    cleanable = true;
                    break;
                }
                
                nd--;
                idx++;
            }
            
            if (cleanable) continue;
            
            int td = robot.d + 2;
            if (td > 3) td -= 4;
            int br = robot.r + dx[td];
            int bc = robot.c + dy[td];
            
            if (rooms[br][bc] == 1) break;
            
            robot.r = br;
            robot.c = bc;
        }
        
        System.out.println(answer);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        rooms = new int[n][m];
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        robot = new Robot(r, c, d);
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        br.close();
    }
    
    static class Robot {
        int r;
        int c;
        int d;
        
        public Robot(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
