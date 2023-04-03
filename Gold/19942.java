import java.util.*;
import java.io.*;

public class Main {
    static class Food{
        int protein;
        int fat;
        int carbo;
        int vita;
        int price;
        
        public Food(int protein, int fat, int carbo, int vita, int price) {
            this.protein = protein;
            this.fat = fat;
            this.carbo = carbo;
            this.vita = vita;
            this.price = price;
        }
    }
    
    static int n, mp, mf, ms, mv, answer = Integer.MAX_VALUE;
    static List<Food> foods = new ArrayList<>();
    static List<String> indexs = new ArrayList<>();
    static int[] select;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            foods.add(new Food(p, f, c, v, price));
        }
        
        for (int i = 1; i <= n; i++) {
            select = new int[n];
            findAnswer(i, 0, 0);
        }
        
        if (indexs.size() > 0) {
            System.out.println(answer);
            Collections.sort(indexs);
            System.out.println(indexs.get(0));
        } else {
            System.out.println(-1);
        }
    }
    
    private static void findAnswer(int total, int current, int start) {
        if (current == total) {
            checkAnswer(current);
            return;
        }
        
        for (int i = start; i < n; i++) {
            select[current] = i;
            findAnswer(total, current+1, i+1);
        }
    }
    
    public static void checkAnswer(int idx) {
        int price = 0;
        int sp = 0, sf = 0, sc= 0, sv = 0, sprice = 0;
        
        for (int i = 0; i < idx; i++) {
            Food food = foods.get(select[i]);
            sp += food.protein;
            sf += food.fat;
            sc += food.carbo;
            sv += food.vita;
            sprice += food.price;
        }
        
        if (sp < mp || sf < mf || sc < ms || sv < mv) return;
        
        if (answer >= sprice) {
            if (answer > sprice) {
                answer = sprice;
                indexs.clear();
            }
            
            String str = "";
            for (int i = 0; i < idx; i++) {
                str += (select[i] + 1 + " ");
            }
            indexs.add(str);
        }
    }
}
