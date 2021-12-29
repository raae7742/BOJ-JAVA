import java.util.Scanner;
import java.util.Vector;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int count = 0;
		int n = s.nextInt();

		for(int i=0; i<n; i++) 
		{
			String word = s.next();
			boolean isGroup = true;
			Vector<Character> v = new Vector<>();
			for(int j=0; j<word.length(); j++)
			{
				if(v.contains(word.charAt(j)) && word.charAt(j-1) != word.charAt(j))
					isGroup = false;
				else
					v.add(word.charAt(j));
			}
			if(isGroup == true)
				count++;
		}
		
		System.out.println(count);
		s.close();
	}

}
