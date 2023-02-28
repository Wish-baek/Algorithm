import java.util.Arrays;
import java.util.Scanner;

public class Bronze2857 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count=0;
		for(int i = 0; i < 5; i++) {
			String a = sc.next();
			if (a.length()<3) continue;
			
			for(int j = 0; j < a.length()-2; j++) {
				if(a.charAt(j)=='F' && a.charAt(j+1)=='B' && a.charAt(j+2)=='I') {
					System.out.print((i+1) + " ");
					count++;
					break;
				}
			}
			
		}
		if (count==0) System.out.println("HE GOT AWAY!");
	}

}
