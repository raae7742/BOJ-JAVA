import java.util.*;
import java.io.*;

public class Main {
    static int n, l;
    static List<Lake> lakes = new ArrayList<>();
    static long answer = 0;

    public static void main(String args[]) throws IOException {
        input();
        
        Collections.sort(lakes);
        
        long last = 0;
        for (Lake lake : lakes) {
            last = Math.max(last, lake.start);
            
            if (lake.end >= last) {
                while (lake.end > last) {
                    last += l;
                    answer++;
                }
            }
        }
        
        System.out.println(answer);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            
            lakes.add(new Lake(s, e));
        }
        
        br.close();
    }
    
    static class Lake implements Comparable<Lake> {
        long start;
        long end;
        
        public Lake(long s, long e) {
            this.start = s;
            this.end = e;
        }
        
        @Override
        public int compareTo(Lake l) {
            return (int)(this.start - l.start);
        }
    }
}
