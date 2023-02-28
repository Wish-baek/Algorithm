import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver11660 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.valueOf(tmp[0]);
		int M = Integer.valueOf(tmp[1]);

		int[][] arr = new int[N+1][N+1];

		arr[0][0] = 0;
		
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + Integer.valueOf(st.nextToken());
			}
			
		}
		for (int i = 1; i <= M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.valueOf(st2.nextToken());
			int y1 = Integer.valueOf(st2.nextToken());
			int x2 = Integer.valueOf(st2.nextToken());
			int y2 = Integer.valueOf(st2.nextToken());
			sb.append(arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1] + "\n");
			
		}
		System.out.println(sb);
	}

}
//https://www.acmicpc.net/problem/11659