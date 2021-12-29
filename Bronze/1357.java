import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n1 = s.nextInt();
		int n2 = s.nextInt();
		
		n1 = reverseNum(n1);
		n2 = reverseNum(n2);
		int sum = n1 + n2;
		System.out.println(reverseNum(sum));
	}
	
	public static int reverseNum(int num) {
		int result = 0;
		String s_num = String.valueOf(num);
		for(int i=s_num.length(); i>=0; i--) {
			int n = (int) ((int)(num/Math.pow(10, i)) * Math.pow(10, s_num.length()-1-i));
			num = (int) (num % Math.pow(10, i));
			result += n;
		}
		
		return result;
	}

}
