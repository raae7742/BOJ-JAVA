import java.util.*;
import java.io.*;

public class Main {
    static int n, answer = Integer.MAX_VALUE;
    static int[][] abilities;
    static boolean[] selected;
    
    
    public static void main(String args[]) throws IOException {
        input();
        
        selected = new boolean[n];
        findTeamMember(0, 0);
        
        System.out.println(answer);
    }
    
    private static void findTeamMember(int cur, int size) {
        if (size == n/2) {
            int sumA = 0, sumB = 0;
            
            // 스타트 팀과 링크팀의 합을 구하고
            List<Integer> teamA = new ArrayList<>();
            List<Integer> teamB = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (selected[i]) {
                    teamA.add(i);
                } else {
                    teamB.add(i);
                }
            }
            
            for (int i = 0; i < teamA.size(); i++) {
                int playerA = teamA.get(i);
                for (int j = i+1; j < teamA.size(); j++) {
                    int otherA = teamA.get(j);
                    sumA += abilities[playerA][otherA] + abilities[otherA][playerA];
                }
            }
            
            for (int i = 0; i < teamB.size(); i++) {
                int playerB = teamB.get(i);
                for (int j = i+1; j < teamB.size(); j++) {
                    int otherB = teamB.get(j);
                    sumB += abilities[playerB][otherB] + abilities[otherB][playerB];
                }
            }
            
            // 차이값이 answer보다 작으면 저장
            answer = Math.min(answer, Math.abs(sumA - sumB));
            return;
        }
        
        for (int i = cur; i < n; i++) {
            selected[i] = true;
            findTeamMember(i+1, size+1);
            selected[i] = false;
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        abilities = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                abilities[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        br.close();
    }
}
