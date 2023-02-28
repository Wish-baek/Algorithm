import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze1236 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] arr = new char[n][m];

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int rcnt = 0;
		int ccnt = 0;
		for (int i = 0; i < n; i++) {
			boolean check = false;
			for (int j = 0; j < m; j++) {
				if(arr[i][j]=='X') check =true;
			}
			if(check==false) rcnt++;
		}
		for (int i = 0; i < m; i++) {
			boolean check = false;
			for (int j = 0; j < n; j++) {
				if(arr[j][i]=='X') check =true;
			}
			if(check==false) ccnt++;
		}
		
		System.out.println(Math.max(rcnt,  ccnt));
	}

}
//https://www.acmicpc.net/problem/1236