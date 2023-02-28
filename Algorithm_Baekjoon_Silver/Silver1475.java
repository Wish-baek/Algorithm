import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Silver1475 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[10];
		int cnt = 0;
		
		ArrayList<Integer> num = new ArrayList<>();
		
		while(n>0) {
			num.add(n%10);
			n/=10;
		}
		
		
		for(int i = 0; i < num.size(); i++) {
			arr[num.get(i)]++;
		}
		int tmp = arr[6]+arr[9];
		
		arr[6] = tmp/2;
		arr[9] = tmp/2 + tmp%2;
		
		Arrays.sort(arr);
		System.out.println(arr[9]);
	}

}
//https://www.acmicpc.net/problem/1475