import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold16938 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;

		for (int i = 0; i < (1 << N); i++) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int sum = 0;
			int cnt = 0;

			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					cnt++;
					min = Math.min(min, arr[j]);
					max = Math.max(max, arr[j]);
					sum += arr[j];
				}
			}

			if (cnt >= 2 && L <= sum && sum <= R && (max - min) >= X)
				result++;
		}
		System.out.println(result);
	}
}

//https://www.acmicpc.net/problem/16938