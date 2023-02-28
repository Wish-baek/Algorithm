import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze15829 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		
		
		long sum = 0;
		for(int i = 0; i < N; i++) {
			long n = arr[i]-96;
			long tmp = n%1234567891;
			for (int j=1; j<=i; j++)
			{
				tmp *= 31;
				tmp %= 1234567891;
			}
			sum= ((sum%1234567891)+(tmp%1234567891))%1234567891;
		}
		System.out.println(sum);
	}
}
//https://www.acmicpc.net/problem/15829