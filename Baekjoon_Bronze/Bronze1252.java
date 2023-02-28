import java.math.BigInteger;
import java.util.Scanner;
public class Bronze1252 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		BigInteger x = new BigInteger(a, 2);
		BigInteger y = new BigInteger(b, 2);
		BigInteger result = x.add(y);
		String str = result.toString(2);
		System.out.println(str);
		
	}

}
