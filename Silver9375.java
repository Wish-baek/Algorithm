import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Silver9375 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String name = st.nextToken();
				String type = st.nextToken();
				if (map.containsKey(type))
					map.put(type, map.get(type) + 1);
				else
					map.put(type, 1);
			}
			int ans = 1;
			for (int i : map.values()) {
				ans *= (i + 1);
			}
			System.out.println(ans - 1);

		}

	}

}
//https://www.acmicpc.net/problem/9375