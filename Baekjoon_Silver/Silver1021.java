import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Silver1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> dq = new LinkedList<>();

		int[] arr = new int[M];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			dq.add(i + 1);
		}

		int now = 0;
		int result = 0;

		while (true) {
			if (dq.get(0) == arr[now]) {
				dq.remove(0);
				now++;
				if (now == M)
					break;
				else
					continue;
			}
			int idx = dq.indexOf(arr[now]);

			if (idx <= dq.size() / 2) { // 뽑아야하는 수가 배열의 앞에 있다면
				// 2번 연산 수행
				dq.add(dq.get(0));
				dq.remove(0);
			} else { // 뽑아야하는 수가 배열의 뒤에 있다면
				// 3번 연산 수행
				dq.add(0, dq.get(dq.size() - 1));
				dq.remove(dq.size() - 1);
			}

			result++;
		}

		System.out.println(result);
	}
}
//https://www.acmicpc.net/problem/1021