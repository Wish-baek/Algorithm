import java.util.Scanner;
public class Bronze2460 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int max = 0;
		for(int i = 0; i < 10; i++) {
			a-=sc.nextInt();
			if(a>max) max = a;
			a+=sc.nextInt();
			if(a>max) max = a;
		}
		System.out.println(max);
	}

}
