import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Silver17219 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		Map<String, String> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String addr = st.nextToken();
			String pwd = st.nextToken();

			map.put(addr, pwd);
		}

		for (int i = 0; i < M; i++) {
			String addr = br.readLine();
			String pwd = map.get(addr);
			sb.append(pwd).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
	}
}
//https://www.acmicpc.net/problem/17219