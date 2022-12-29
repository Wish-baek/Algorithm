import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze10214 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int y = 0;
			int k = 0;

			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				y += Integer.parseInt(st.nextToken());
				k += Integer.parseInt(st.nextToken());
			}

			if (y > k)
				System.out.println("Yonsei");
			else if (y < k)
				System.out.println("Korea");
			else
				System.out.println("Draw");
		}
	}
}
//https://www.acmicpc.net/problem/10214