import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		
		String input = s.next();
		char start = input.charAt(0);
		char swap;
		int count = 0;
		
		if (start == '0') swap = '1';
		else swap = '0';
		
		for(int i=0; i<input.length()-1; i++){
			if(input.charAt(i) == swap && input.charAt(i+1) == start)
				count++;
		}
		
		if (input.charAt(input.length() - 1) == swap)
			count++;
			
		System.out.print(count);
	}
}
