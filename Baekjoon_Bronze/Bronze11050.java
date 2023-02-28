import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze11050 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		System.out.println(fibonacci(N)/(fibonacci(N-M)*fibonacci(M)));

	}

	static int fibonacci(int n) {
		if (n <=1)
			return 1;
		return n*fibonacci(n - 1);
	}

}
//https://www.acmicpc.net/problem/11050