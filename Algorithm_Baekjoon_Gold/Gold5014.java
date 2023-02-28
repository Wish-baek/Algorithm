import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold5014 {
	static int min, F, S, G, U, D;
	static int[] floor;
	static boolean check;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(st.nextToken()); // 총 층 개수
		S = Integer.parseInt(st.nextToken()); // 현재 층
		G = Integer.parseInt(st.nextToken()); // 이동할 층
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		floor = new int[F+1];
		
		bfs(S);
		if(floor[G]==0) System.out.println("use the stairs");
		else System.out.println(floor[G]-1);
	}
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		floor[start] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur==G) return;
			
			if(cur+U<=F && floor[cur+U]==0){
				q.offer(cur+U);
				floor[cur+U] = floor[cur]+1;
			}
			
			if(cur-D>0 && floor[cur-D]==0){
				q.offer(cur-D);
				floor[cur-D] = floor[cur]+1;
			}
		}	
	}
}
//https://www.acmicpc.net/problem/5014