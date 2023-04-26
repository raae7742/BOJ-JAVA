import java.io.*;
import java.util.*;

public class Main {
    static int n, answer;
    static int[] arr;
    static int[] result;
    
    public static void main(String args[]) throws IOException {
        input();
        
        result = new int[n];
        result[0] = arr[0];
        answer = arr[0];
        for (int i = 1; i < n; i++) {
            result[i] = Math.max(arr[i], result[i-1] + arr[i]);
            answer = Math.max(answer, result[i]);
        }
        
        System.out.println(answer);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i =  0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
}
