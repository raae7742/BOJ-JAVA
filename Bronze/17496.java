import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int t = s.nextInt();
		int c = s.nextInt();
		int p = s.nextInt();
		
		int result = (n-1) / t * c * p;
		System.out.print(result);
	}
}
