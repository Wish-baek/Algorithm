import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigInteger;
public class Bronze2903 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 0;
		int init = 2;
		for(int i = 1; i <= n; i++) {
			
			sum=init+init-1;
			init = sum;
			
		}
		System.out.println(sum*sum);
	}

}
