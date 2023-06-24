import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Silver20291 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new HashMap<>();

		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine().split("\\.")[1];

			if (map.get(str) == null)
				map.put(str, 1);
			else
				map.replace(str, map.get(str) + 1);
		}

		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);

		for (String item : list) {
			sb.append(item).append(" ").append(map.get(item)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
//https://www.acmicpc.net/problem/20291