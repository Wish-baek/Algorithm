import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Silver1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>();
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
//https://www.acmicpc.net/problem/1927