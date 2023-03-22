import java.util.*;
import java.io.*;

public class Main {
    static long k;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited = new boolean[10];
    static char[] opers = new char[10];
    static List<String> answerList = new ArrayList<>();

    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      k = Integer.parseInt(br.readLine());
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < k; i++) {
          opers[i] = st.nextToken().charAt(0);
      }
      
      for (int i = 0; i < 10; i++) {
        visited[i] = true;
        dfs(i, Integer.toString(i), 0);
        visited[i] = false;
      }
      
      Collections.sort(answerList);
      
      System.out.println(answerList.get(answerList.size() - 1));
      System.out.println(answerList.get(0));
      br.close();
    }
    
    private static void dfs(long answerNum, String answer, int idx) {
        if (idx == k) {
            answerList.add(answer);
            return;
        }
        
        int num = (int)(answerNum % 10);
        char op = opers[idx];
        
        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            if (op == '>' && i >= num) continue;
            if (op == '<' && i <= num) continue;
            
            visited[i] = true;
            dfs(answerNum * 10 + i, answer + Integer.toString(i), idx+1);
            visited[i] = false;
        }
        
    }
}
