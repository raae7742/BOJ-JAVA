import java.io.*;
import java.util.*;

public class Main {
    static int n, m, left = 0, right = 0;
    static int[] lectures;
    
    public static void main(String args[]) throws IOException {
        input();
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0, mem = 0;
            
            for (int i = 0; i < n; i++) {
                if (mem + lectures[i] > mid) {
                    mem = 0;
                    cnt += 1;
                }
                
                mem += lectures[i];
            }
            
            if (mem != 0) cnt++;
            
            if (cnt > m) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        lectures = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            right += lectures[i];
            left = Math.max(left, lectures[i]);
        }
        
        br.close();
    }
}
