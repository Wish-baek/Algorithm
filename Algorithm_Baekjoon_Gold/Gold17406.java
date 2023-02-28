import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold17406 {
	static int depth;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] tmp;
	static int[][] arr2;
	static int[][] arr;
	static List<int[]> list;
	static List<int[]> outputs = new ArrayList<>();
	static int[] order;
	static boolean[] visited;

	public static int[][] rotate(int r, int c, int s) { // 부분 배열 회전
		tmp = new int[1 + s * 2][1 + s * 2]; // 부분 배열 만들기
		int x = 0;
		for (int a = r - s - 1; a <= r + s - 1; a++) {
			int y = 0;
			for (int b = c - s - 1; b <= c + s - 1; b++) {
				tmp[x][y] = arr[a][b];
				y++;
			}
			x++;
		}
		int group = tmp.length / 2;

		for (int j = 0; j < group; j++) {
			int ax = j;
			int ay = j;

			int value = tmp[ax][ay];
			int len = tmp.length;
			int idx = 0;
			while (idx < 4) {
				if (ax + dr[idx] >= j && ax + dr[idx] < len - j && ay + dc[idx] >= j && ay + dc[idx] < len - j) {
					tmp[ax][ay] = tmp[ax + dr[idx]][ay + dc[idx]];
					ax = ax + dr[idx];
					ay = ay + dc[idx];
				}

				else
					idx++;
			}
			tmp[j][j + 1] = value;

		}
		int xx = 0;
		for (int a = r - s - 1; a <= r + s - 1; a++) {
			int yy = 0;
			for (int b = c - s - 1; b <= c + s - 1; b++) {
				arr[a][b] = tmp[xx][yy];
				yy++;
			}
			xx++;
		}
		return arr;
	}

	public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
		if (depth == r) {
			int[] res = new int[r];
			for (int i = 0; i < r; i++) {
				res[i] = out[i];
			}
			outputs.add(res);

			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				permutation(arr, out, visited, depth + 1, r);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		arr2 = new int[N][M];

		

		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());// 배열 생성
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr2[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			int[] input = { r, c, s };
			list.add(input); // r, c, s 리스트
		}
		order = new int[K];
		for (int i = 0; i < K; i++) {
			order[i] = i;
		}
		// 순열
		permutation(order, new int[K], new boolean[order.length], 0, K);

//		for (int i = 0; i < outputs.size(); i++) {
//			System.out.println(Arrays.toString(outputs.get(i)));
//		}

		int result = 100000000;
		int[][] r_arr = new int[N][M];
		for (int i = 0; i < outputs.size(); i++) {
			for (int j = 0; j < outputs.get(0).length; j++) {
				int r = list.get(outputs.get(i)[j])[0];
				int c = list.get(outputs.get(i)[j])[1];
				int s = list.get(outputs.get(i)[j])[2];

				r_arr = rotate(r, c, s);

			}

			for (int a = 0; a < r_arr.length; a++) {
				int sum = 0;
				for (int b = 0; b < r_arr[0].length; b++) {
					sum += r_arr[a][b];
				}
				if (sum < result)
					result = sum;
			}
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < M; b++) {
					arr[a][b] = arr2[a][b];
				}
			}
		}
		System.out.println(result);

		// 출력
//		for (int a = 0; a < tmp.length; a++) {
//			for (int b = 0; b < tmp[0].length; b++) {
//				System.out.print(tmp[a][b]);
//			}
//			System.out.println();
//		}
	}

}

//https://www.acmicpc.net/problem/17406