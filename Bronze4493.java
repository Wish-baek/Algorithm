import java.util.Arrays;
import java.util.Scanner;

public class Bronze4493 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int k = 0; k < T; k++) {
			int n = sc.nextInt();
			int A = 0;
			int B = 0;
			for(int i = 0; i < n; i++) {
				String a = sc.next();
				String b = sc.next(); 
				if((a.equals("R") && b.equals("S")) ||(a.equals("P") && b.equals("R")) ||
						(a.equals("S") && b.equals("P"))) A++;
				else if ((b.equals("R") && a.equals("S")) ||(b.equals("P") && a.equals("R") ||
						(b.equals("S") && a.equals("P")))) B++;
				
			}

			if(A>B) System.out.println("Player 1");
			else if(B>A) System.out.println("Player 2");
			else System.out.println("TIE");
		}
	}

}
