import java.util.Scanner;

public class Bronze2154 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			sb.append(Integer.toString(i));
		}
		
		System.out.println(sb.indexOf(Integer.toString(n))+1);
		
	}

}
