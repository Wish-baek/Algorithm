import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Silver1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		int result=0;
		for(int i = 0; i < n; i++) {
			int cnt = 0;
			String str = br.readLine();
		
			for(int j = 0; j < str.length(); j++) {
				for(int k = str.indexOf(str.charAt(j)); k < j ;k++) {
					if(str.charAt(j)!=str.charAt(k)) cnt++;
				}
			}
			if(cnt==0) result++;
		}
		
		System.out.println(result);
	}

}
//https://www.acmicpc.net/problem/1316