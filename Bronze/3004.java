import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int result = 0;
		for(int i=1; i<n+1; i++) {
			if(i==1) result = 2;
			else
				result += (i/2)+1;
		}
		System.out.print(result);
		s.close();
	}
}
