import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold1062 {
	static String[] wordList;
	static boolean[] alpha;
	static int N, K, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		wordList = new String[N];
		alpha = new boolean[26];

		for (int i = 0; i < N; i++) {
			wordList[i] = br.readLine();
		}
		dfs(0, 0);
		System.out.println(result);
	}

	static void dfs(int at, int depth) {
		if (depth == K) {
			result = Math.max(result, cal());
			return;
		}

		for (int i = at; i < 26; i++) {
			if (!alpha[i]) {
				alpha[i] = true;
				dfs(i + 1, depth + 1);
				alpha[i] = false;
			}
		}
	}

	static int cal() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			boolean ck = true;
			for (int j = 0; j < wordList[i].length(); j++) {
				char c = wordList[i].charAt(j);
				if (!alpha[c - 97]) {
					ck = false;
					break;
				}
			}
			if (ck)
				cnt++;
		}
		return cnt;
	}
}
//https://www.acmicpc.net/problem/1062