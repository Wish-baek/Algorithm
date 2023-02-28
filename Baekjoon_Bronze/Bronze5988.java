import java.util.Scanner;
import java.math.BigInteger;

public class Bronze5988 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		BigInteger zero = BigInteger.valueOf(0);
		BigInteger one = BigInteger.valueOf(1);
		BigInteger two = BigInteger.valueOf(2);
		for(int i = 0; i < n; i++) {
			BigInteger a = sc.nextBigInteger();
			
			if(a.remainder(two).compareTo(one)==0) System.out.println("odd");
			else if(a.remainder(two).compareTo(zero)==0) System.out.println("even");
		}
		
	}

}
