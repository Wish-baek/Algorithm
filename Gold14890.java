import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold14890 {
	static int[][] map, map2;
	static int N, L, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		map2 = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				map2[j][i] = n;
			}
		}

		for (int i = 0; i < N; i++) {
			isPossible(map, i);
			isPossible(map2, i);
		}

		System.out.println(result);

	}

	static void isPossible(int[][] map, int r) {
		int h = map[r][0];
		int totalCnt = 1;
		for (int i = 1; i < N; i++) {
			if (map[r][i] == h)
				totalCnt++;
			else if (map[r][i] - h == 1) {
				if (totalCnt < L)
					return;
				else {
					totalCnt = 1;
					h = map[r][i];
				}
			} else if (h - map[r][i] == 1) {
				if (N < i + L)
					return;
				for (int j = 1; j < L; j++) {
					if (h - map[r][++i] != 1)
						return;
				}
				totalCnt = 0;
				h = map[r][i];
			} else
				return;
		}

		result++;

	}
}