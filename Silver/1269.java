import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a, b;
    
    static final int MAX = 100000000;
    
    public static void main(String args[]) throws IOException {
        input();
        
        Arrays.sort(b);
        
        int[] copyA = new int[n];
        for (int i = 0; i < n; i++) {
            copyA[i] = a[i];
        }
        
        int[] copyB = new int[m];
        for (int i = 0; i < m; i++) {
            copyB[i] = b[i];
        }
        
        for (int i = 0; i < n; i++) {
            int left = 0, right = m-1;
            
            while (left <= right) {
                int mid = (left + right) / 2;
                
                if (b[mid] > a[i]) {
                    right = mid - 1;
                }
                else if (b[mid] == a[i]) {
                    copyB[mid] = -1;
                    copyA[i] = -1;
                    break;
                }
                else {
                    left = mid + 1;
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (copyA[i] > 0) answer++;
        }
        
        for (int i = 0; i < m; i++) {
            if (copyB[i] > 0) answer++;
        }
        
        System.out.println(answer);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        a = new int[n];
        b = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
}
