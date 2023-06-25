import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Gold1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = arr[0];
		int min = Integer.MAX_VALUE;

		int aP = 0;
		int bP = 0;
		int len = 1;

		while (true) {
			if (sum < S) {
				bP++;

				if (bP == N)
					break;
				len++;
				sum += arr[bP];
			} else if (sum >= S) {
				min = Math.min(min, len);
				sum -= arr[aP];
				len--;
				aP++;
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
}

//https://www.acmicpc.net/problem/1806