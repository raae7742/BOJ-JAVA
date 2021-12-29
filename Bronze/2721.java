import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int i=0; i<t; i++){
			int n = s.nextInt();
			int result = 0;
			
			for(int j=1; j<n+1; j++)
				result += j * (j+1) * (j+2) / 2;
			
			System.out.println(result);
		}
	}
}
