import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Silver1764 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());

		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				cnt++;
				list.add(str);
			}
		}
		sb.append(cnt).append("\n");
		Collections.sort(list);

		for (String s : list)
			sb.append(s).append("\n");

		System.out.println(sb);

	}

}
