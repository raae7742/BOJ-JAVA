import java.io.*;
import java.util.*;

public class Main {
    static int t, k;
    static int[][] gears;
    static List<Rotation> rotations = new ArrayList<>();;
    
    public static void main(String args[]) throws IOException {
        input();
        
        for (Rotation r : rotations) {
            List<Rotation> list = new ArrayList<>();
            list.add(r);
            
            // 왼쪽 회전
            if (r.idx > 1) {
                int curIdx = r.idx;
                int curDir = r.dir;
                int leftIdx = r.idx - 1;
                
                while (leftIdx >= 1) {
                    if (gears[curIdx][6] == gears[leftIdx][2]) break;
                    
                    curIdx = leftIdx;
                    curDir = (curDir == 1) ? -1 : 1;
                    leftIdx = curIdx - 1;
                    list.add(new Rotation(curIdx, curDir));
                }
            }
            
            // 오른쪽 회전
            if (r.idx < t) {
                int curIdx = r.idx;
                int curDir = r.dir;
                int rightIdx = r.idx + 1;
                
                while (rightIdx <= t) {
                    if (gears[curIdx][2] == gears[rightIdx][6]) break;
                    
                    curIdx = rightIdx;
                    curDir = (curDir == 1) ? -1 : 1;
                    rightIdx = curIdx + 1;
                    list.add(new Rotation(curIdx, curDir));
                }
            }
            
            for (Rotation r2 : list) {
                rotate(r2);
            }
        }

        System.out.println(getAnswer());
    }
    
    private static int getAnswer() {
        int answer = 0;
        for (int i = 1; i <= t; i++) {
            if (gears[i][0] == 1) answer++;
        }
        
        return answer;
    }
    
    private static void rotate(Rotation r) {
        if (r.dir == 1) {           // 시계 방향
            int temp = gears[r.idx][7];
            for (int i = 7; i >= 1; i--) {
                gears[r.idx][i] = gears[r.idx][i-1];
            }
            gears[r.idx][0] = temp;
        }
        else {                      // 반시계 방향
            int temp = gears[r.idx][0];
            for (int i = 0; i < 7; i++) {
                gears[r.idx][i] = gears[r.idx][i+1];
            }
            gears[r.idx][7] = temp;
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        gears = new int[t+1][8];
        
        for (int i = 1; i <= t; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = input.charAt(j) - '0';
            }
        }
        
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            rotations.add(new Rotation(idx, dir));
        }
        
        br.close();
    }
    
    static class Rotation {
        int idx;
        int dir;
        
        public Rotation(int i, int d) {
            this.idx = i;
            this.dir = d;
        }
    }
}
