import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs 돌려서 클러스터 구분 -> 화살 맞은 후 분리 된 클리스터 있는지 확인(bfs)
// -> 각 클러스터의 조각들 리스트에 저장 -> 장애물 없을 때까지 아래로 이동

public class Gold2933 {
	static int R, C, num, tmpNum;
	static char[][] map;
	static int[][] cluster;
	static PriorityQueue<mineral> mlist;

	static class mineral implements Comparable<mineral> {
		int r;
		int c;

		public mineral(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(mineral o) {
			return o.r - this.r;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		cluster = new int[R][C];
		mlist = new PriorityQueue<>();

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int oper = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= oper; i++) {
			int height = R - Integer.parseInt(st.nextToken());
			int dir = i % 2 == 1 ? 1 : -1; // 홀수번째면 왼쪽 -> 오른쪽, 짝수번째면 오른쪽 -> 왼쪽
			flyArr(height, dir);
			calPiece();
		}

		for (int a = 0; a < R; a++) {
			for (int b = 0; b < C; b++) {
				System.out.print(map[a][b]);
			}
			System.out.println();
		}
		System.out.println();
	}

	static void down(PriorityQueue<mineral> list) {
		PriorityQueue<mineral> tmpQ = new PriorityQueue<>(list);
		boolean ck = false;
		int min = Integer.MAX_VALUE;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			mineral m = list.poll();

			int r = m.r;
			int c = m.c;
			int nr = r;
			int tmp = 1;
			while (true) {
				nr++;
				if (nr >= R || (cluster[nr][c] != 0 && cluster[nr][c] != cluster[r][c])) {
					min = Math.min(min, tmp - 1);
					break;
				}
				tmp++;

			}
		}
		for (int i = 0; i < size; i++) {
			mineral m = tmpQ.poll();
			int r = m.r + min;
			int c = m.c;

			map[r][c] = 'x';
			cluster[r][c] = cluster[m.r][m.c];
			map[m.r][m.c] = '.';
			cluster[m.r][m.c] = 0;
		}
	}

	static void calPiece() {
		cluster = new int[R][C];
		tmpNum = 1;
		for (int i = R - 1; i >= 0; i--) {
			for (int j = C - 1; j >= 0; j--) {
				if (cluster[i][j] == 0 && map[i][j] == 'x') {
					mlist = new PriorityQueue<>();
					split(i, j, tmpNum);
					tmpNum++;
					if (i != R - 1)
						down(mlist);
				}
			}
		}
		if (num != tmpNum) {
			num = tmpNum;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void flyArr(int height, int dir) {
		int r = height;
		int c = dir == 1 ? 0 : C - 1;
		while (true) {
			if (c < 0 || c >= C)
				break;
			if (map[r][c] == 'x') {
				map[r][c] = '.';
				break;
			}
			c += dir;
		}
	}

	static void split(int sr, int sc, int num) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		mlist.add(new mineral(sr, sc));
		cluster[sr][sc] = num;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (cluster[nr][nc] != 0 || map[nr][nc] == '.')
					continue;
				cluster[nr][nc] = num;
				q.add(new int[] { nr, nc });
				mlist.add(new mineral(nr, nc));
			}
		}
	}
}
//https://www.acmicpc.net/problem/2933