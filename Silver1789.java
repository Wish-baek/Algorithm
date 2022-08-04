import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver1789 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.valueOf(br.readLine());
		
		if(S==1) {
			System.out.println(1);
			System.exit(0);
		}
		
		long sum = 0;
		long cnt = 0;
		for(long i = 1; i < S; i++) {
			sum+=i;
			cnt++;
			if(sum>S) {
				break;
			}
		}
		System.out.println(cnt-1);
		
	}

}
//https://www.acmicpc.net/problem/1789