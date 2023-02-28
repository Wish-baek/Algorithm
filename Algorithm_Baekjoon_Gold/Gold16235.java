import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold16235 {
	static int[][] A;
	static int[][] nutri;
	static Queue<tree> pq; // 나무 리스트
	static Queue<tree> q; // 죽은 나무 리스트
	static int N;

	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static class tree implements Comparable<tree> {
		int r;
		int c;
		int age;

		public tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(tree o) {
			return this.age - o.age;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		pq = new LinkedList<>();

		A = new int[N][N];
		nutri = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				nutri[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			pq.add(new tree(r, c, age));
		}

		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}

//		for (int a = 0; a < N; a++) {
//			for (int b = 0; b < N; b++) {
//				System.out.print(drawing[a][b] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		System.out.println(pq.size());
	}

	static void spring() {
		Queue<tree> tmp = new LinkedList<>();
		q = new LinkedList<>();
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			tree tr = pq.poll();
			int r = tr.r;
			int c = tr.c;
			int age = tr.age;
			if (nutri[r][c] >= age) {
				nutri[r][c] -= age;
				tmp.add(new tree(r, c, age + 1));
			} else {
				q.add(new tree(r, c, age));

			}
		}
		pq = new PriorityQueue<>(tmp);
	}

	static void summer() {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			tree tr = q.poll();
			int r = tr.r;
			int c = tr.c;
			int age = tr.age;
			nutri[r][c] += age / 2;
		}
		q = new LinkedList<>();
	}

	static void fall() {
		Queue<tree> tmp = new LinkedList<>();
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			tree tr = pq.poll();
			int r = tr.r;
			int c = tr.c;
			int age = tr.age;

			tmp.add(new tree(r, c, age));

			if (age % 5 != 0)
				continue;

			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				tmp.add(new tree(nr, nc, 1));
			}
		}
		pq = new PriorityQueue<>(tmp);
	}

	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				nutri[i][j] += A[i][j];
			}
		}
	}
}
//https://www.acmicpc.net/problem/16235