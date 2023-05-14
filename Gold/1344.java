import java.util.*;
import java.io.*;

public class Main {
    static double a, b;
    static double[][] dp = new double[19][2];
    
    public static void main(String args[]) throws IOException {
        input();
        
        if (a == 100) {
            dp[0][0] = 1;
            for (int i = 1; i <= 18; i++) {
                dp[i][0] = 0;
            }
        }
        else {
            dp[0][0] = Math.pow(((100-a) / 100), 18);
            for (int i = 1; i <= 18; i++) {
                dp[i][0] = dp[i-1][0] * (a / 100) / ((100-a) / 100) * (18 - i + 1) / i;
            }
        }

        if (b == 100) {
            dp[0][1] = 1;
            for (int i = 1; i <= 18; i++) {
                dp[i][1] = 0;
            }
        }
        else {
            dp[0][1] = Math.pow(((100-b) / 100), 18);
            for (int i = 1; i <= 18; i++) {
                dp[i][1] = dp[i-1][1] * (b / 100) / ((100-b) / 100) * (18 - i + 1) / i;
            }
        }
        
        double sum = 0;
        for (int i = 0; i <= 18; i++) {
            for (int j = 0; j <= 18; j++) {
                if (!isPrime(i) && !isPrime(j)) {
                    sum += (dp[i][0] * dp[j][1]);
                }
            }
        }

        double answer = 1 - sum;
        System.out.println(answer);
    }
    
    private static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        
        boolean result = true;
        for (int j = 2; j < n; j++) {
            if (n % j == 0) {
                result = false;
                break;
            }
        }
        
        return result;
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Double.parseDouble(br.readLine());
        b = Double.parseDouble(br.readLine());
        
        br.close();
    }
}
