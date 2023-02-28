import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Silver10826 {
	static BigInteger[] f;

	static BigInteger fibo(int n) {
		f[0] = BigInteger.valueOf(1);
		f[1] = BigInteger.valueOf(1);

		for (int i = 2; i < n; i++) {

			f[i] = f[i - 2].add(f[i - 1]);
		}
		return f[n - 1];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		f = new BigInteger[N];
		if(N==0) System.out.println(0);
		else System.out.println(fibo(N));
		
		
	}

}
//https://www.acmicpc.net/problem/10826