import java.util.Scanner;
import java.util.Arrays;
public class Bronze2476 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int sum=0;
			if(a==b && b==c) arr[i] = 10000+a*1000;
			else if(a==b) arr[i] = 1000+a*100;
			else if(b==c) arr[i] = 1000+b*100;
			else if(a==c) arr[i] = 1000+c*100;
			else arr[i] = Math.max(Math.max(a,  b), c)*100;
		}
		Arrays.sort(arr);
		System.out.println(arr[arr.length-1]);
	}

}
