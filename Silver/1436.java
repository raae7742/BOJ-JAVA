import java.util.*;
import java.io.*;

public class Main {
    
    static int n, answer = -1;
    static final int max = 100000666;
    
    public static void main(String args[]) throws IOException {
        input();
        
        int cnt = 0;
        for (int i = 0; i < max; i++) {
            boolean is666 = false;
            String str = Integer.toString(i);
            
            for (int j = 0; j < str.length() - 2; j++) {
                if (str.charAt(j) == '6' && str.charAt(j+1) == '6' && str.charAt(j+2) == '6') {
                    is666 = true;
                    break;
                }
            }
            
            if (is666) cnt += 1;
            if (cnt == n) {
                answer = i;
                break;
            }
            
        }

        System.out.println(answer);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        br.close();
    }
}
