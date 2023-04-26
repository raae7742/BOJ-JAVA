import java.io.*;
import java.util.*;

public class Main {
    static int r, c, m, answer = 0;
    static int king = 0;
    static Shark[] sharks;
    static int[][] pool;
    
    public static void main(String args[]) throws IOException {
        input();
        
        int time = 0;
        while(king < c) {
          // move right.
          king += 1;
          
          // catch a shark which is nearest to ground.
          catchShark();
          
          // sharks move.
          moveShark();
          
          // sharks eat each other.
          eatAllSharks();
        }
        
        System.out.println(answer);
    }
    
    private static void catchShark() {
        for (int i = 1; i <= r; i++) {
            if (pool[i][king] != 0) {
                Shark shark = sharks[pool[i][king]];
                answer += shark.size;
                shark.size = -1;
                pool[i][king] = 0;
                return;
            }
        }
    }
    
    private static void moveShark() {
        for (int i = 1; i < sharks.length; i++) {
            if (sharks[i].size == -1) continue;
          
            for (int j = 1; j <= sharks[i].vel; j++) {
                if (sharks[i].dir == 1) {
                    if (sharks[i].x <= 1) {
                        sharks[i].dir = 2;
                        sharks[i].x = 2;
                    } else {
                        sharks[i].x -= 1;
                    }
                }
                else if (sharks[i].dir == 2) {
                    if (sharks[i].x >= r) {
                        sharks[i].dir = 1;
                        sharks[i].x = r-1;
                    }
                    else {
                        sharks[i].x += 1;
                    }
                }
                else if (sharks[i].dir == 3) {
                    if (sharks[i].y >= c) {
                        sharks[i].dir = 4;
                        sharks[i].y = c-1;
                    } else {
                        sharks[i].y += 1;
                    }
                }
                else {
                    if (sharks[i].y <= 1) {
                        sharks[i].dir = 3;
                        sharks[i].y = 2;
                    } else {
                        sharks[i].y -= 1;
                    }
                }
            }
        }
        // when the shark collider with the wall, change the direction.

    }
    
    private static void eatAllSharks() {
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                pool[i][j] = 0;
            }
        }

        for (int i = 1; i < sharks.length; i++) {
            Shark shark = sharks[i];
            if (shark.size < 0) continue;
            
            if (pool[shark.x][shark.y] == 0) {
                pool[shark.x][shark.y] = i;
                continue;
            }
            
            int other = pool[shark.x][shark.y];
            if (sharks[other].size > shark.size) {
                shark.size = -1;
                continue;
            } 
            
            sharks[other].size = -1;
            pool[shark.x][shark.y] = i;
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        pool = new int[r+1][c+1];
        sharks = new Shark[m+1];
        
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            sharks[i] = new Shark(x, y, s, d, z);
            pool[x][y] = i;
        }
        
        br.close();
    }
    
    static class Shark {
        int x;
        int y;
        int vel;
        int dir;            // 1: top, 2: bottom, 3: right, 4: left
        int size;
        
        public Shark (int x, int y, int s, int d, int z) {
            this.x = x;
            this.y = y;
            this.vel = s;
            this.dir = d;
            this.size = z;
        }
    }
}
