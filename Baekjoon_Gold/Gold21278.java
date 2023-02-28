import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold21278 {
	static int[][] dist;
	static int[][] adj;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		adj = new int[N + 1][N + 1];
		dist = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i == j)
					adj[i][j] = 0;
				else
					adj[i][j] = 987654321;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;
			adj[b][a] = 1;
		}

		for (int k = 1; k < N + 1; k++) { // 플로이드워셜 이용해 각 도시끼리의 거리 계산
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[k][j] + adj[i][k]);
				}
			}
		}
		int min = 987654321;

		int a = 987654321;
		int b = 987654321;
		int distSum = 0;

		for (int i = 1; i < N + 1; i++) {
			for (int j = 2; j < N + 1; j++) {
				int sum = cal(i, j);

				if (sum < min) {
					distSum = sum;
					a = i;
					b = j;
					min = distSum;
				} else if (sum == min) {
					if (i < a) {
						distSum = sum;
						a = i;
						b = j;
						min = distSum;
					} else if (i == a && j < b) {
						distSum = sum;
						a = i;
						b = j;
						min = distSum;
					}
				}
			}
		}
		System.out.println(a + " " + b + " " + distSum);
	}

	private static int cal(int a, int b) {
		int sum = 0;
		for (int i = 1; i < N + 1; i++) {
			if (i == a || i == b)
				continue;
			sum += Math.min(adj[a][i] + adj[i][a], adj[b][i] + adj[i][b]);
		}
		return sum;
	}
}
//https://www.acmicpc.net/problem/21278