import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold17281 {
	static int inning, max;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inning = Integer.parseInt(br.readLine());

		arr = new int[inning][10];

		for (int i = 0; i < inning; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] visited = new boolean[10];
		int[] output = new int[9];
		output[3] = 1;
		perm(0, 9, visited, output);
//		play();
		System.out.println(max);

	}

	static void perm(int depth, int r, boolean[] visited, int[] output) {
		if (depth == r) {
			play(output);
//			play();
//			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = 2; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = i;
				if (depth + 1 == 3)
					perm(depth + 2, r, visited, output);
				else
					perm(depth + 1, r, visited, output);
				visited[i] = false;
			}
		}

	}

	static void play(int[] output) {
		boolean[] ru = new boolean[4];
		List<Integer> list = new ArrayList<>();
		int nowInning = 0;
		int now = 0;
		int score = 0;
		int out = 0;

		while (true) {
			if (now == 9)
				now = 0;

			int player = output[now];
			int hit = arr[nowInning][player];

			if (hit == 0) {
				out++;

			} else if (hit == 1) {
				if (ru[3]) {
					score++;
					ru[3] = false;
				}
				if (ru[2]) {
					ru[3] = true;
					ru[2] = false;
				}
				if (ru[1]) {
					ru[2] = true;
				}
				ru[1] = true;
			}

			else if (hit == 2) {
				if (ru[3]) {
					score++;
					ru[3] = false;
				}
				if (ru[2]) {
					score++;
				}
				if (ru[1]) {
					ru[3] = true;
					ru[1] = false;
				}
				ru[2] = true;

			}

			else if (hit == 3) {
				if (ru[3]) {
					score++;
				}
				if (ru[2]) {
					score++;
					ru[2] = false;
				}
				if (ru[1]) {
					score++;
					ru[1] = false;
				}
				ru[3] = true;

			}

			else if (hit == 4) {
				if (ru[3]) {
					score++;
					ru[3] = false;
				}
				if (ru[2]) {
					score++;
					ru[2] = false;
				}
				if (ru[1]) {
					score++;
					ru[1] = false;
				}
				score++;
			}
			now++;
			if (out >= 3) {
				nowInning++;
				ru = new boolean[4];
				out = 0;
				if (nowInning >= inning) {
					max = Math.max(max, score);
					break;
				}

			}
		}
	}

}
//https://www.acmicpc.net/problem/17281