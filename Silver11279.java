import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Silver11279 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2-o1;
			}
		});
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp != 0)
				q.add(tmp);
			else if (tmp == 0 && q.isEmpty())
				sb.append(0).append("\n");
			else
				sb.append(q.poll()).append("\n");
		}
		System.out.println(sb);
	}

}
//https://www.acmicpc.net/problem/11279