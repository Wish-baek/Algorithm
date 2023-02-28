import java.util.Scanner;

public class Bronze23303 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.nextLine();
		
		if(a.indexOf("d2")>=0 || a.indexOf("D2")>=0) System.out.println("D2");
		else System.out.println("unrated");
	}

}
//https://www.acmicpc.net/problem/23303