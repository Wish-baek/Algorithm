import java.util.Scanner;

public class Bronze10178 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.printf("You get %d piece(s) and your dad gets %d piece(s).", a/b, a%b);
			System.out.println();
		}
		
	}

}
