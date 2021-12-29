import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int count = 0;
		
		int _num = num;
		do {
			int i = (num/10) + (num%10);
			num = (num%10) * 10 + i%10;
			count++;
		}while(num != _num);
		
		System.out.print(count + "");
	}

}
