import java.util.*;
import java.util.Scanner;

public class Bronze5361 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		double a = 350.34;
		double b = 230.90;
		double c = 190.55;
		double d = 125.30;
		double e = 180.90;
		for(int i = 0; i < k; i++) {
			double sum = 0;
			sum += sc.nextDouble() * a;
			sum += sc.nextDouble() * b;
			sum += sc.nextDouble() * c;
			sum += sc.nextDouble() * d;
			sum += sc.nextDouble() * e;
			
			System.out.printf("$%.2f\n", sum);
		}
	}
}


