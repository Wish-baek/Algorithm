import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver1205 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		if(N==0) {
			System.out.println(1);
			return;
		}
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		Arrays.fill(arr, 0);
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = -1;
		
		if (score <= arr[N - 1] && N == P) {
			System.out.println(-1);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (score >= arr[i]) {
				System.out.println(i+1);
				return;
			}
		}
		System.out.println(N+1);
	}
}
