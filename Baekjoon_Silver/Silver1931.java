import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Silver1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Integer[][] arr = new Integer[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				
				if(o1[1]==o2[1]) return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < 2; j++) {
//				System.out.print(arr[i][j]);
//			}System.out.println();
//		}
//		
		int cnt = 1;
		int end = arr[0][1];
		for(int i = 1; i < N; i++) {
			if(end<=arr[i][0]) {
				cnt++;
				end = arr[i][1];
			}
			
		}
		System.out.println(cnt);
		
	}

}
//https://www.acmicpc.net/problem/1931