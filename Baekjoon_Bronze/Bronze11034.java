import java.util.Scanner;

public class Bronze11034 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			
			int d = sc.nextInt();
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			
			if(d+n*p < n*s) System.out.println("parallelize");
			else if(d+n*p > n*s) System.out.println("do not parallelize");
			else System.out.println("does not matter");
		}
		
	}

}
