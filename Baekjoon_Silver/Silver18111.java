import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver18111 {
	static int[][] map;
	static int total, max_height, min_time, result_height, N, M, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		total = B;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}

		max_height = total / (N * M);
		max_height = max_height > 256 ? 256 : max_height;
		min_time = Integer.MAX_VALUE;
		result_height = max_height;

		play();

		System.out.println(min_time + " " + result_height);

	}

	static void play() {
		for (int height = max_height; height >= 0; height--) {
			int time = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > height) {
						time += 2 * (map[i][j] - height);
					} else if (map[i][j] < height) {
						time += (height - map[i][j]);
					}
				}
			}
			if (time < min_time) {
				min_time = time;
				result_height = height;

			}
		}
	}
}
//https://www.acmicpc.net/problem/18111