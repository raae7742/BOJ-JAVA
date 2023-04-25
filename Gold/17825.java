import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    static int[] nums = new int[10];
    static int[] order = new int[10];
    static Node[] board = new Node[43];

    public static void main(String args[]) throws IOException {
        input();
        setBoard();
        
        selectHorse(0);
        
        System.out.println(answer);
    }
    
    private static void selectHorse(int idx) {
        if (idx >= 10) {
            move();
            return;
        }
        
        for (int i = 1; i <= 4; i++) {
            order[idx] = i;
            selectHorse(idx+1);
        }
    }
    
    private static void move() {
        int score = 0;
        int[] horse = new int[5];           // 1 ~ 4
        
        for (int i = 0 ; i < 10; i++) {
            int h = order[i];
            int num = nums[i];
            
            if (board[horse[h]].blue != -1) {
                horse[h] = board[horse[h]].blue;
                num--;
            }
            
            for (int j = 1; j <= num; j++) {
                horse[h] = board[horse[h]].red;
            }
            
            if (horse[h] <= 40) {
                for (int j = 1; j <= 4; j++) {
                    if (h == j) continue;
                    if (horse[h] == horse[j]) return;
                }
            }
            

            score += board[horse[h]].score;
        }
        
        answer = Math.max(answer, score);
        
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < 10; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
    
    private static void setBoard() {
        for (int i = 0; i <= 40; i += 2) {
            board[i] = new Node(i, i+2);
        }

        board[10].blue = 11;
        board[20].blue = 17;
        board[30].blue = 31;

        board[11] = new Node(13, 13);
        board[13] = new Node(16, 15);
        board[15] = new Node(19, 25);
        board[17] = new Node(22, 19);
        board[19] = new Node(24, 25);
        board[25] = new Node(25, 37);
        board[31] = new Node(28, 33);
        board[33] = new Node(27, 35);
        board[35] = new Node(26, 25);
        board[37] = new Node(30, 39);
        board[39] = new Node(35, 40);
        board[42] = new Node(0, 42);
    }
    
    static class Node {
        int score;
        int red;
        int blue;
        
        public Node(int s, int r) {
            this.score = s;
            this.red = r;
            this.blue = -1;
        }
    }
}
