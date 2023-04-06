import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] paper;
    static int answer = 0;

    public static void main(String args[]) throws IOException{
        input();
        
        for (int s = 0; s < (1 << (n*m)); s++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int temp = 0;
                for (int j = 0; j < m; j++) {
                    int k = i*m + j;
                    if ((s & (1 << k)) == 0) {
                        temp *= 10;
                        temp += paper[i][j];
                    } else {
                        sum += temp;
                        temp = 0;
                    }
                }
                sum += temp;
            }
                
            for (int j = 0; j < m; j++) {
                int temp = 0;
                for (int i = 0; i < n; i++) {
                    int k = i*m + j;
                    if ((s & (1 << k)) != 0) {
                        temp *= 10;
                        temp += paper[i][j];
                    } else {
                        sum += temp;
                        temp = 0;
                    }
                }
                sum += temp;
            }
            
            answer = Math.max(answer, sum);
        }
        
        System.out.println(answer);
    }
    
    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                paper[i][j] = input.charAt(j) - '0';
            }
        }
        
        br.close();
    }
}
