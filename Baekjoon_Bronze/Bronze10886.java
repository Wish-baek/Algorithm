import java.util.Scanner;

public class Bronze10886 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int y = 0;
		int n = 0;
		for(int i = 0; i < k; i++){
			if(sc.nextInt()==1) y++;
			else n++;
		}
		if(y>n) System.out.println("Junhee is cute!");
		else System.out.println("Junhee is not cute!");
	}

}
