import java.io.*;
import java.util.*;

public class Main {
    static int n, answer = 0;
    static List<Prob> list = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      
      for (int i = 0; i < n; i++) {
          StringTokenizer st = new StringTokenizer(br.readLine());
          int d = Integer.parseInt(st.nextToken());
          int s = Integer.parseInt(st.nextToken());
          
          list.add(new Prob(d, s));
      }
      
      Collections.sort(list);
      
      int time = 1;
      for (int i = 0; i < n; i++) {
          Prob p = list.get(i);
          
          if (time <= p.deadline) {
              pq.add(p.score);
              time++;
          }
          else if (pq.peek() < p.score) {
              pq.remove();
              pq.add(p.score);
          }
      }
      
      while (!pq.isEmpty()) {
          answer += pq.poll();
      }
      
      System.out.println(answer);
    }
    
    static class Prob implements Comparable<Prob> {
        int deadline;
        int score;
        
        public Prob(int d, int s) {
            this.deadline = d;
            this.score = s;
        }
        
        @Override
        public int compareTo(Prob p) {
            if (this.deadline == p.deadline) return this.score - p.score;
            return this.deadline - p.deadline;
        }
    }
}
