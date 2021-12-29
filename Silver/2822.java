import java.util.*;
public class Main {

	public static void main(String[] args) {
		int [] score = new int [8];
		int sum=0;
		Scanner s = new Scanner(System.in);
		
		for(int i=0; i<8; i++) {
			score[i] = s.nextInt();
		}
		
		
		int max = 0;
		ArrayList<Integer> index = new ArrayList<Integer>();
		for(int j=0; j<5; j++) {
			for(int i=0; i<8; i++) {
				if(score[max] < score[i]) max = i;
			}
			index.add(max);
			sum+=score[max];
			score[max] = -1;
		}

		System.out.println(sum);
		Collections.sort(index);
		
		for(int i=0; i<5; i++) {
			System.out.print((index.get(i)+1) + ((i==5) ? "\n" :" " ));
		}	
	}
}
