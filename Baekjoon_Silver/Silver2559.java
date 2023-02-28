import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver2559 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+2];
		arr[0] = arr[N+1]=0;
		st = new StringTokenizer(br.readLine(), " ");
		
		int sum = 0;
		for(int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i<=K) {
				sum+=arr[i];
			}
		}
		int max = sum;
		for(int i = 2; i < N-K+2; i++) {
			
			sum-=arr[i-1];
			sum+=arr[i+K-1];
			max = Math.max(max,  sum);
		}
		System.out.println(max);
	}
}
//https://www.acmicpc.net/problem/2559