import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Gold1938 {
	static int[][] map;
	static boolean visited[][][]; // [][] 행열 [] 0:세로, 1:가로
	static int N;

	static class node {
		int r;
		int c;
		int status;
		int time;

		public node(int r, int c, int status, int time) {
			this.r = r;
			this.c = c;
			this.status = status;
			this.time = time;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N][2];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char tmp = str.charAt(j);
				if (tmp == 'B')
					map[i][j] = 2;
				else if (tmp == 'E')
					map[i][j] = 3;
				else
					map[i][j] = tmp - '0';
			}
		}

		int BinitStatus = -1;
		int EinitStatus = -1;

		int Br = -1;
		int Bc = -1;
		int Er = -1;
		int Ec = -1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (Br == -1 && map[i][j] == 2) {
					if (i + 1 < N && map[i + 1][j] == 2) {
						Br = i + 1;
						Bc = j;
						BinitStatus = 0; // 세로
					} else if (j + 1 < N && map[i][j + 1] == 2) {
						Br = i;
						Bc = j + 1;
						BinitStatus = 1; // 가로
					}
				}

				if (Er == -1 && map[i][j] == 3) {
					if (i + 1 < N && map[i + 1][j] == 3) {
						Er = i + 1;
						Ec = j;
						EinitStatus = 0; // 세로
					} else if (j + 1 < N && map[i][j + 1] == 3) {
						Er = i;
						Ec = j + 1;
						EinitStatus = 1; // 가로
					}
				}
			}
		}

		bfs(Br, Bc, BinitStatus, Er, Ec, EinitStatus);
		System.out.println(0);
	}

	static void bfs(int Br, int Bc, int Bstatus, int Er, int Ec, int Estatus) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(Br, Bc, Bstatus, 0));
		visited[Br][Bc][Bstatus] = true;

		while (!q.isEmpty()) {
			node now = q.poll();
			int r = now.r;
			int c = now.c;
			int stat = now.status;
			int time = now.time;

			if (r == Er && c == Ec && stat == Estatus) {
				System.out.println(time);
				System.exit(0);
			}

			if (r - 1 >= 0 && !visited[r - 1][c][stat] && isPossible(r, c, stat, 'U')) {
				q.add(new node(r - 1, c, stat, time + 1));
				visited[r - 1][c][stat] = true;
			}

			if (r + 1 < N && !visited[r + 1][c][stat] && isPossible(r, c, stat, 'D')) {
				q.add(new node(r + 1, c, stat, time + 1));
				visited[r + 1][c][stat] = true;
			}

			if (c - 1 >= 0 && !visited[r][c - 1][stat] && isPossible(r, c, stat, 'L')) {
				q.add(new node(r, c - 1, stat, time + 1));
				visited[r][c - 1][stat] = true;
			}

			if (c + 1 < N && !visited[r][c + 1][stat] && isPossible(r, c, stat, 'R')) {
				q.add(new node(r, c + 1, stat, time + 1));
				visited[r][c + 1][stat] = true;
			}

			if (!visited[r][c][stat == 0 ? 1 : 0] && isPossible(r, c, stat, 'T')) {
				q.add(new node(r, c, stat == 0 ? 1 : 0, time + 1));
				visited[r][c][stat == 0 ? 1 : 0] = true;
			}

		}

	}

	static boolean isPossible(int r, int c, int stat, char d) {
		if (d == 'U') { // 위로 옮길 때
			if (stat == 0 && r - 2 >= 0 && map[r - 2][c] != 1) // 세로
				return true;
			else if (stat == 1 && r - 1 >= 0 && map[r - 1][c - 1] != 1 && map[r - 1][c] != 1 && map[r - 1][c + 1] != 1) // 가로
				return true;
		}

		else if (d == 'D') { // 아래로 옮길 때

			if (stat == 0 && r + 2 < N && map[r + 2][c] != 1)
				return true;
			else if (stat == 1 && r + 1 < N && map[r + 1][c - 1] != 1 && map[r + 1][c] != 1 && map[r + 1][c + 1] != 1)
				return true;
		}

		else if (d == 'L') { // 왼쪽으로 옮길 때
			if (stat == 0 && c - 1 >= 0 && map[r - 1][c - 1] != 1 && map[r][c - 1] != 1 && map[r + 1][c - 1] != 1)
				return true;
			else if (stat == 1 && c - 2 >= 0 && map[r][c - 2] != 1)
				return true;
		}

		else if (d == 'R') {
			if (stat == 0 && c + 1 < N && map[r - 1][c + 1] != 1 && map[r][c + 1] != 1 && map[r + 1][c + 1] != 1)
				return true;
			else if (stat == 1 && c + 2 < N && map[r][c + 2] != 1)
				return true;
		}

		else if (d == 'T') {
			if (stat == 0 && c - 1 >= 0 && c + 1 < N && map[r - 1][c - 1] != 1 && map[r - 1][c + 1] != 1
					&& map[r][c - 1] != 1 && map[r][c + 1] != 1 && map[r + 1][c - 1] != 1 && map[r + 1][c + 1] != 1)
				return true;
			else if (stat == 1 && r - 1 >= 0 && r + 1 < N && map[r - 1][c - 1] != 1 && map[r - 1][c] != 1
					&& map[r - 1][c + 1] != 1 && map[r + 1][c - 1] != 1 && map[r + 1][c] != 1 && map[r + 1][c + 1] != 1)
				return true;
		}
		return false;
	}
}
//https://www.acmicpc.net/problem/1938