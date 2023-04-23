import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
    static int[] a;
    static int[] oper = new int[4];
    
    public static void main(String args[]) throws IOException {
        input();
        
        dfs(1, a[0]);
        
        System.out.println(max);
        System.out.println(min);
    }
    
    private static void dfs(int cur, long result) {
        if (cur == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (oper[i] == 0) continue;
            
            oper[i] -= 1;
            switch (i) {
                case 0:
                    dfs(cur+1, result+a[cur]);
                    break;
                case 1:
                    dfs(cur+1, result-a[cur]);
                    break;
                case 2:
                    dfs(cur+1, result*a[cur]);
                    break;
                case 3:
                    dfs(cur+1, result/a[cur]);
                    break;
            }
            oper[i] += 1;
        }
    }
    
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
}
