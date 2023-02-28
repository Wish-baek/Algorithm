import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringBuilder sb = new StringBuilder();

			boolean result = true;
			String func = br.readLine();
			int n = Integer.parseInt(br.readLine());

			List<Integer> list = new ArrayList<>();
			LinkedList<Integer> q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");

			for (int i = 0; i < n; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			int where = -1;
			for (int i = 0; i < func.length(); i++) {
				if (func.charAt(i) == 'R') {
					where *= -1;
				} else if (func.charAt(i) == 'D') {
					if (q.isEmpty()) {
						result = false;
						continue;
					}
					if (where == -1)
						q.pollFirst();
					else if (where == 1)
						q.pollLast();
				}
//				for(int k =0; k < list.size(); k++) {
//					System.out.print(list.get(k)+" ");
//				}
//				System.out.println();
			}

			if (result == true) {
				sb.append("[");

				if (where == -1)

					while (!q.isEmpty()) {
						if (q.size() == 1)
							sb.append(q.pollFirst());
						else
							sb.append(q.pollFirst()).append(",");
					}

				else if (where == 1)
					while (!q.isEmpty()) {
						if (q.size() == 1)
							sb.append(q.pollLast());
						else
							sb.append(q.pollLast()).append(",");
					}

				sb.append("]").append("\n");
			} else
				sb.append("error").append("\n");
			bw.write(sb + "");

		}
		bw.close();
	}
}
//https://www.acmicpc.net/problem/5430