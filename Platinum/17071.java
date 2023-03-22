import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[][] visited = new boolean[500001][2];

    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      
      if (n == k) System.out.println(0);
      else System.out.println(bfs());
    }
    
    private static int bfs() {
        int time = 0;
        q.add(n);
        visited[n][time%2] = true;
        
        while (!q.isEmpty()) {
            if (k > 500000) return -1;
            if (visited[k][time%2]) return time;
            
            for(int j = 0, size = q.size(); j < size; j++) {
                int now = q.poll();

                confirmNextXIsValid(now+1, time+1);
                confirmNextXIsValid(now-1, time+1);
                confirmNextXIsValid(now*2, time+1);
            }
            time++;
            k += time;
        }
        
        return -1;
    }
    
    private static void confirmNextXIsValid(int nextX, int nextTime) {
        if (nextX >= 0 && nextX <= 500000 && !visited[nextX][nextTime%2]) {
            q.add(nextX);
            visited[nextX][nextTime%2] = true;
        }
    }
}
