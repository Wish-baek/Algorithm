import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int rear  = -1;
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			if(str[0].equals("push")) {
				q.add(Integer.parseInt(str[1]));
				rear = Integer.parseInt(str[1]);
			}
			else if(str[0].equals("pop")) {
				if(q.isEmpty()) sb.append("-1").append("\n");
				else sb.append(q.poll()).append("\n");
			}
			else if(str[0].equals("size")) {
				sb.append(q.size()).append("\n");
			}
			else if(str[0].equals("empty")) {
				if(q.isEmpty()) sb.append("1").append("\n");
				else sb.append("0").append("\n");
			}
			else if(str[0].equals("front")) {
				if(q.isEmpty()) sb.append("-1").append("\n");
				else sb.append(q.peek()).append("\n");
			}
			else if(str[0].equals("back")) {
				if(q.isEmpty()) sb.append("-1").append("\n");
				else sb.append(rear).append("\n");
			}
		}
		System.out.println(sb);

	}
}
//https://www.acmicpc.net/problem/18258