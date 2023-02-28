import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1105 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String[] l = st.nextToken().split("");
		String[] r = st.nextToken().split("");
		
		int cnt = 0;
		if(l.length==r.length) {
			for(int i = 0; i < l.length; i++) {
				if(Integer.parseInt(l[i])==8 && Integer.parseInt(l[i])==Integer.parseInt(r[i])) cnt++;
				else if(Integer.parseInt(l[i])!=Integer.parseInt(r[i])) break;
			}
		}
		
		System.out.println(cnt);
	}
}
//https://www.acmicpc.net/problem/1105