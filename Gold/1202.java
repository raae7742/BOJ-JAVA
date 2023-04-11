import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long answer = 0;
    static PriorityQueue<Gem> gems = new PriorityQueue<>();
    static PriorityQueue<Long> bags = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            // 무거움 -> 가벼움 순으로 정렬
            gems.add(new Gem(m, v));
        }
        
        for (int i = 0; i < k; i++) {
            long c = Long.parseLong(br.readLine());
            
            // 내림차순으로 정렬
            bags.add(c);
        }
        
        // 가방을 돌면서
        while (!bags.isEmpty()) {
            long c = bags.poll();
            
            // 가장 무거운 것부터 가능한 보석을 담기
            while (!gems.isEmpty()) {
                Gem gem = gems.poll();
                
                if (c >= gem.m) {
                    pq.add(gem.v);
                    break;
                }
                
                // 만약 담을 수 있는 가방이 없지만,
                // 이전에 담은 가장 값싼 보석보다 귀하다면 교환
                if (!pq.isEmpty() && gem.v > pq.peek()) {
                    pq.remove();
                    pq.add(gem.v);
                }
            }
        }
        
        while (!gems.isEmpty()) {
            Gem gem = gems.poll();
            if (gem.v > pq.peek()) {
                pq.remove();
                pq.add(gem.v);
            }
        }
        
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        
        System.out.println(answer);
    }
    
    static class Gem implements Comparable<Gem> {
        int m;
        int v;
        
        public Gem (int m, int v) {
            this.m = m;
            this.v = v;
        }
        
        @Override
        public int compareTo(Gem g) {
            return g.m - this.m;
        }
    }
}
