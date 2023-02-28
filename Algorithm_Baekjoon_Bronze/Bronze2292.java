import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze2292 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		if(n==1) {
			System.out.println(1);
			System.exit(0);
		}
		
		int count = 2;
		int tmp = 1;
		int add = 1;
		while(true) {
			if( n <= (6*tmp+1) ) {
				break;
			}
			else {
				count++;
				add++;
				tmp+=add;
			}
			
		}
		System.out.println(count);
	}

}
//https://www.acmicpc.net/problem/2292