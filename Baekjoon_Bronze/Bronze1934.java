import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze1934 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.valueOf(br.readLine());
		for (int t = 0; t < n; t++) {
			
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int yak=0;
			for(int i = Math.min(a, b); i >= 1; i--) {
				if(a%i==0 && b%i==0) {
					yak = i;
					break;
				}
			}
			sb.append(a*b/yak).append("\n");
		}
		System.out.println(sb);
	}

}
