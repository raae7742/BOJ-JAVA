import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int arr_a[] = new int[n];
        Integer arr_b[] = new Integer[n];

        int result = 0;

        for(int i=0; i<n; i++){
            int a = s.nextInt();
            arr_a[i] = a;
        }

        Arrays.sort(arr_a);

        for(int i=0; i<n; i++){
            int b = s.nextInt();
            arr_b[i] = b;
        }

        Arrays.sort(arr_b, Collections.reverseOrder());

        for(int i=0; i<n; i++){
            result += (arr_a[i] * arr_b[i]);
        }
        System.out.print(result);
    }
}
