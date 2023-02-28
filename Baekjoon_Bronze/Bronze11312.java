import java.util.Scanner;

public class Bronze11312 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println((int)Math.pow(a/b, 2));
			
		}
	}

}
