import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold14500 {
	static int N, M;
	static int[][] map;
	static int[][][] tetromino = {
			// 행,열
			{ { 0, 0, 0 }, { -1, -2, -3 } }, // 첫 번째 모양

			{ { 0, 0, 0 }, { 1, 2, 3, } },

			{ { -1, -2, -3 }, { 0, 0, 0 } },

			{ { 1, 2, 3 }, { 0, 0, 0 } },

			{ { 0, 1, 1 }, { 1, 1, 0 } }, // 두 번째 모양

			{ { 0, 1, 1 }, { -1, -1, 0 } },

			{ { -1, -1, 0 }, { 0, 1, 1 } },

			{ { -1, -1, 0 }, { 0, -1, -1 } },

			{ { 1, 2, 2 }, { 0, 0, 1 } }, // 세 번째 모양

			{ { 1, 2, 2 }, { 0, 0, -1 } },

			{ { -1, -2, -2 }, { 0, 0, 1 } },

			{ { -1, -2, -2 }, { 0, 0, -1 } },

			{ { 0, 0, -1 }, { -1, -2, -2 } },

			{ { 0, 0, 1 }, { -1, -2, -2 } },

			{ { 0, 0, -1 }, { 1, 2, 2 } },

			{ { 0, 0, 1 }, { 1, 2, 2 } },

			{ { 1, 1, 2 }, { 0, 1, 1 } }, // 네 번째 모양

			{ { 1, 1, 2 }, { 0, -1, -1 } },

			{ { 0, -1, -1 }, { 1, 1, 2 } },

			{ { 0, -1, -1 }, { -1, -1, -2 } },

			{ { 0, 1, 0 }, { -1, 0, 1 } }, // 다섯 번째 모양

			{ { 0, -1, 0 }, { -1, 0, 1 } },

			{ { -1, 0, 1 }, { 0, -1, 0 } },

			{ { -1, 0, 1 }, { 0, 1, 0 } }

	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result = Math.max(result, isPossible(i, j));
			}
		}
		System.out.println(result);

	}

	static int isPossible(int r, int c) {
		int max = -1;
		loop: for (int i = 0; i < 24; i++) {
			int sum = map[r][c];
			for (int j = 0; j < 3; j++) {

				int nr = r + tetromino[i][0][j];
				int nc = c + tetromino[i][1][j];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue loop;
				sum += map[nr][nc];

			}

			max = Math.max(max, sum);
		}

		return max;
	}

}
//https://www.acmicpc.net/problem/14500