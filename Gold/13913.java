import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int min = 100000;
    static Queue<Integer> q = new LinkedList<>();
    static int[] secs = new int[100001];
    static int[] befores = new int[100001];
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      
      if (n >= k) {
          System.out.println(n-k);
          for (int i = n; i >= k; i--) {
              System.out.print(i + " ");
          }
      }
      else {
          bfs();
          System.out.println(min);
          
          int x = k;
          Stack<Integer> s = new Stack<>();
          for (int i = 0; i < min; i++) {
              s.push(x);
              x = befores[x];
          }
          s.push(n);
          
          for (int i = 0; i < min+1; i++) {
              System.out.print(s.peek() + " ");
              s.pop();
          }
      }
    }
    
    private static void bfs() {
        q.add(n);
        secs[n] = 1;
        
        while (!q.isEmpty()) {
            int x = q.poll();
            if (min < secs[x]) return;
            if (x == k) {
                min = secs[x];
                return;
            }
            
            confirmNextXIsValid(x, x+1);
            confirmNextXIsValid(x, x-1);
            confirmNextXIsValid(x, x*2);
        }
    }
    
    private static void confirmNextXIsValid(int x, int nextX) {
        if (nextX == k) {
            min = secs[x];
        }
        
        if ((nextX >= 0 && nextX <= 100000) && (secs[nextX] == 0 || secs[nextX] >= secs[x] + 1)) {
            q.add(nextX);
            secs[nextX] = secs[x] + 1;
            befores[nextX] = x;
        }
    }
      
}
