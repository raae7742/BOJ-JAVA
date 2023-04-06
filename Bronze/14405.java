import java.util.*;
import java.io.*;

public class Main {
    static String s;

    public static void main(String args[]) throws IOException{
        input();
        
        List<String> list = new ArrayList<>();
        list.add("pi");
        list.add("ka");
        list.add("chu");
        
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            str += s.charAt(i);
            if (str.length() == 1) continue;
            if (str.length() <= 3) {
                if (list.contains(str)) str = "";
                else if (str.length() == 3) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        
        if (str.length() != 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
    
    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        br.close();
    }
}
