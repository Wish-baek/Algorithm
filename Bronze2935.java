import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;
public class Bronze2935 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		BigInteger x = sc.nextBigInteger();
		char a = sc.next().charAt(0);
		BigInteger y = sc.nextBigInteger();
		
		if(a=='+') System.out.println(x.add(y));
		else if(a=='*') System.out.println(x.multiply(y));
		
	}

}
