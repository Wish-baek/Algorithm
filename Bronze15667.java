import java.util.Scanner;
public class Bronze15667 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		for(int i = 1; i<k; i++) {
			if(i*i+i+1==k) System.out.println(i);
		}
		
	}

}
