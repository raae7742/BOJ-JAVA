import java.io.*;
import java.util.*;

public class Main {
    static int n, answer = 0;
    static Curve[] curves;      // x: left => right, y: top -> bottom
    static int[][] plain = new int[101][101];
    
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};
    
    public static void main(String args[]) throws IOException {
        input();
        
        for (int i = 0; i < n; i++) {
            drawCurve(curves[i]);
        }
        
        countRect();
        System.out.println(answer);
    }
    
    private static void drawCurve(Curve curve) {
        int curX = curve.x, curY = curve.y;
        int newX = curX + dx[curve.dir], newY = curY + dy[curve.dir];

        List<Integer> dirList = new ArrayList<>();
        dirList.add(curve.dir);
        
        plain[curY][curX]++;
        plain[newY][newX]++;
        
        curX = newX; 
        curY = newY;
        for (int i = 1; i <= curve.gene; i++) {
            for (int j = dirList.size() - 1; j >= 0; j--) {
                int dir = dirList.get(j) + 1;
                if (dir > 3) dir = 0;
                
                newX = curX + dx[dir];
                newY = curY + dy[dir];
                plain[newY][newX]++;
                
                curY = newY;
                curX = newX;
                
                dirList.add(dir);
            }
        }
    }
    
    private static void countRect() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (plain[i][j] != 0 && plain[i+1][j] != 0 && plain[i][j+1] != 0 && plain[i+1][j+1] != 0) {
                    answer++;
                }
            }
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        curves = new Curve[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());            
            int y = Integer.parseInt(st.nextToken());            
            int d = Integer.parseInt(st.nextToken());            
            int g = Integer.parseInt(st.nextToken());    
            
            curves[i] = new Curve(x, y, d, g);
        }

        br.close();
    }
    
    static class Curve {
        int x;
        int y;
        int dir;            //0: x++, 1: y--, 2: x--, 3: y++
        int gene;
        
        public Curve (int x, int y, int dir, int gene) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.gene = gene;
        }
    }
}
