import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, min = Integer.MAX_VALUE;
    static int[][] arr;
    static int[][] rotations;
    static boolean[] selected;
    static int[] result;
    
    public static void main(String args[]) throws IOException {
        input();
        
        // permutation
        selectRotation(0);
        
        System.out.println(min);
    }
    
    private static void selectRotation(int cnt) {
        if (cnt >= k) {
            getMin();
            return;
        }
        
        for (int i = 0; i < k; i++) {
            if (selected[i]) continue;
            
            selected[i] = true;
            result[cnt] = i;
            selectRotation(cnt+1);
            selected[i] = false;
        }
    }
    
    private static void getMin() {
        int[][] copy = new int[n+1][m+1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        
        for (int i = 0; i < k; i++) {
            rotate(result[i], copy);
        }
        
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += copy[i][j];
            }
            min = Math.min(min, sum);
        }
    }
    
    private static void rotate(int r, int[][] copy) {
        int top = rotations[r][0]-1;
        int bottom = rotations[r][0]+1;
        int left = rotations[r][1]-1;
        int right = rotations[r][1]+1;
        
        while (top > 0 && bottom <= n && left > 0 && right <= m) {
            int temp = copy[top][left];
            for (int i = top; i < bottom; i++) {
                copy[i][left] = copy[i+1][left];
            }
            
            for (int i = left; i < right; i++) {
                copy[bottom][i] = copy[bottom][i+1];
            }
            
            for (int i = bottom; i > top; i--) {
                copy[i][right] = copy[i-1][right];
            }
            
            for (int i = right; i > left; i--) {
                copy[top][i] = copy[top][i-1];
            }
            
            copy[top][left+1] = temp;
            
            top -= 1;
            bottom += 1;
            left -= 1;
            right += 1;
            
            if (rotations[r][0] - top > rotations[r][2]) break;
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        rotations = new int[k][3];
        selected = new boolean[k];
        result = new int[k];
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rotations[i][0] = Integer.parseInt(st.nextToken());
            rotations[i][1] = Integer.parseInt(st.nextToken());
            rotations[i][2] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
}
