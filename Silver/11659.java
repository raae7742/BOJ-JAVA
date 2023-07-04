import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] nums;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        nums = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
        }
        
        for (int d = 0; d < m; d++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            System.out.println(nums[j] - nums[i-1]);
        }
        
        br.close();
    }
}
