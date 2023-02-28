import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2531 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] dish = new int[N];

		for (int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		int[] visited = new int[d + 1];
		int max = -1;
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			int n = dish[i];
			if (visited[n] == 0) {
				cnt++;
			}
			visited[n]++;
		}
		max = Math.max(max, cnt);
		for (int i = 0; i < N; i++) {
			if (visited[dish[i]] == 1) {
				visited[dish[i]]--;
				cnt--;
			} else if (visited[dish[i]] >= 2)
				visited[dish[i]]--;

			int next = dish[(i + k) % N];

			if (visited[next] == 0) {
				cnt++;
			}
			visited[next]++;
			if (visited[c] == 0)
				max = Math.max(max, cnt + 1);
			else
				max = Math.max(max, cnt);
		}

		System.out.println(max);
	}
}
//https://www.acmicpc.net/problem/2531