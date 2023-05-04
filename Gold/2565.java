import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static Wire[] wires;
    
    public static void main(String args[]) throws IOException {
        input();
        
        Arrays.sort(wires);
        
        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            Wire w = wires[i];
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                Wire other = wires[j];
                if (w.b > other.b) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(n - max);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        wires = new Wire[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            wires[i] = new Wire(a, b);
        }
        
        br.close();
    }
    
    static class Wire implements Comparable<Wire> {
        int a;
        int b;
        
        public Wire(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public int compareTo(Wire w) {
            return this.a - w.a;
        }
    }
}
