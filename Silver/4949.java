import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            
            boolean isBalance = true;
            Stack<Character> st = new Stack<>();
            
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                
                if (c == '(' || c == '[') {
                    st.push(c);
                    continue;
                }
                
                if (c == ')') {
                    if (st.isEmpty()) {
                        isBalance = false;
                        break;
                    }
                    
                    if (st.peek() != '(') {
                        isBalance = false;
                        break;
                    }
                    
                    st.pop();
                    continue;
                }
                
                if (c == ']') {
                    if (st.isEmpty()) {
                        isBalance = false;
                        break;
                    }
                    
                    if (st.peek() != '[') {
                        isBalance = false;
                        break;
                    }
                    
                    st.pop();
                    continue;
                }
            }
            
            if (!st.isEmpty()) isBalance = false;
            
            String answer = isBalance ? "yes" : "no";
            System.out.println(answer);
        }
        
        br.close();
    }
}
