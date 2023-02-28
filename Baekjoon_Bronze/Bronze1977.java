import java.util.ArrayList;
import java.util.Scanner;

public class Bronze1977 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		int M = sc.nextInt();
		int N = sc.nextInt();
		int sum = 0;
		for(int i = M; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				if(j*j==i) {
					arr.add(i);
					sum+=i;
				}
			}
		}
		if(arr.size()>0) {
			System.out.println(sum);
			System.out.println(arr.get(0));
		}
		else System.out.println(-1);
	}

}
