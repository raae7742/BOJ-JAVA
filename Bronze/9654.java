import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String[] arr_name = {"SHIP NAME", "N2 Bomber", "J-Type 327", "NX Cruiser", "N1 Starfighter", "Royal Cruiser"};
		String[] arr_class = {"CLASS", "Heavy Fighter", "Light Combat", "Medium Fighter", "Medium Fighter", "Light Combat"};
		String[] arr_deploy = {"DEPLOYMENT", "Limited", "Unlimited", "Limited", "Unlimited", "Limited"};
		String[] arr_service = {"IN SERVICE", "21", "1", "18", "25", "4"};
		
		for(int i=0; i<6; i++){
			System.out.printf("%-14s %-14s %-10s %-10s", arr_name[i], arr_class[i], arr_deploy[i], arr_service[i]);
			if(i != 5) System.out.printf("\n");
		}
	}
}
