import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      int[] arr = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(st.nextToken());
      }
      
      int[] nge = new int[n];
      Stack<Integer> s = new Stack();
      
      for (int i = 0; i < n; i++) {
          while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
              nge[s.peek()] = arr[i];
              s.pop();
          }
          
          s.push(i);
      }
      
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
          if (nge[i] == 0) sb.append("-1" + " ");
          else sb.append(nge[i] + " ");
      }
      
      System.out.println(sb);
    }
}
