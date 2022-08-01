import java.util.Scanner;

public class Bronze2153 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alpha = a.toCharArray();
		
		String str = sc.next();
		int sum = 0;
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < alpha.length; j++) {
				if(str.charAt(i)==alpha[j]) sum+=j+1;
			}
		}
		int count=0;
		for(int i = 2; i < sum; i++) {
			if(sum%i==0)  count++;
		}
		
		if(count==0) System.out.println("It is a prime word.");
		else System.out.println("It is not a prime word.");
	}

}
