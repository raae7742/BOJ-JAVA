import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int answer = Integer.MAX_VALUE;
    static char[][] coins;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        coins = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            
            for (int j = 0; j < n; j++) {
                coins[i][j] = str.charAt(j);
            }
        }
        
        for (int bit = 0; bit < (1<<n); bit++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int tail = 0;
                for (int j = 0; j < n; j++) {
                    char coin = coins[j][i];
                    if ((bit&(1<<j)) != 0) coin = change(coin);
                    if (coin == 'T') tail++;
                }
                sum += Math.min(tail, n-tail);
            }
            answer = Math.min(answer, sum);
        }
        
        System.out.println(answer);
    }
    
    static char change(char coin) {
        if (coin == 'T') return 'H';
        return 'T';
    }
}
