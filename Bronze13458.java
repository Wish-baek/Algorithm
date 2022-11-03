import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze13458 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

		int B = Integer.parseInt(st2.nextToken());
		int C = Integer.parseInt(st2.nextToken());

		long result = 0;

		for (int i = 0; i < N; i++) {
			long n = Long.parseLong(st.nextToken());
			if (n <= B) {
				result++;
			} else {
				n -= B;
				result++;
				result += n / C;
				n %= C;
				if (n > 0)
					result++;
			}
		}

		System.out.println(result);
	}
}
//https://www.acmicpc.net/problem/13458