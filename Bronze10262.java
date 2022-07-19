import java.util.Scanner;
public class Bronze10262 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int b = 0;
		for(int i = 0; i < 4; i++) {
			a+=sc.nextInt();
		}
		for(int i = 0; i < 4; i++) {
			b+=sc.nextInt();
		}
		if(a>b) System.out.println("Gunnar");
		else if(a<b) System.out.println("Emma");
		else System.out.println("Tie");
	}

}
