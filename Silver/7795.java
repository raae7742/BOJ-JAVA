import java.io.*;
import java.util.*;

public class Main {
    static int t, n, m;
    static int min = Integer.MIN_VALUE, max = 0;
    static int[] a, b;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            a = new int[n];
            b = new int[m+1];
            
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(b);
            
            int answer = 0;
            for (int j = 0; j < n; j++) {
                int left = 0, right = m;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    
                    if (b[mid] >= a[j]) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                answer += left - 1;
            }
            
            System.out.println(answer);
        }
        
        br.close();
    }
}
