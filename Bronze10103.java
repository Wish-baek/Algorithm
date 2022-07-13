import java.util.Scanner;

public class Bronze10103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int A = 100;
		int B = 100;
		for(int i = 0; i < n; i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a>b) B-=a;
			else if(a<b) A-=b;
			
		}
		System.out.println(A);
		System.out.println(B);
	}

}
