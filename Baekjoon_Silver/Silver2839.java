import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Silver2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				if(5*i + 3*j==n) arr.add(i+j);
			}
		}
		Collections.sort(arr);
		
		if(arr.size()==0)System.out.println(-1);
		else System.out.println(arr.get(0));
	}

}
//https://www.acmicpc.net/problem/2839