import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Gold2251 {
	static Set<Integer> set;
	static boolean[][][] visited;
	static int aMax, bMax, cMax, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		aMax = Integer.parseInt(st.nextToken());
		bMax = Integer.parseInt(st.nextToken());
		cMax = Integer.parseInt(st.nextToken());

		visited = new boolean[aMax + 1][bMax + 1][cMax + 1];

		int a = 0;
		int b = 0;
		int c = cMax;

		set = new HashSet<>();

		bfs(a, b, c);

		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);

		for (int i : list) {
			System.out.print(i + " ");
		}
	}

	static void bfs(int sa, int sb, int sc) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sa, sb, sc });
		visited[sa][sb][sc] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int a = tmp[0];
			int b = tmp[1];
			int c = tmp[2];

			if (a == 0)
				set.add(c);

			// a -> b
			int bGet = 0;
			if (b + a > bMax)
				bGet = bMax - b;
			else
				bGet = a;
			if (!visited[a - bGet][b + bGet][c]) {
				visited[a - bGet][b + bGet][c] = true;
				q.add(new int[] { a - bGet, b + bGet, c });
			}

			// a -> c
			int cGet = 0;
			if (c + a > cMax)
				cGet = cMax - c;
			else
				cGet = a;
			if (!visited[a - cGet][b][c + cGet]) {
				visited[a - cGet][b][c + cGet] = true;
				q.add(new int[] { a - cGet, b, c + cGet });
			}

			// b -> a
			int aGet = 0;
			if (a + b > aMax)
				aGet = aMax - a;
			else
				aGet = b;
			if (!visited[a + aGet][b - aGet][c]) {
				visited[a + aGet][b - aGet][c] = true;
				q.add(new int[] { a + aGet, b - aGet, c });
			}

			// b -> c
			cGet = 0;
			if (c + b > cMax)
				cGet = cMax - c;
			else
				cGet = b;
			if (!visited[a][b - cGet][c + cGet]) {
				visited[a][b - cGet][c + cGet] = true;
				q.add(new int[] { a, b - cGet, c + cGet });
			}

			// c -> a
			aGet = 0;
			if (a + c > aMax)
				aGet = aMax - a;
			else
				aGet = c;
			if (!visited[a + aGet][b][c - aGet]) {
				visited[a + aGet][b][c - aGet] = true;
				q.add(new int[] { a + aGet, b, c - aGet });
			}

			// c -> b
			bGet = 0;
			if (b + c > bMax)
				bGet = bMax - b;
			else
				bGet = c;
			if (!visited[a][b + bGet][c - bGet]) {
				visited[a][b + bGet][c - bGet] = true;
				q.add(new int[] { a, b + bGet, c - bGet });
			}
		}
	}
}
//https://www.acmicpc.net/problem/2251