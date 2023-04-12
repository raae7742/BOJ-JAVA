import java.util.*;
import java.io.*;

public class Main {
    static int n, answer = 0;
    static List<Integer> primes = new ArrayList<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        // 에라토스테네스의 체 -> N까지의 모든 소수 저장
        getPrime(n);
        
        // 투 포인터 알고리즘
        int left = 0, right = 0;
        int sum = 2;
        
        while (left < primes.size() && right < primes.size()) {
            if (sum == n) {
                answer++;
                sum -= primes.get(left);
                left++;
            }
            else if (sum > n) {
                sum -= primes.get(left);
                left++;
            }
            else {
                if (++right >= primes.size()) break;
                sum += primes.get(right);
            }
        }
        
        System.out.println(answer);
        br.close();
    }
    
    private static void getPrime(int n) {
        boolean[] isPrime = new boolean[n+1];
        
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i*2; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes.add(i);
        }
    }
}
