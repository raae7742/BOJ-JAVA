import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		
		int month = now.get(Calendar.MONTH) + 1;
		String s_month = "";
		if(month < 10) s_month = "0" + String.valueOf(month);
		else s_month = String.valueOf(month);
		
		int day = now.get(Calendar.DAY_OF_MONTH);
		String s_day = "";
		if(day < 10) s_day = "0" + String.valueOf(day);
		else s_day = String.valueOf(day);		
		
		System.out.print(year + "-" + s_month +  "-" + s_day);
	}
}
