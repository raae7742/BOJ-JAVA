import java.util.*;
import java.io.*;

public class Main {
    static int n, answer = 0;
    static List<Photo> photos = new ArrayList<>();
    static int[] cnt = new int[101];
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        int r = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < r; i++) {
            int idx = Integer.parseInt(st.nextToken());
            
            if (cnt[idx] > 0) {
                cnt[idx] += 1;
                continue;
            }
            
            if (photos.size() >= n) {
                Collections.sort(photos);
                cnt[photos.get(0).idx] = 0;
                photos.remove(0);
            }

            cnt[idx] = 1;
            photos.add(new Photo(idx));
            continue;
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < photos.size(); i++) {
            answer.add(photos.get(i).idx);
        }
        
        Collections.sort(answer);
        
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
        
        br.close();
    }
    
    static class Photo implements Comparable<Photo> {
        int idx;
        int seq;
        static int time = 0;
        
        public Photo(int idx) {
            this.idx = idx;
            this.seq = time++;
        }
        
        @Override
        public int compareTo(Photo other) {
            if (cnt[this.idx] == cnt[other.idx]) return this.seq - other.seq;
            return cnt[this.idx] - cnt[other.idx];
        }
    }
}
