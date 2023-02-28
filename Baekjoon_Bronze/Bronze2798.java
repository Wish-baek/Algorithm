import java.util.Scanner;

public class Bronze2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				for(int k = j+1; k < N; k++) {
					if(arr[i]+arr[j]+arr[k] > max && arr[i]+arr[j]+arr[k] <= M) max = arr[i]+arr[j]+arr[k];
				}
			}
		}
		System.out.println(max);
		
	}

}
//https://www.acmicpc.net/problem/2798