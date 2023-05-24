import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold16397 {
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());

		min = Integer.MAX_VALUE;
		bfs(N, T, G);
		System.out.println(min == Integer.MAX_VALUE ? "ANG" : min);

	}

	static void bfs(int start, int max_cnt, int result) {
		boolean[] visited = new boolean[100000];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start, 0 });
		visited[start] = true;

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int now = arr[0];
			int cnt = arr[1];

			if (now == result) {
				min = Math.min(min, cnt);
				continue;
			}

			if (cnt == max_cnt) // 횟수 다 썼으면 더 보지 않음
				continue;

			if (now + 1 <= 99999 && !visited[now + 1]) { // A 버튼을 누르는 경우
				q.add(new int[] { now + 1, cnt + 1 });
				visited[now + 1] = true;
			}

			if (now * 2 >= 99999)
				continue;

			String tmpNum = Integer.toString(now * 2);
			int tmpResult = now * 2;
			for (int i = 0; i < tmpNum.length(); i++) { // B 버튼을 누르는 경우
				if (tmpNum.charAt(i) != '0') {
					tmpResult -= Math.pow(10, tmpNum.length() - i - 1);
					break;
				}
			}

			if (tmpResult <= 99999 && !visited[tmpResult]) {
				q.add(new int[] { tmpResult, cnt + 1 });
				visited[tmpResult] = true;
			}
		}
	}
}
//https://www.acmicpc.net/problem/16397