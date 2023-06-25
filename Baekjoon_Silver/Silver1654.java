import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		long[] arr = new long[K];
		long max = -1;

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		long min = 1;
		long half = 0;

		while (true) {
			half = (min + max) / 2;
			long count = 0;

			for (int i = 0; i < K; i++) {
				count += arr[i] / half;
			}

			if (count < N) {
				max = half - 1;
			} else {
				min = half + 1;
			}
			if (max < min)
				break;
		}
		System.out.println((max + min) / 2);
	}
}
//https://www.acmicpc.net/problem/1654