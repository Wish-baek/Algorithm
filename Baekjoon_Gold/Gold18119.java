import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold18119 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] words = new int[N];
		int memo = (1 << 27) - 1;
		for (int i = 0; i < N; i++) {
			String word = br.readLine();

			int tmp = 0;

			for (int j = 0; j < word.length(); j++) {
				char ch = word.charAt(j);
				tmp = tmp | (1 << (ch - 'a'));
			}
			words[i] = tmp;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int op = Integer.parseInt(st.nextToken());
			char alpha = (char) (st.nextToken().charAt(0) - 'a');

			if (op == 1) {
				memo = memo & ~(1 << alpha);
			} else
				memo = memo | (1 << alpha);

			int cnt = 0;
			for (int word : words) {
				if ((memo & word) >= word)
					cnt++;
			}

			System.out.println(cnt);
		}
	}
}
// https://www.acmicpc.net/problem/18119