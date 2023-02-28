import java.util.Scanner;
import java.math.*;
public class Bronze2721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			
		
			int result = 0;
			int n = sc.nextInt();
			for(int j = 1; j <= n; j++) {
				int sum = 0;
				for(int k = 1; k<=j+1; k++) {
					sum+=k;
				}
				result+=j*sum;
			}
			System.out.println(result);
		}
		
	}

}
