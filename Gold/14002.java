import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static int[] arr;
    
    public static void main(String args[]) throws IOException {
        input();
        
        int[] idx = new int[n+1];
        for (int i = 0; i <= n; i++) {
            idx[i] = -1;
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(arr[1]);
        idx[1] = 0;
        
        for (int i = 2; i <= n; i++) {
            if (list.get(list.size() - 1) < arr[i]) {
                list.add(arr[i]);
                idx[i] = list.size() - 1;
                continue;
            }
            
            int left = 0, right = list.size() - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                
                if (list.get(mid) >= arr[i]) {
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            
            list.set(right, arr[i]);
            idx[i] = right;
        }
        
        System.out.println(list.size());
        
        Stack<Integer> st = new Stack<>();
        int cur = list.size()-1;
        for (int i = n; i >= 1; i--) {
            if (idx[i] == cur) {
                st.push(arr[i]);
                cur -= 1;
                
                if (cur < 0) break;
            }
        }
        
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
}
