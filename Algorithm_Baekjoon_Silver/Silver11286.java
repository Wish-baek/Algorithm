import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Silver11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new PriorityQueue<>((o1, o2) -> {
			
			
			if(Math.abs(o1)==Math.abs(o2)) return o1-o2;
			else return Math.abs(o1)-Math.abs(o2);
		});
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if (q.size() == 0)
					sb.append(0).append("\n");
				else {
					
					sb.append(q.peek()).append("\n");
					q.poll();
				}
			} else
				q.add(num);

		}
		System.out.println(sb);
	}

}
//https://www.acmicpc.net/problem/11286