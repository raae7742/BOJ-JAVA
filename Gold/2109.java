import java.util.*;
import java.io.*;

public class Main {
    static int n, answer = 0;
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    static List<Univ> list = new ArrayList<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            list.add(new Univ(p, d));
        }
        
        Collections.sort(list);
        
        //순차적으로 확인하면서 오늘 강연이 가능하면 큐에 추가
        int today = 1;
        for (int i = 0; i < n; i++) {
            Univ u = list.get(i);
            if (today <= u.d) {
                q.add(u.p);
                today++;
            }
            else if (q.peek() < u.p) {
                q.remove();
                q.add(u.p);
            }
        }
        
        while (!q.isEmpty()) {
            answer += q.poll();
        }
        
        System.out.println(answer);
    }
    
    static class Univ implements Comparable<Univ> {
        int p;
        int d;
        
        public Univ(int p, int d) {
            this.p = p;
            this.d = d;
        }
        
        @Override
        public int compareTo(Univ u) {
            if (this.d == u.d) return this.p - u.p;
            return this.d - u.d;
        }
    }
}
