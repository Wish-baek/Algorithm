import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze10953 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			st = new StringTokenizer(br.readLine(), " ,");
			System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
		}
	}
}
