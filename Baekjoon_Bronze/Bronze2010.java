import java.util.Scanner;
public class Bronze2010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum+=sc.nextInt();
			sum-=1;
		}
		System.out.println(sum+1);
	}

}
