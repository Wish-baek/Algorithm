import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver16935 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] tmp = new int[N][M];
		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				tmp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int[] cal = new int[R];

		for (int i = 0; i < R; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < R; i++) {
			int n = tmp.length;
			int m = tmp[0].length;
			if (cal[i] == 1) {
				for (int a = 0; a < n; a++) {
					for (int b = 0; b < m; b++) {
						arr[n - 1 - a][b] = tmp[a][b];
					}
				}
			} else if (cal[i] == 2) {
				for (int a = 0; a < n; a++) {
					for (int b = 0; b < m; b++) {
						arr[a][m - 1 - b] = tmp[a][b];
					}
				}
			} else if (cal[i] == 3) {
				arr = new int[m][n];
				for (int a = 0; a < m; a++) {
					for (int b = 0; b < n; b++) {
						arr[a][b] = tmp[n - 1 - b][a];
					}
				}

			} else if (cal[i] == 4) {
				arr = new int[m][n];
				for (int a = 0; a < m; a++) {
					for (int b = 0; b < n; b++) {
						arr[a][b] = tmp[b][m - 1 - a];
					}
				}

			} else if (cal[i] == 5) {
				for (int a = 0; a < n / 2; a++) {
					for (int b = 0; b < m / 2; b++) {
						arr[a][b] = tmp[a + n / 2][b];
					}
				}
				for (int a = 0; a < n / 2; a++) {
					for (int b = m / 2; b < m; b++) {
						arr[a][b] = tmp[a][b - m / 2];
					}
				}
				for (int a = n / 2; a < n; a++) {
					for (int b = 0; b < m / 2; b++) {
						arr[a][b] = tmp[a][b + m / 2];
					}
				}
				for (int a = n / 2; a < n; a++) {
					for (int b = m / 2; b < m; b++) {
						arr[a][b] = tmp[a - n / 2][b];
					}
				}

			} else if (cal[i] == 6) {

				for (int a = 0; a < n / 2; a++) {
					for (int b = 0; b < m / 2; b++) {
						arr[a][b] = tmp[a][b + m / 2];
					}
				}
				for (int a = 0; a < n / 2; a++) {
					for (int b = m / 2; b < m; b++) {
						arr[a][b] = tmp[a + n / 2][b];
					}
				}
				for (int a = n / 2; a < n; a++) {
					for (int b = 0; b < m / 2; b++) {
						arr[a][b] = tmp[a - n / 2][b];
					}
				}
				for (int a = n / 2; a < n; a++) {
					for (int b = m / 2; b < m; b++) {
						arr[a][b] = tmp[a][b - m / 2];
					}
				}
			}
			tmp = new int[arr.length][arr[0].length];
			
			for (int l = 0; l < arr.length; l++) {
				for (int k = 0; k < arr[0].length; k++) {
					tmp[l][k] = arr[l][k];
				}
			}
		}

		if (arr.length == N) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(tmp[i][j]).append(" ");
				}
				sb.append("\n");
			}
		} else {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}

}
//https://www.acmicpc.net/problem/16935