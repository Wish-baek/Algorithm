import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold1963 {
	static boolean[] primeArr;

	static class info {
		String str;
		int cnt;

		public info(String str, int cnt) {
			this.str = str;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String a = st.nextToken();
			String b = st.nextToken();
			prime();
			bfs(a, b);
		}
	}

	static void bfs(String a, String b) {
		boolean[] visited = new boolean[10000];
		Queue<info> q = new LinkedList<>();
		q.add(new info(a, 0));
		visited[Integer.parseInt(a)] = true;
		while (!q.isEmpty()) {
			info info = q.poll();
			String s = info.str;
			int cnt = info.cnt;

			if (Integer.parseInt(b) == Integer.parseInt(s)) {
				System.out.println(cnt);
				return;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j <= 9; j++) {
					if (i == 0 && j == 0 || s.charAt(i) - '0' == j)
						continue;
					String tmp = "";
					if (i == 0) {
						tmp += Integer.toString(j);
						tmp += s.substring(1, 4);
					}

					else if (i == 3) {
						tmp += s.substring(0, 3);
						tmp += Integer.toString(j);
					} else {
						tmp += s.substring(0, i);
						tmp += Integer.toString(j);
						tmp += s.substring(i + 1, 4);
					}

					int t = Integer.parseInt(tmp);
					if (!visited[t] && !primeArr[t]) {
						q.add(new info(tmp, cnt + 1));
						visited[t] = true;
					}
				}
			}
		}
		System.out.println("Impossible");
	}

	static void prime() {
		primeArr = new boolean[10001];

		for (int i = 2; i <= 10000; i++) {
			for (int j = 2; j <= 10000; j++) {
				if (i * j <= 10000)
					primeArr[i * j] = true;
			}
		}
	}
}
//https://www.acmicpc.net/problem/1963