import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		for(int i=0; i<t; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			for(int j=0; j<10; j++) {
				arr.add(s.nextInt());
			}
			Collections.sort(arr);
			
			System.out.println(arr.get(7));	
		}
	}
}
