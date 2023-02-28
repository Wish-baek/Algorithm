import java.util.Scanner;

public class Bronze1731 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		if(arr[1]-arr[0] == arr[2]-arr[1]) {
			System.out.println(arr[n-1]+arr[2]-arr[1]);
		}
		else if(arr[1]/arr[0] == arr[2]/arr[1]) {
			System.out.println(arr[n-1]*(arr[2]/arr[1]));
		}
		
	}

}
