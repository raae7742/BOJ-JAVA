import java.util.*;
import java.io.*;

public class Main {
    static int n, x;
    static long answer = 0;
    static boolean[] nums = new boolean[1000001];
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            list.add(input);
            nums[input] = true;
        }
        
        x = Integer.parseInt(br.readLine());
        
        for (int num : list) {
            int other = x - num;
            if (other < 0 || other > 1000000) continue;
            if (nums[other]) answer++;
        }
        
        System.out.println(answer / 2);
        br.close();
    }
}
