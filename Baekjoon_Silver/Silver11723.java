import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> arr = new ArrayList<>();

		int t = Integer.valueOf(br.readLine());

		for (int i = 0; i < t; i++) {

			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			String a = st.nextToken();

			if (a.equals("all")) {
				arr = new ArrayList<>(
						Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

			} else if (a.equals("empty")) {
				arr.clear();

			} else if (a.equals("add")) {
				int n = Integer.valueOf(st.nextToken());
				if (!arr.contains(n)) {
					arr.add(n);
				} else
					continue;
			} else if (a.equals("remove")) {
				int n = Integer.valueOf(st.nextToken());
				if (arr.contains(n)) {
					arr.remove(Integer.valueOf(n));
				} else
					continue;

			} else if (a.equals("check")) {
				int n = Integer.valueOf(st.nextToken());
				if (arr.contains(n))
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");

			} else if (a.equals("toggle")) {
				int n = Integer.valueOf(st.nextToken());
				if (arr.contains(n))
					arr.remove(Integer.valueOf(n));
				else
					arr.add(n);

			}

		}
		System.out.println(sb);
	}

}
//https://www.acmicpc.net/problem/11723