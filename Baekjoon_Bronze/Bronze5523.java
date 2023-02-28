import java.util.*;
import java.util.Scanner;

public class Bronze5523 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int a = 0;
		int b = 0;
		for(int i = 0; i < t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(x>y) a++;
			else if(y>x) b++;
		}
		System.out.println(a + " " + b);
	}
}