import java.util.*;
import java.util.Scanner;

public class Bronze5565 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		for(int i = 0; i < 9; i++) {
			sum-=sc.nextInt();
		}
		System.out.println(sum);
	}
}


