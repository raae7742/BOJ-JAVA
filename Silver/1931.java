import java.io.*;
import java.util.*;

public class Main {
    static int n, answer = 0;
    static PriorityQueue<Meet> pq = new PriorityQueue<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            pq.add(new Meet(s, e));
        }
        
        int time = 0;
        while (!pq.isEmpty()) {
            Meet m = pq.poll();
            
            if (m.start >= time) {
                answer++;
                time = m.end;
            }
        }
        
        System.out.println(answer);
    }
    
    static class Meet implements Comparable<Meet> {
        int start;
        int end;
        
        public Meet (int s, int e) {
            this.start = s;
            this.end = e;
        }
        
        @Override
        public int compareTo(Meet m) {
            if (this.end == m.end) return this.start - m.start;
            return this.end - m.end;
        }
    }
}
