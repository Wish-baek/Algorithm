import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Silver14225 {
	static int N;
	static int[] arr;
	static Set<Integer> set;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		set = new HashSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		bruteforce(0, 0);

		int min = 1;
		while (true) {
			if (set.contains(min))
				min++;
			else
				break;
		}

		System.out.println(min);

	}

	static void bruteforce(int sum, int idx) {
		if (sum != 0) {
			set.add(sum);
		}

		if (idx == N)
			return;

		bruteforce(sum, idx + 1);
		bruteforce(sum += arr[idx], idx + 1);
	}
}
//https://www.acmicpc.net/problem/14225