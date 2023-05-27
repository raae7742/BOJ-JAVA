import java.io.*;
import java.util.*;

public class Main {
    static int n, b, c;
    static long answer = 0;
    static int[] rooms;
    
    public static void main(String args[]) throws IOException {
        input();    
        
        // b 때려넣기
        for (int i = 0; i < n; i++) {
            answer += 1;
            rooms[i] -= b;
        }
        
        for (int i = 0; i < n; i++) {
            if (rooms[i] <= 0) continue;
            
            answer += (rooms[i] / c);
            if (rooms[i] % c != 0) answer += 1;
        }
        
        System.out.println(answer);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rooms = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            rooms[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        br.close();
    }
}
