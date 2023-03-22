import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int min = 100000, cnt = 0;
    static Queue<Integer> q = new LinkedList<>();
    static int[] secs = new int[100001];
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      
      if (n >= k) {
          min = n-k;
          cnt = 1;
      }
      else {
          bfs();
      }
      
      System.out.println(min);
      System.out.println(cnt);
    }
    
    private static void bfs() {
        q.add(n);
        secs[n] = 1;
        
        while (!q.isEmpty()) {
            int x = q.poll();
            if (min < secs[x]) return;
            
            confirmNextXIsValid(x, x+1);
            confirmNextXIsValid(x, x-1);
            confirmNextXIsValid(x, x*2);
        }
    }
    
    private static void confirmNextXIsValid(int x, int nextX) {
        if (nextX == k) {
            min = secs[x];
            cnt++;
        }
        
        if ((nextX >= 0 && nextX <= 100000) && (secs[nextX] == 0 || secs[nextX] >= secs[x] + 1)) {
            q.add(nextX);
            secs[nextX] = secs[x] + 1;
        }
    }
      
}
