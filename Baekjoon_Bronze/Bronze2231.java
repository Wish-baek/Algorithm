import java.util.Scanner;

public class Bronze2231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			
			int tmp = i;
			int sum = 0;
			sum+=tmp;
			while(tmp>0) {
				sum+=tmp%10;
				tmp/=10;
			}
			
			if(sum==n) {
				System.out.println(i);
				System.exit(0);
			}
			
		}
		System.out.println(0);
		
	}

}
