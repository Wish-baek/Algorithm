import java.util.Scanner;

public class Bronze15734 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int R = sc.nextInt();
		int A = sc.nextInt();
		
		if(L>R) {
			int diff = L-R;
			if(diff>A) System.out.println(Math.min(R+A, L)*2);
			else if(diff<A) System.out.println(L*2 + (A-diff)/2*2);
			else System.out.println(L*2);
		}
		else if(L<R) {
			int diff = R-L;
			if(diff>A) System.out.println(Math.min(L+A, R)*2);
			else if(diff<A) System.out.println(R*2 + (A-diff)/2*2);
			else System.out.println(R*2);
		}
		else {
			System.out.println(R+L+(A/2)*2);
		}
	}

}
