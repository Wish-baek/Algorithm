import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Silver1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());

		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			arr.add(i);
		}
		sb.append("<");
		int index = K - 1;
		while(true) {
			
			result.add(arr.get(index));
			if(result.size()==N) break;
			arr.remove(index);
			index += (K - 1);
			if (index >= arr.size()) {
				while (index >= arr.size()) {
					index -= arr.size();
				}
			}
			
		}

		for(int i = 0; i < N-1; i++) {
			sb.append(result.get(i)).append(", ");
		}
		sb.append(result.get(result.size()-1)).append(">");
		System.out.println(sb);
	}

}
//https://www.acmicpc.net/problem/1158