import java.util.*;
import java.io.*;

public class Main {
    static int[] input = new int[1024];
    static int[] tree = new int[1024];

    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      int size = (int)Math.pow(2, k)-1;

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < size; i++) {
          input[i] = Integer.parseInt(st.nextToken());
      }
      
      tree[1] = input[size / 2];
      inOrder(1, 0, size/2 - 1, true);
      inOrder(1, size/2 + 1, size - 1, false);
      
      int level = 0;
      int cnt = 0;
      for (int i = 1; i < size+1; i++) {
          System.out.print(tree[i] + " ");
          cnt++;
          if (cnt == Math.pow(2, level)) {
              System.out.println();
              level += 1;
              cnt = 0;
          }
      }
      br.close();
    }
    
    private static void inOrder(int parent, int start, int end, boolean isLeft) {
        int mid = (start+end)/2;
        int node = input[mid];
        int idx = (isLeft) ? 2*parent : 2*parent+1;
        tree[idx] = node;
        
        if (start >= end) return;
        
        inOrder(idx, start, mid-1, true);
        inOrder(idx, mid+1, end, false);
    }
}
