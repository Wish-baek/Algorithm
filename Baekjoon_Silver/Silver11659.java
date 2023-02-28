import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver11659 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.valueOf(tmp[0]);
		int M = Integer.valueOf(tmp[1]);
		
		String[] num = br.readLine().split(" ");
		int[] arr = new int[N+1];
		arr[0] = 0;
		
		for(int i = 1; i <= N; i++) {
			int x = Integer.valueOf(num[i-1]);
			arr[i] = arr[i-1]+x;
		}
		
		
		for(int i = 0; i < M; i++) {
			String[] tmp2 = br.readLine().split(" ");
			int a = Integer.valueOf(tmp2[0]);
			int b = Integer.valueOf(tmp2[1]);
			int sum = 0;
			
			sb.append(arr[b]-arr[a-1] + "\n");
			
			
			
		}
		System.out.println(sb);
		
	}

}
//https://www.acmicpc.net/problem/11659