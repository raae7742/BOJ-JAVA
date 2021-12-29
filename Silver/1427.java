import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String n = s.next();
		int[] arr = new int[n.length()];
		for(int i=0; i<n.length(); i++)
			arr[i] = (int)(n.charAt(i)) - 48;
		
		BubbleSort(arr);
		
		for(int i=arr.length-1; i>=0; i--)
			System.out.print(arr[i]);
		
		
	}
	
	static void BubbleSort(int list[]) {
		int temp,flag =1;
		for (int i=list.length-1; flag>0; i--) {
			flag = 0;
			for(int j=0; j<i; j++) {
				if(list[j] > list[j+1]) {
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					flag=1;
				}
			}
		}
	}

}
