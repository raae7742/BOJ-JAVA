import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int player = s.nextInt();
		int[][] arr = new int[player][3];
		int[] score = new int[player];
		boolean isFail;
		
		for(int i=0; i<player; i++)
			for(int j=0; j<3; j++)
				arr[i][j] = s.nextInt();
		
		
		for(int i=0; i<player; i++)
			for(int j=0; j<3; j++) {
				isFail = false;
				for(int n=0; n<player; n++)
						if(i == n) continue;
						else if(arr[i][j] == arr[n][j]) {
							arr[n][j] = 0;
							isFail = true;
						}
				if(isFail) arr[i][j] = 0;
				else score[i] += arr[i][j];
				
			}
		
		for(int i=0; i<player; i++)
			System.out.println(score[i] + "");
	}

}
