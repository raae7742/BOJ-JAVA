import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int min = Integer.MIN_VALUE, max = 0;
    static int[] costs;
    
    public static void main(String args[]) throws IOException {
        input();
        
        while (min <= max) {
            int mid = (min + max) / 2;
            int cnt = 0, bal = 0;

            for (int i = 0; i < n; i++) {
                if (bal < costs[i]) {
                    cnt += 1;
                    bal = mid;
                }
                bal -= costs[i];
            }
            
            if (cnt > m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        System.out.println(min);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, costs[i]);
            max += costs[i];
        }
        
        br.close();
    }
}
