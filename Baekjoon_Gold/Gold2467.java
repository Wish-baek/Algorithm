import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold2467 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] arr = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		int aP = 0;
		int bP = N - 1;

		long min = Long.MAX_VALUE;
		long a = 0;
		long b = 0;

		while (aP < bP) {
			long sum = arr[aP] + arr[bP];
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				a = arr[aP];
				b = arr[bP];
			}
			if (sum >= 0)
				bP--;
			else
				aP++;
		}
		System.out.println(a + " " + b);
	}
}
// https://www.acmicpc.net/problem/2467 