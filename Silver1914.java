import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Silver1914 {
	static int cnt = 0;
	public static void hanoi(int from, int m, int to, int num){
		if(num==0) return;
		hanoi(from, to, m, num-1);
		System.out.println(from + " " + to);
		cnt++;
		hanoi(m, from, to, num-1);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger tmp = BigInteger.valueOf(1);
		BigInteger two = BigInteger.valueOf(2);
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			tmp = tmp.multiply(two);
		}
		System.out.println(tmp.subtract(BigInteger.valueOf(1)));
		if(n<=20) hanoi(1, 2, 3, n);
		
		
	}

}
//https://www.acmicpc.net/problem/1914