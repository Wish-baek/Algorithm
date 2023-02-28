import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze6359 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			boolean[] isOpen = new boolean[n];
			int round = 1;
			while (round <= n) {
				for (int i = 0; i < n; i++) {
					if ((i + 1) % round == 0)
						isOpen[i] = !isOpen[i];
				}
				round++;
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (isOpen[i])
					cnt++;
			}
			System.out.println(cnt);
		}
	}
}
//https://www.acmicpc.net/problem/6359