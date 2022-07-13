import java.util.Scanner;

public class Bronze11134 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i <t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a%b==0) System.out.println(a/b);
			else System.out.println(a/b+1);
		}
	}

}
