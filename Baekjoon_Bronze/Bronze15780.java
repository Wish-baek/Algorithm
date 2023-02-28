import java.util.Scanner;

public class Bronze15780 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int sum = 0;
		for(int i = 0; i < K; i++) {
			int n = sc.nextInt();
			if(n%2==0) sum+=n/2;
			else if(n%2==1) sum+=n/2+1;
		}
		if(sum>=N) System.out.println("YES");
		else if(sum<N) System.out.println("NO");
	}

}
