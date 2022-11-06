import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold7490 {
	static int n, num;
	static StringBuilder sb = new StringBuilder();;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
//			int[] input = new int[n];
//			for(int i =0; i<n;i++) {
//				input[i] = i+1;
//			}
			num = 0;

			String[] input = { " ", "+", "-" };
			String[] output = new String[n - 1];
			dfs(input, output, 0, "");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(String[] input, String[] output, int depth, String str) {
		if (depth == n - 1) {
			str += n;
			if (cal(str, output))
				sb.append(str).append("\n");
			return;
		}
		for (int i = 0; i < 3; i++) {
			output[depth] = input[i];
			num++;
			dfs(input, output, depth + 1, str + Integer.toString(num) + input[i]);
			num--;
		}
	}

	static boolean cal(String str, String[] output) {
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				cnt++;
		}

		str = str.replace(" ", "");
		StringTokenizer st = new StringTokenizer(str, "+-");

		int result = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n - 1; i++) {
			if (!output[i].equals(" ")) {
				if (output[i].equals("+"))
					result += Integer.parseInt(st.nextToken());
				else if (output[i].equals("-"))
					result -= Integer.parseInt(st.nextToken());
			}
		}
		if (result == 0)
			return true;
		else
			return false;
	}
}
//https://www.acmicpc.net/problem/7490