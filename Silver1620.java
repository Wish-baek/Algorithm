import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Silver1620 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		String[] str = new String[N+1];
		
		for(int i = 1; i <= N; i++) {
			String name = br.readLine();
			map.put(name, i);
			str[i] = name;
		}
		
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			if(Character.isDigit(s.charAt(0))) {
				int index = Integer.parseInt(s);
				sb.append(str[index]);
			}
			else {
				sb.append(map.get(s));
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

}
//https://www.acmicpc.net/problem/1620