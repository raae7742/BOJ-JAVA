import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[5];

        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 5; i++)
            arr[i] = s.nextInt();

        for (int val = 1; val < 970201; val++){
            int cnt = 0;

            for (int i=0; i<arr.length; i++)
                if(val % arr[i] == 0) cnt++;

            if(cnt >= 3){
                System.out.print(val);
                break;
            }
        }
    }
}
