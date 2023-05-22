import java.util.*;
import java.io.*;

public class Main {
    static int n, c;
    static Map<Integer, Number> map = new HashMap<>();
    
    public static void main(String args[]) throws IOException {
        input();
        
        List<Number> list = new ArrayList<>();
        
        for(int key : map.keySet()) {
            list.add(map.get(key));
        }
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Number number = list.get(i);
            
            while (number.cnt > 0) {
                sb.append(number.num + " ");
                number.cnt -= 1;
            }
        }
        
        System.out.println(sb.toString());
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if (map.containsKey(num)) {
                map.get(num).cnt += 1;
            }
            else {
                map.put(num, new Number(i, num, 1));
            }
        }
        
        br.close();
    }
    
    static class Number implements Comparable<Number> {
        int idx;
        int num;
        int cnt;
        
        public Number(int idx, int num, int cnt) {
            this.idx = idx;
            this.num = num;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Number other) {
            if (this.cnt == other.cnt) return this.idx - other.idx;
            return other.cnt - this.cnt;
        }
    }
}
