import java.io.*;
import java.util.*;

public class Main {
    
    static int n, k, answer = 0;
    static String[] words;
    static boolean selected[] = new boolean[26];
    
    public static void main(String args[]) throws IOException {
        input();
        
        if (k < 5) {
            System.out.println(0);
            return;
        }
        else if (k == 26) {
            System.out.println(n);
            return;
        }
        selected['a'-'a'] = true;
        selected['n'-'a'] = true;
        selected['t'-'a'] = true;
        selected['i'-'a'] = true;
        selected['c'-'a'] = true;
        // 26개 소문자 중 k개를 선택한다.
        selectAlphabets(5, 0);
        
        System.out.println(answer);
    }
    
    private static void selectAlphabets(int cnt, int cur) {
        if (cnt >= k) {
            int result = checkReadableWords();
            answer = Math.max(answer, result);
            return;
        }
        if (cur >= 26) return;
        
        if (!selected[cur]) {
            selected[cur] = true;
            selectAlphabets(cnt+1, cur+1);
            selected[cur] = false;
        }
        selectAlphabets(cnt, cur+1);
    }
    
    private static int checkReadableWords() {
        int result = 0;
        for (String word : words) {
            boolean canRead = true;
            for (int i = 0; i < word.length(); i++) {
                if (!selected[word.charAt(i) - 'a']) {
                    canRead = false;
                    break;
                }
            }
            
            if (canRead) result++;
        }
        
        return result;
    }
    
    private static void input() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      
      words = new String[n];
      for (int i = 0; i < n; i++) {
          words[i] = br.readLine();
      }

      br.close();
    }
}
