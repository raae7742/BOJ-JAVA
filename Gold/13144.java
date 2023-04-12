import java.util.*;
import java.io.*;

public class Main {
    static int n = 0;
    static long answer = 0;
    static int[] nums;
    static boolean[] visited;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        nums = new int[n+1];
        visited = new boolean[100001];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int r = 0;
        for (int l = 1; l <= n; l++) {
            if (visited[nums[l-1]]) visited[nums[l-1]] = false;
            
            while (r+1 <= n && !visited[nums[r+1]]) {
                visited[nums[++r]] = true;
            }
            
            answer += (r-l+1);
        }
        
        System.out.println(answer);
        br.close();
    }
}
