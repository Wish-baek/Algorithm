import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver15558 {
	static int N, K;
	static int[][] map;
	static boolean[][] isBreak;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[2][N];
		isBreak = new boolean[2][N];

		for (int i = 0; i < 2; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs();
		System.out.println(0);
	}

	static void bfs() {
		boolean[][] visited = new boolean[2][N];
		visited[0][0] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0 });

		int time = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int s = 0; s < size; s++) {
				int[] temp = q.poll();
				int r = temp[0];
				int c = temp[1];

				if (isBreak[r][c])
					continue;

				// i==0 한 칸 앞으로 이동할 때
				if (c + 1 >= N) {
					System.out.println(1);
					System.exit(0);
				}
				if (c + 1 < N && map[r][c + 1] == 1 && !visited[r][c + 1] && !isBreak[r][c + 1]) {
					q.add(new int[] { r, c + 1 });
					visited[r][c + 1] = true;
				}
				// i==1 한 칸 뒤로 이동할 때
				if (c - 1 >= 0 && map[r][c - 1] == 1 && !visited[r][c - 1] && !isBreak[r][c - 1]) {
					q.add(new int[] { r, c - 1 });
					visited[r][c - 1] = true;
				}
				// i==2 반대편 줄로 이동할 때
				if (c + K >= N) {
					System.out.println(1);
					System.exit(0);
				}
				r = r == 0 ? 1 : 0;
				if (c + K < N && map[r][c + K] == 1 && !visited[r][c + K] && !isBreak[r][c + K]) {
					q.add(new int[] { r, c + K });
					visited[r][c + K] = true;
				}
			}
			isBreak[0][time] = true;
			isBreak[1][time] = true;
			time++;
		}
	}
}
//https://www.acmicpc.net/problem/15558