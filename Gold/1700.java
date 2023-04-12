import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static long answer = 0;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> concent = new ArrayList<>();
    static int[] cnt;
    
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    
        cnt = new int[k+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int idx = Integer.parseInt(st.nextToken());
            list.add(idx);
            cnt[idx]++;
        }
        
        for (int i = 0; i < list.size(); i++) {
            int tool = list.get(i);
            cnt[tool]--;
            
            if (concent.contains(tool)) 
                continue;
                
            if (concent.size() < n) {
                concent.add(tool);
                continue;
            }
            
            boolean allUsed = true;
            for (int c : concent) {
                if (cnt[c] == 0) {
                    allUsed = false;
                    concent.remove(Integer.valueOf(c));
                    concent.add(tool);
                    answer++;
                    break;
                }
            }
            
            if (!allUsed) continue;
            
            List<Integer> order = new ArrayList<>();
            for (int j = i+1; j < k; j++) {
                int next = list.get(j);
                if (concent.contains(next) && !order.contains(next)) {
                    order.add(next);
                }
            }
            
            concent.remove(Integer.valueOf(order.get(order.size()-1)));
            concent.add(tool);
            answer++;
        }
        
        System.out.println(answer);
        br.close();
    }
}
