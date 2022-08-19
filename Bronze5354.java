import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze5354 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {

			int N = Integer.parseInt(br.readLine());

			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i==0 || i==N-1||j==0||j==N-1) {
						sb.append("#");
					}
					else sb.append("J");
				}
				sb.append("\n");
			}
			if (tc != T - 1)
				sb.append("\n");
		}
		System.out.print(sb);

	}

}
//https://www.acmicpc.net/problem/5354