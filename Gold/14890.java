import java.util.*;
import java.io.*;

public class Main {
    static int n, l, answer = 0;
    static int[][] map;
    
    public static void main(String args[]) throws IOException {
        input();
        
        // 행 탐색
        for (int i = 0; i < n; i++) {
            int height = map[i][0];
            int len = 1;
            
            int j = 1;
            // 왼 -> 오
            while (j <= n) {
                if (j == n) {
                    answer++;
                    break;
                }
                
                if (height == map[i][j]) {
                    len++;
                    j++;
                    continue;
                }
                
                if (height - 1 == map[i][j]) {
                    int nextLen = 1;
                    int nextJ = j+1;
                    while (true) {
                        if (nextJ >= n) break;
                        if (map[i][j] != map[i][nextJ]) break;
                        
                        nextLen++;
                        nextJ++;
                    }
                    
                    if (nextLen < l) break;
                    height = map[i][j];
                    len = nextLen - l;
                    j = nextJ;
                    continue;
                }
                
                if (height + 1 == map[i][j]) {
                    if (len < l) break;
                    height = map[i][j];
                    len = 1;
                    j += 1;
                    continue;
                }
                
                break;
            }
        }
        
        // 열 탐색
        for (int i = 0; i < n; i++) {
            int height = map[0][i];
            int len = 1;
            int j = 1;
            
            // 위 -> 아래
            while (j <= n) {
                if (j == n) {
                    answer++;
                    break;
                }
                
                if (height == map[j][i]) {
                    len++;
                    j++;
                    continue;
                }
                
                if (height - 1 == map[j][i]) {
                    int nextLen = 1;
                    int nextJ = j+1;
                    while (true) {
                        if (nextJ >= n) break;
                        if (map[j][i] != map[nextJ][i]) break;
                        
                        nextLen++;
                        nextJ++;
                    }
                    
                    if (nextLen < l) break;
                    height = map[j][i];
                    len = nextLen - l;
                    j = nextJ;
                    continue;
                }
                
                if (height + 1 == map[j][i]) {
                    if (len < l) break;
                    height = map[j][i];
                    len = 1;
                    j += 1;
                    continue;
                }
                
                break;
            }
        }
        
        System.out.println(answer);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        br.close();
    }
}
