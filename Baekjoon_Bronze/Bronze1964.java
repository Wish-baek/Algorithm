import java.util.Scanner;
import java.math.BigInteger;
public class Bronze1964 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger n = sc.nextBigInteger();
		BigInteger sum = BigInteger.valueOf(0);
		
		BigInteger tmp = n.add(BigInteger.valueOf(1));
		
		sum = sum.add(tmp.multiply(tmp));
		BigInteger i = BigInteger.valueOf(1);
		while(true) {
			sum = sum.add(i);
			if(i.compareTo(n)==0) break;
			i = i.add(BigInteger.valueOf(1));
			
		}
		System.out.println(sum.remainder(BigInteger.valueOf(45678)));
	}

}
