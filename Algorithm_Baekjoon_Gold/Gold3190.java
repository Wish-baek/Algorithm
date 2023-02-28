import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Gold3190 {
	static int[][] board;
	static Map<Integer, Character> map;

	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 };
	static int N, time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		board = new int[N][N];
		map = new HashMap<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			board[r][c] = 2; // 사과 위치
		}
		int L = Integer.parseInt(br.readLine());

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			map.put(X, C);
		}

		Dummy();
		System.out.println(time);

	}

	public static void Dummy() {
		Deque<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		int d = 1;
		time = 0;
		while (true) {
			time++;
			int nr = q.peekFirst()[0] + dr[d];
			int nc = q.peekFirst()[1] + dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				break;
			}
			int[] arr = { nr, nc };
			int cnt = 0;

			for (int[] a : q) {
				if (cnt != 0) {
					if (arr[0] == a[0] && arr[1] == a[1])
						return;
				}
				cnt++;
			}

			q.addFirst(new int[] { nr, nc });
			if (board[nr][nc] == 2) {
				board[nr][nc] = 0;
			} else {
				q.pollLast();
			}

			if (map.containsKey(time)) {
				char tmp = map.get(time);
				if (tmp == 'L') {
					d = (d + 4 - 1) % 4;
				} else if (tmp == 'D') {
					d = (d + 1) % 4;
				}

			}

		}
	}

}
//https://www.acmicpc.net/problem/3190