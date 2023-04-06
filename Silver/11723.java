import java.util.*;
import java.io.*;

public class Main {
    static int m;
    static int s = 0;
    
    public static void main(String args[]) throws IOException{
        input();
        
        
    }
    
    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.compareTo("add") == 0) {
                int num = Integer.parseInt(st.nextToken());
                s = (s | 1 << num);
            } else if (command.compareTo("check") == 0) {
                int num = Integer.parseInt(st.nextToken());
                if ((s & 1 << num) == 0) 
                    sb.append("0\n");
                else  
                    sb.append("1\n");
            } else if (command.compareTo("remove") == 0) {
                int num = Integer.parseInt(st.nextToken());
                s = (s & ~(1 << num));
                
            } else if (command.compareTo("toggle") == 0) {
                int num = Integer.parseInt(st.nextToken());
                s = (s ^ (1 << num));
            } else if (command.compareTo("empty") == 0) {
                s = 0;
            } else if (command.compareTo("all") == 0) {
                s = s | (~0);
            }
        }
        
        System.out.println(sb.toString());
        br.close();
    }
}
