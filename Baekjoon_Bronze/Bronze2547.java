import java.util.Scanner;
import java.math.*;
public class Bronze2547 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++) {
			
			int n = sc.nextInt();
			BigInteger zero = BigInteger.valueOf(0);
			BigInteger sum = zero;
			for(int j = 0; j < n; j++) {
				sum = sum.add(sc.nextBigInteger());
			}
			
		
			if(sum.remainder(BigInteger.valueOf(n))==zero) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}

}
