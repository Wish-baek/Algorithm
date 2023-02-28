import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Silver11004 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		str = br.readLine();
		StringTokenizer st;
		st = new StringTokenizer(str, " ");

		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		
		str = br.readLine();
		st = new StringTokenizer(str, " ");

		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(Integer.valueOf(st.nextToken()));
		}

		Collections.sort(arr);
		
		System.out.println(arr.get(K-1));

	}

}
//https://www.acmicpc.net/problem/11004
