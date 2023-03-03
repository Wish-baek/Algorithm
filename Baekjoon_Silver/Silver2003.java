import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int aPoint = 0;
		int bPoint = 0;
		int sum = 0;

		int result = 0;

		while (true) {
			if (sum >= M) {
				sum -= arr[aPoint];
				aPoint++;
			} else if (bPoint >= N) {
				break;
			} else if (sum < M) {
				sum += arr[bPoint];
				bPoint++;
			}

			if (sum == M) {
				result++;
			}
		}
		System.out.println(result);
	}
}
//https://www.acmicpc.net/problem/2003