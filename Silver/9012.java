import java.io.*;
import java.util.*;

public class Main {
    static int t;
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      t = Integer.parseInt(br.readLine());
      
      for (int i = 0; i < t; i++) {
          String str = br.readLine();
          
          boolean isVPS = true;
          int cnt = 0;
          
          for (int j = 0; j < str.length(); j++) {
              char c = str.charAt(j);
              
              if (c == '(') {
                  cnt += 1;
                  continue;
              }
              
              if (--cnt < 0) {
                  isVPS = false;
                  break;
              }
          }
          
          if (cnt != 0) isVPS = false;
          
          if (isVPS) {
              System.out.println("YES");
          }
          else {
              System.out.println("NO");
          }
      }
    }
}
