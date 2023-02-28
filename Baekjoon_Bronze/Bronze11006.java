import java.util.Scanner;

public class Bronze11006 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		for(int i = 0; i < k; i++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int leg = m*2;
			System.out.println( n%2 + " " + Math.max(n/2, m/2) );
			
		}
		
	}

}
