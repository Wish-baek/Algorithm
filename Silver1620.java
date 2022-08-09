import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Silver1620 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Map<Integer, Integer> map = new HashMap<>();
		int M= Integer.parseInt(br.readLine());
		int[] arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr2[i] = tmp;
			map.put(tmp, 0);
		}
		for(int i = 0; i < N; i++) {
			if(map.containsKey(arr[i])) {
				map.replace(arr[i],map.get(arr[i])+1);
			}
		}
		for( int num : arr2 ) {
			sb.append(map.get(num)).append(" ");
		}
		System.out.println(sb);
	}

}
//https://www.acmicpc.net/problem/10816