import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze15726 {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		
		double x = a/b*c;
		double y = a*b/c;
		

		System.out.println((int)(Math.max(x, y)));
	}

}