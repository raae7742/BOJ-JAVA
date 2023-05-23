import java.io.*;
import java.util.*;

public class Main {
    static int h, w;
    static int[][] sky;
    static List<Cloud> clouds = new ArrayList<>();
    
    public static void main(String args[]) throws IOException {
        input();
        
        int time = 0;
        while (!clouds.isEmpty()) {
            time += 1;
            
            List<Cloud> removes = new ArrayList<>();
            for (Cloud c : clouds) {
                if (++c.y >= w) {
                    removes.add(c);
                    continue;
                }
                if (sky[c.x][c.y] == -1) sky[c.x][c.y] = time;
            }
            
            for (Cloud c  : removes) {
                clouds.remove(c);
            }
        }
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(sky[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        
        sky = new int[h][w];
        
        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                sky[i][j] = -1;
                if (str.charAt(j) == 'c') {
                    sky[i][j] = 0;
                    clouds.add(new Cloud(i, j));
                }
            }
        }
        
        br.close();
    }
    
    static class Cloud {
        int x;
        int y;
        
        public Cloud (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
