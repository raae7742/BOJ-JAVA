import java.util.*;
import java.io.*;

public class Main {
    static String n;
    static int m, k, answer = -1;
    static boolean[][] visited;
    
    public static void main(String args[]) throws IOException {
        input();
        visited = new boolean[k+1][1000001];
        
        m = n.length();
        dfs(0, n);
        System.out.println(answer);
    }
    
    private static void dfs(int cnt, String str) {
        if (cnt == k) {
            int num = Integer.parseInt(str);
            answer = Math.max(answer, num);
            return;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                char a = str.charAt(i);
                char b = str.charAt(j);
                if (i == 0 && b == '0') continue;
                
                String newStr = str.substring(0, i) + b + str.substring(i+1, j) + a + str.substring(j+1, str.length());
                int newNum = Integer.parseInt(newStr);
                if (visited[cnt][newNum]) continue;
                
                visited[cnt][newNum] = true;
                dfs(cnt+1, newStr);
            }
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = st.nextToken();
        k = Integer.parseInt(st.nextToken());
        
        br.close();
    }
}
