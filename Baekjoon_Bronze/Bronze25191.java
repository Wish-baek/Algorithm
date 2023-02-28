import java.util.Scanner;
public class Bronze25191 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int sum = A/2 + B;
		System.out.println((int)Math.min(sum, N));
		
	}

}
