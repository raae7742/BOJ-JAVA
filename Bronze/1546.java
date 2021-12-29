import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		double [] arr = new double [num];
		double max_num = 0;
		
		for(int i = 0; i < num; i++) {
			arr[i] = scanner.nextDouble();
			if (max_num < arr[i]) max_num = arr[i];
		}
		
		double sum = 0;
		for(int i = 0; i < num; i++) {
			arr[i] = arr[i] / max_num * 100;
			sum += arr[i];
		}
		
		System.out.print(sum / num);
		
		scanner.close();
	}
}
