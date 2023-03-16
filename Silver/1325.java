import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      List<List<Integer>> com = new ArrayList();
      for (int i = 0; i <= n; i++) {
        com.add(new ArrayList<Integer>());
      }
      
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        com.get(b).add(a);
      }
      
      int[] result = new int[n+1];
      int max = 0;
      for (int i = 1; i <= n; i++) {
          boolean[] visited = new boolean[n+1];
          Queue<Integer> q = new LinkedList();
          q.add(i);
          int cnt = 1;
          visited[i] = true;

          while (!q.isEmpty()) {
              int num = q.poll();
              for (int j : com.get(num)) {
                  if (!visited[j]) {
                      q.add(j);
                      cnt++;
                      visited[j] = true;
                  }
              }
          }
          
          result[i] = cnt;
          max = (cnt > max) ? cnt : max;
      }
      
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= n; i++) {
          if (result[i] == max) sb.append(i + " ");
      }
      
      System.out.println(sb);
    }
}
