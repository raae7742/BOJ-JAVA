import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num = s.nextInt() - 1;
		String[] lyrics = {"baby", "sukhwan", "tururu", "turu", "very", "cute", "tururu", "turu", "in", "bed", "tururu", "turu", "baby", "sukhwan"};

		int index = num % 14;
		int count = num / 14;
		String result = lyrics[index];
		
		if(result.equals("tururu") && count >= 3)
				System.out.println("tu+ru*"+(count+2));
		else if(result.equals("turu") && count >= 4)
				System.out.println("tu+ru*"+(count+1));
		else if(result.equals("tururu") || result.equals("turu")){
			System.out.print(result);
			for(int i=0; i<count; i++)
				System.out.print("ru");
			System.out.print("\n");
		}
		else
			System.out.println(result);
	}
}
