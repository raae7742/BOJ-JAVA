import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Line[] lines;

    public static void main(String args[]) throws IOException {
        input();
        
        Arrays.sort(lines);
        
        int answer = 0;
        int cur = lines[0].x;
        for (Line line : lines) {
            if (cur >= line.y) continue;
            if (cur < line.x) cur = line.x;
            answer += (Math.abs(line.y - cur));
            cur = line.y;
        }
        
        System.out.println(answer);
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lines = new Line[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines[i] = new Line(x, y);
        }
    }
    
    static class Line implements Comparable<Line> {
        int x;
        int y;
        
        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Line l) {
            if (this.x == l.x) return l.y - this.y;
            return this.x - l.x;
        }
    }
}
