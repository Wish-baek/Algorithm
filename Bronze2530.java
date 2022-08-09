import java.util.Scanner;

public class Bronze2530 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int price = sc.nextInt();
		int t = sc.nextInt();
		int sum = 0;
		for(int i = 0; i < t; i++) {
			sum+=sc.nextInt()*sc.nextInt();
		}
		if(sum==price) System.out.println("Yes");
		else System.out.println("No");
		
	}

}
//https://www.acmicpc.net/problem/25304