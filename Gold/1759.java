import java.util.*;
import java.io.*;

public class Main {
    static int l, c;
    static char[] alphabets;
    static StringBuilder sb = new StringBuilder();
    
    
    public static void main(String args[]) throws IOException {
      input();
      
      Arrays.sort(alphabets);
      
      dfs("", 0);
      
      System.out.println(sb.toString());
    }
    
    private static void dfs(String result, int start) {
        if (result.length() == l) {
            int consonant = 0, vowel = 0;
            
            for (int i = 0; i < l; i++) {
                char cur = result.charAt(i);
                boolean isVowel = cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u';
                
                if (isVowel) vowel++;
                else consonant++;
            }
            
            if (vowel >= 1 && consonant >= 2) 
                sb.append(result + "\n");
            return;
        }

        for (int i = start; i < c; i++) {
            dfs(result + alphabets[i], i+1);
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        alphabets = new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            alphabets[i] = st.nextToken().charAt(0);
        }
        
        br.close();
    }
}
