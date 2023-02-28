import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold12904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();

		dfs(a, b);
		System.out.println(0);
	}

	static void dfs(String a, String b) {
		if (a.length() == b.length()) {
			if (a.equals(b)) {
				System.out.println(1);
				System.exit(0);
			}
			return;
		}

		if (b.charAt(b.length() - 1) == 'A') {
			String tmp = b.substring(0, b.length() - 1);
			dfs(a, tmp);
		}

		if (b.charAt(b.length() - 1) == 'B') {
			String tmp = "";
			b = b.substring(0, b.length() - 1);
			for (int i = b.length() - 1; i >= 0; i--) {
				tmp += b.charAt(i);
			}
			dfs(a, tmp);
		}
	}
}
//https://www.acmicpc.net/problem/12904