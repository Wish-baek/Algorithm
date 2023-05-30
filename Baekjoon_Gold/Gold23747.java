import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold23747 {

	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		q = new LinkedList<>();

		String str;
		for (int i = 0; i < R; i++) {
			str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int HR = Integer.parseInt(st.nextToken()) - 1;
		int HC = Integer.parseInt(st.nextToken()) - 1;

		str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'U')
				HR--;
			else if (ch == 'D')
				HR++;
			else if (ch == 'L')
				HC--;
			else if (ch == 'R')
				HC++;
			else if (ch == 'W') {
				q.add(new int[] { HR, HC });
				visited[HR][HC] = true;
			}
		}

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (visited[nr][nc] || map[r][c] != map[nr][nc])
					continue;
				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}

		for (int i = 0; i < 4; i++) {
			int nr = HR + dr[i];
			int nc = HC + dc[i];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			visited[nr][nc] = true;
		}

		visited[HR][HC] = true;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visited[i][j])
					sb.append(".");
				else
					sb.append("#");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
// https://www.acmicpc.net/problem/23747