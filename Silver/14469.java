import java.io.*;
import java.util.*;

public class Main {
    static int n, answer = 0;
    static PriorityQueue<Cow> pq = new PriorityQueue<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            
            pq.add(new Cow(a, t));
        }
        
        while (!pq.isEmpty()) {
            Cow c = pq.poll();
            
            if (answer < c.arrivedAt) answer = c.arrivedAt;
            answer += c.time;
        }
        
        System.out.println(answer);
    }
    
    static class Cow implements Comparable<Cow> {
        int arrivedAt;
        int time;
        
        public Cow (int a, int t) {
            this.arrivedAt = a;
            this.time = t;
        }
        
        @Override
        public int compareTo(Cow c) {
            return this.arrivedAt - c.arrivedAt;
        }
    }
}
