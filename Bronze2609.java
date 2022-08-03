import java.util.Scanner;

public class Bronze2609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int x = 1;
		int y = 1;
		for(int i = 2; i <= Math.min(a, b); i++) {
			if(a%i==0 && b%i==0) x = i;
		}
		
		for(int i = b; i <= a*b; i++) {
			if(i%a==0 && i%b==0) {
				y = i;
				break;
			}
		}
		System.out.println(x);
		System.out.println(y);
	}

}
