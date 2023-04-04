import java.io.*;
import java.util.*;

public class Main {
    
    static int n, sum = 0;
    static int[] people;
    static int[][] link;
    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String args[]) throws IOException {
        input();
        
        selected = new boolean[n+1];
        divide(0);
        
        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
    
    private static void divide(int idx) {
        if (idx == n) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (selected[i]) 
                    a.add(i);
                else 
                    b.add(i);
            }
            
            if (check(a) && check(b)) calculateAnswer();
            
            return;
        }
        
        selected[idx] = true;
        divide(idx+1);
        selected[idx] = false;
        divide(idx+1);
    }
    
    private static boolean check(List<Integer> a) {
        if (a.size() == 0) return false;
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        int area = a.get(0);
        q.offer(area);
        visited[area] = true;
        
        int cnt = 1;
        while (!q.isEmpty()) {
            area = q.poll();
            for (int i = 0; i < n; i++) {
                int next = link[area][i];
                if (next == 0) break;
                
                if (a.contains(next) && !visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }
        
        if (cnt == a.size()) return true;
        return false;
    }
    
    private static void calculateAnswer() {
        int sumA = 0, sumB = 0;
        for (int i = 1; i <= n; i++) {
            if (selected[i]) 
                sumA += people[i];
            else 
                sumB += people[i];
        }
        
        answer = Math.min(answer, Math.abs(sumA - sumB));
    }
    
    private static void input() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      people = new int[n+1];
      link = new int[n+1][n+1];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
          people[i] = Integer.parseInt(st.nextToken());
          sum += people[i];
      }
      
      for (int i = 1; i <= n; i++) {
          st = new StringTokenizer(br.readLine());
          int cnt = Integer.parseInt(st.nextToken());
          
          for (int j = 0; j < cnt; j++) {
              link[i][j] = Integer.parseInt(st.nextToken());
          }
      }
      
      br.close();
    }
}
