import java.util.Scanner;

public class Bronze1075 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double N = sc.nextDouble();
		double F = sc.nextDouble();
		int x = 0;
		N -= N%100;
		while(true) {
			
			if((N+x) % F==0) {
				
				System.out.printf("%02d",x);
				System.exit(0);
			}
			x++;
		}
		
	}

}
