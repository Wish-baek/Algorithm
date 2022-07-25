import java.util.Scanner;

public class Bronze1009 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		int n = sc.nextInt();
		for(int k = 0; k < n; k++) {
			
			int a = sc.nextInt(); //2
			int b = sc.nextInt(); //3
			
			int tmp = a;
			
			for(int i = 0; i < b-1; i++){
				a*=tmp;
				if(a>100000) a%=100000;
			}
			switch(a%10) {
			case 1:
				System.out.println(1);
				break;
			case 2:
				System.out.println(2);
				break;
			case 3:
				System.out.println(3);
				break;
			case 4:
				System.out.println(4);
				break;
			case 5:
				System.out.println(5);
				break;
			case 6:
				System.out.println(6);
				break;
			case 7:
				System.out.println(7);
				break;
			case 8:
				System.out.println(8);
				break;
			case 9:
				System.out.println(9);
				break;
			case 0:
				System.out.println(10);
				break;
			}
			
		}
		
		
	}

}
