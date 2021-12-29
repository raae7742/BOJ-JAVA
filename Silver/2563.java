import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int arr[][] = new int[100][100];
        int result=0;

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for(int i=0; i<100; i++)
            for(int j=0; j<100; j++)
                arr[i][j] = 0;

        for(int k=0; k<n; k++) {
            int w = s.nextInt();
            int h = s.nextInt();

            for(int i=0; i<10; i++)
                for(int j=0; j<10; j++)
                    arr[w+i][h+j] = 1;
        }

        for(int i=0; i<100; i++)
            for(int j=0; j<100; j++)
                if(arr[i][j] == 1)
                    result++;

        System.out.print(result);
    }
}
