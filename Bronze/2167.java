import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int array[][] = new int[n][m];		

		for (int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				array[i][j] = s.nextInt();

		int k = s.nextInt();
						
		for (int i=0; i<k; i++) {
			int sum = 0;
			int indexs[] = new int[4];
			for (int j=0; j<4; j++)
				indexs[j] = s.nextInt() - 1;
			
			for(int x=indexs[0]; x <= indexs[2]; x++)
				for(int y=indexs[1]; y <= indexs[3]; y++)
					sum += array[x][y];

			System.out.println(sum);
		}
	}
}
