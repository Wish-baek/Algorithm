import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold19238 {
	static int[][] map;
	static int[][] pNum;
	static Passenger[] pList;
	static int N, totalFuel, fuel, tr, tc;

	static class Passenger {
		int sr;
		int sc;
		int fr;
		int fc;

		public Passenger(int sr, int sc, int fr, int fc) {
			this.sr = sr;
			this.sc = sc;
			this.fr = fr;
			this.fc = fc;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken()); // 태울 승객 목표
		totalFuel = Integer.parseInt(st.nextToken()); // 초기 연료 양

		map = new int[N][N];
		pNum = new int[N][N];

		pList = new Passenger[M + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		tr = Integer.parseInt(st.nextToken()) - 1;
		tc = Integer.parseInt(st.nextToken()) - 1;
		int num = 1;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sr = Integer.parseInt(st.nextToken()) - 1;
			int sc = Integer.parseInt(st.nextToken()) - 1;
			int fr = Integer.parseInt(st.nextToken()) - 1;
			int fc = Integer.parseInt(st.nextToken()) - 1;
			pList[i] = new Passenger(sr, sc, fr, fc);
			pNum[sr][sc] = num++;
		}

		for (int i = 0; i < M; i++) {
			fuel = 0;
			Passenger ps = findPassenger();
			pNum[ps.sr][ps.sc] = 0;

			go_Destination(ps);
		}
		System.out.println(totalFuel);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void go_Destination(Passenger ps) {
		int[][] visited = new int[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { ps.sr, ps.sc });
		visited[ps.sr][ps.sc] = 1;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			if (r == ps.fr && c == ps.fc)
				break;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc] != 0 || map[nr][nc] == 1)
					continue;
				q.add(new int[] { nr, nc });
				visited[nr][nc] = visited[r][c] + 1;
			}
		}
		if (visited[ps.fr][ps.fc] == 0) {
			System.out.println(-1);
			System.exit(0);
		}
		totalFuel -= visited[ps.fr][ps.fc] - 1;
		if (totalFuel < 0) {
			System.out.println(-1);
			System.exit(0);
		}
		tr = ps.fr;
		tc = ps.fc;
		totalFuel += (visited[ps.fr][ps.fc] - 1) * 2;

	}

	static Passenger findPassenger() {
		if (pNum[tr][tc] != 0) {
			return pList[pNum[tr][tc]];
		}

		int[][] visited = new int[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { tr, tc });
		visited[tr][tc] = 1;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc] != 0 || map[nr][nc] == 1)
					continue;
				q.add(new int[] { nr, nc });
				visited[nr][nc] = visited[r][c] + 1;
			}
		}
		int min = Integer.MAX_VALUE;
		int minr = Integer.MAX_VALUE;
		int minc = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] != 0 && visited[i][j] < min && pNum[i][j] != 0) {
					min = visited[i][j];
					minr = i;
					minc = j;
				}
			}
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
			System.exit(0);
		}
		int num = pNum[minr][minc];
		totalFuel -= visited[minr][minc] - 1;
		if (totalFuel < 0) {
			System.out.println(-1);
			System.exit(0);
		}
		tr = minr;
		tc = minc;
		return pList[num];

	}
}
//https://www.acmicpc.net/problem/19238