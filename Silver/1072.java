import java.io.*;
import java.util.*;

public class Main {
    static long x, y, z, answer = -1;
    
    public static void main(String args[]) throws IOException {
        input();
        
        long z = y * 100 / x, newZ = 0;
        long left = 1, right = x;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            newZ = (y + mid) * 100 / (x + mid);
            
            if (newZ == z) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
    
        newZ = (y + left) * 100 / (x + left);
        if (newZ != z) answer = left;

        System.out.println(answer);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
        
        br.close();
    }
}
