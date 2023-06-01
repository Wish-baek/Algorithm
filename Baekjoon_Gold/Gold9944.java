import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold9944 {
	static int N, M, block, result;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String tmp;
		int testCase = 1;

		while (true) {
			tmp = br.readLine();

			if (tmp.equals("")) // 백준 제출할 때는 tmp == null로 해야함
				break;

			StringTokenizer st = new StringTokenizer(tmp, " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			visited = new boolean[N][M];

			block = 0;

			String str;
			for (int i = 0; i < N; i++) {
				str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '.')
						block++;
				}
			}

			result = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '*')
						continue;
					visited = new boolean[N][M];
					play(i, j, -1, 0, 1, 0);
				}
			}

			if (result == Integer.MAX_VALUE)
				result = -1;

			sb.append("Case").append(" ").append(testCase).append(":").append(" ").append(result).append("\n");
			testCase++;
		}
		System.out.println(sb);
	}

	static void play(int r, int c, int dir, int moveCnt, int blockCnt, int depth) {

		if (moveCnt > result) // 이동 횟수가 최솟값보다 크면 리턴
			return;

		if (blockCnt == block) { // 모든 칸 방문했다면
			result = Math.min(result, moveCnt); // 최솟값 갱신해주고 리턴
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (i == dir) // 이전에 움직였던 방향과 같다면 continue;
				continue;

			int nr = r;
			int nc = c;
			int cnt = 0;

			visited[nr][nc] = true;

			while (true) { // 갈 수 있는 곳 체크, 방문 표시
				nr += dr[i];
				nc += dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					nr -= dr[i];
					nc -= dc[i];
					break;
				}
				if (visited[nr][nc] || map[nr][nc] == '*') {
					nr -= dr[i];
					nc -= dc[i];
					break;
				}
				visited[nr][nc] = true;
				cnt++;

			}

			if (cnt > 0) // 갈 수 있다면 움직임 횟수++, 벽이 아닌 곳 + cnt
				play(nr, nc, i, moveCnt + 1, blockCnt + cnt, depth + 1);

			while (true) { // 갔던 곳 방문 표시 해제
				if (nr == r && nc == c)
					break;
				visited[nr][nc] = false;

				nr -= dr[i];
				nc -= dc[i];
			}
		}
	}
}
//https://www.acmicpc.net/problem/9944