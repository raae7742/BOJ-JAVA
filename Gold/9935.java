import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bomb = br.readLine();
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            answer.append(input.charAt(i));
            
            if (input.charAt(i) == bomb.charAt(bomb.length()-1)) {
                boolean isBomb = true;

                for (int j = 1; j < bomb.length(); j++) {
                    if (answer.length()-1-j < 0 || 
                        answer.charAt(answer.length()-1-j) != bomb.charAt(bomb.length()-1-j)) {
                        isBomb = false;
                        break;
                    }
                }
                
                if (isBomb) answer.delete(answer.length() - bomb.length(), answer.length());
            }
        }
        
        if (answer.length() == 0) 
            System.out.println("FRULA");
        else
            System.out.println(answer);
    
        br.close();
    }
}
