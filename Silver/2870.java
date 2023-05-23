import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<String> nums = new ArrayList<>();
    
    public static void main(String args[]) throws IOException {
        input();
        
        Collections.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    for (int i = 0; i < s1.length(); i++) {
                        if (s1.charAt(i) != s2.charAt(i))
                            return s1.charAt(i) - s2.charAt(i);
                    }
                    
                    return 0;
                }
                
                return s1.length() - s2.length();
            }
        });

        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String num = "";
            
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                
                if (c >= '0' && c <= '9') {
                    num = (num.equals("0")) ? "" + c : num + c;
                    continue;
                }
                
                if (!num.isBlank()) {
                    nums.add(num);
                    num = "";
                }
            }
            
            if (!num.isBlank()) nums.add(num);
        }
        
        br.close();
    }
}
