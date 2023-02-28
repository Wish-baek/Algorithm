import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver3273 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int X = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int cnt = 0;
		int start = 0;
		int end = N - 1;
		int sum = 0;
		while (start < end) {
			sum = arr[start]+arr[end];
			if(sum==X)cnt++;
			if(sum<X) start++;
			else end--;
		}
		
		System.out.println(cnt);

	}

}
//https://www.acmicpc.net/problem/3273