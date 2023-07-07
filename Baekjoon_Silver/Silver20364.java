import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver20364 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] arr = new int[Q + 1];

		for (int i = 1; i <= Q; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		boolean[] visited = new boolean[N + 1];

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= Q; i++) {
			int tmp = arr[i];
			int now = arr[i];

			int result = 0;

			while (true) { // 원하는 땅에서 부모 노드로 올라가기
				if (visited[now]) {
					result = now;
				}

				now /= 2;
				if (now == 1)
					break;
			}
			if (result == 0)
				visited[tmp] = true;
			sb.append(result).append("\n");

		}
		System.out.println(sb);
	}
}
// https://www.acmicpc.net/problem/20364