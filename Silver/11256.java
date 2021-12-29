import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		for(int i=0; i<t; i++) {
			int j = s.nextInt();
			int n = s.nextInt();
			int box[] = new int [n];
			
			for(int k=0; k<n; k++) {
				int x = s.nextInt();
				int y = s.nextInt();
				box[k] = x*y;
			}
			
			int sum = 0,count = 0;
			
			while(sum < j) {
				int indexMax = SeqSearch(box);
				sum += box[indexMax];
				box[indexMax] = 0;
				count++;
			}
			
			System.out.println(count);
		}
	}
	
	static int SeqSearch(int num[]) {
		int i,max = 0;
		for(i=0; i<num.length; i++)
			if (num[i] > num[max]) max = i;
		return max;
	}

}
