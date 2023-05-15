import java.util.*;
import java.io.*;

public class Main {
    
    static int n, c, answer = 0;
    static int[] weights;
    static List<Integer> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();
    
    public static void main(String args[]) throws IOException {
        input();
        
        findA(0, 0);
        findB(n/2, 0);
        
        Collections.sort(b);
        
        for (int i = 0; i < a.size(); i++) {
            int result = binarySearch(0, b.size()-1, a.get(i));
            answer += (result + 1);
        }
        
        System.out.println(answer);
    }
    
    private static void findA(int idx, int sum) {
        if (idx == (n / 2)) {
            a.add(sum);
            return;
        }
        
        if (sum + weights[idx] <= c) 
            findA(idx+1, sum + weights[idx]);
        findA(idx+1, sum);
    }

    private static void findB(int idx, int sum) {
        if (idx == n) {
            b.add(sum);
            return;
        }
        
        if (sum + weights[idx] <= c) 
            findB(idx+1, sum + weights[idx]);
        findB(idx+1, sum);
    }

    private static int binarySearch(int l, int r, int sum) {
        int result = -1;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            if (b.get(mid) + sum <= c) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return result;
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        weights = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
}
