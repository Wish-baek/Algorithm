import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Silver11728 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		str = br.readLine();
		StringTokenizer st;
		st = new StringTokenizer(str, " ");
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		
		str = br.readLine();
		st = new StringTokenizer(str, " ");
		
		for(int i = 0; i < N; i++) {
			arr.add(Integer.valueOf(st.nextToken()));
		}
		
		str = br.readLine();
		st = new StringTokenizer(str, " ");
		
		for(int i = 0; i < M; i++) {
			arr2.add(Integer.valueOf(st.nextToken()));
		}
		arr.addAll(arr2);
		
		Collections.sort(arr);
		
		for(int n : arr) {
			sb.append(n).append(" ");
		}
		System.out.println(sb);
		
	}

}
//https://www.acmicpc.net/problem/11728