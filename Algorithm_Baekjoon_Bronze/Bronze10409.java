import java.util.Scanner;

public class Bronze10409 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			t-=a;
			
			if(t<=0) break;
			count++;
		}
		System.out.println(count);
	}

}
