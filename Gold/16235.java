import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int[][] a;
    static int[][] ground;
    static Queue<Tree> trees = new LinkedList<>();
    static List<Tree> dies = new ArrayList<>();
    
    static int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};

    public static void main(String args[]) throws IOException {
        input();
        
        for (int i = 1; i <= k; i++) {
            dies = new ArrayList<>();
            spring();
            summer();
            fall();
            winter();
        }
        
        System.out.println(trees.size());
    }
    
    private static void spring() {
        int size = trees.size();
        
        for (int i = 0; i < size; i++) {
            Tree tree = trees.poll();
            
            if (ground[tree.x][tree.y] < tree.age) {
                dies.add(tree);
                continue;
            }
            
            ground[tree.x][tree.y] -= tree.age;
            tree.age += 1;
            trees.add(tree);
        }
    }
    
    private static void summer() {
        for (Tree tree: dies) {
            ground[tree.x][tree.y] += (tree.age / 2);
        }
    }
    
    private static void fall() {
        List<Tree> parents = new ArrayList<>();
        
        int size = trees.size();
        for (int i = 0; i < size; i++) {
            Tree tree = trees.poll();
            parents.add(tree);
            
            if (tree.age % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int nx = tree.x + dx[j];
                    int ny = tree.y + dy[j];
                    if (nx <= 0 || nx > n || ny <= 0 || ny > n) continue;
                    
                    trees.add(new Tree(nx, ny, 1));
                }
            }
        }
        
        trees.addAll(parents);
    }
    
    private static void winter() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ground[i][j] += a[i][j];
            }
        }
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        a = new int[n+1][n+1];
        ground = new int[n+1][n+1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ground[i][j] = 5;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            trees.add(new Tree(x, y, z));
        }
        
        Collections.sort((List<Tree>) trees);
        
        br.close();
    }
    
    static class Tree implements Comparable<Tree> {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
        
        @Override
        public int compareTo(Tree t) {
            return this.age - t.age;
        }
    }
}
