import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int max = Integer.MIN_VALUE;      
    static List<Character> ops = new ArrayList<>();
    static List<Integer> nums = new ArrayList<>();
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      String expr = br.readLine();
      for (int i = 0; i < n; i++) {
          if (i % 2 == 0) {
              nums.add(expr.charAt(i) - '0');
          }
          else {
              ops.add(expr.charAt(i));
          }
      }
      
      dfs(0, nums.get(0));
      System.out.println(max);
    }
    
    private static int calculate(int idx, int num1, int num2) {
        switch(ops.get(idx)) {
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
        }
        return num1;
    }
    
    private static void dfs(int idx, int sum) {
        if (idx >= ops.size()) {
            max = Math.max(max, sum);
            return;
        }
        
        // 괄호가 없을 때
        dfs(idx+1, calculate(idx, sum, nums.get(idx+1)));
        
        // 괄호가 있을 때
        if (idx+1 < ops.size()) {
            int temp = calculate(idx+1, nums.get(idx+1), nums.get(idx+2));
            dfs(idx+2, calculate(idx, sum, temp));
        }
    }
}
