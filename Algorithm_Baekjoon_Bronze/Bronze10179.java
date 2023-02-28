import java.util.Scanner;

public class Bronze10179 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			double a = sc.nextDouble();
			System.out.printf("$%.2f",a/100*80);
			System.out.println();
		}
		
	}

}
