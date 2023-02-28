import java.util.Scanner;
import java.math.*;
public class Bronze2720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			
			double n = sc.nextDouble();
			
			
			System.out.print((int)n/25 + " ");
			n%=25;
			System.out.print((int)n/10 + " ");
			n%=10;
			System.out.print((int)n/5 + " ");
			n%=5;
			System.out.print((int)n/1 + " ");
			n%=1;
			System.out.println();
		}
		
	}

}
