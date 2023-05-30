import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold17265 {
	static char[][] map;
	static int N, max, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		dfs(0, 0, map[0][0] + "");
		System.out.println(max + " " + min);
	}

	static void dfs(int r, int c, String exp) {

		if (r == N - 1 && c == N - 1) {
			int result = calc(exp);
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		int nr = r + 1;
		if (nr >= 0 && nr < N)
			dfs(nr, c, exp + map[nr][c]);

		int nc = c + 1;
		if (nc >= 0 && nc < N)
			dfs(r, nc, exp + map[r][nc]);
	}

	static int calc(String exp) {
		int sum = exp.charAt(0) - '0';
		char oper = ' ';
		for (int i = 1; i < exp.length(); i++) {
			if (i % 2 == 1)
				oper = exp.charAt(i);
			else {
				if (oper == '+')
					sum += exp.charAt(i) - '0';
				else if (oper == '-')
					sum -= exp.charAt(i) - '0';
				else if (oper == '*')
					sum *= exp.charAt(i) - '0';
			}
		}
		return sum;
	}
}
//https://www.acmicpc.net/problem/17265