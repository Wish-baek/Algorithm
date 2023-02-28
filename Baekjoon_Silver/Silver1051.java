import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1051 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		int max = -1;

		int size = Math.min(M, N);

		for (int k = 0; k < size; k++) {
			for (int i = 0; i < N - k; i++) {
				for (int j = 0; j < M - k; j++) {
					if (arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j + k]) {
						System.out.println("i: " + i + " j: " + j + " arr[i][j]: " + arr[i][j] + " size: " +(k+1)*(k+1));
						max = Math.max(max,(k+1)*(k+1));
					}
					// System.out.print(arr[i][j] + " ");
				}
				// System.out.println();
			}
			// System.out.println();
		}

		System.out.println(max);

	}

}
