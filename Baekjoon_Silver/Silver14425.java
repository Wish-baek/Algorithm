import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Silver14425 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(list.contains(str)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
//https://www.acmicpc.net/problem/14425