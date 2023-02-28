import java.util.Scanner;

public class Bronze1712 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
		
		long sum = A;
		long get = 0;
		int count = 0;
		
		if(B>=C) {
			System.out.println(-1);
			System.exit(0);
		}
		
		while(true) {
			if(sum<get) {
				System.out.println(count);
				break;
			}
			
			sum+=B;
			get+=C;
			count++;
			
		}
		
	}

}
