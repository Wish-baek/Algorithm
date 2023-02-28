import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver8979 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());

		int[][] arr = new int[N][4];

		int gold = -1;
		int silver = -1;
		int bronze = -1;

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());

			}
			if (arr[i][0] == K) {
				gold = arr[i][1];
				silver = arr[i][2];
				bronze = arr[i][3];

			}
		}

		for (int i = 0; i < N; i++) {
			if (arr[i][1] > gold)
				cnt++;
			else if (arr[i][1] == gold && arr[i][2] > silver)
				cnt++;
			else if (arr[i][1] == gold && arr[i][2] == silver && arr[i][3] > bronze)
				cnt++;

		}
		System.out.println(cnt + 1);
	}

}
