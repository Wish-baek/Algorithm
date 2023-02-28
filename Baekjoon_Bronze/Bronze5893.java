import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Bronze5893 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		BigInteger b = new BigInteger(str, 2).multiply(BigInteger.valueOf(17));
		System.out.println(b.toString(2));
		
		
	}

}
//https://www.acmicpc.net/problem/5893