import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int max = Integer.MIN_VALUE;
    static int[] jewels;
    
    public static void main(String args[]) throws IOException {
        input();
        
        int answer = binarySearch();
        
        System.out.println(answer);
    }
    
    private static int binarySearch() {
        int min = Integer.MAX_VALUE;
        int low = 1, high = max;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;
            
            for (int jewel : jewels) {
                int people = (jewel % mid == 0) ? (jewel / mid) : (jewel / mid + 1);
                sum += people;
            }

            if (n >= sum) {
                min = Math.min(min, mid);
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }

        }
        
        
        return min;
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        jewels = new int[m];
        
        
        for (int i = 0; i < m; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, jewels[i]);
        }
    }
}
