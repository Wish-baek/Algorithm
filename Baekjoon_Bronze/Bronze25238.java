import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;
import java.io.*;
import java.lang.Integer;
public class Bronze25238 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		if(a==0)System.out.println(1);
		else if(a/100*(100-b)>=100) System.out.println("0");
		else System.out.println("1");
		
	}
	
}
