import java.util.Scanner;
public class Bronze1350 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] arr = new long[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		long P = sc.nextLong();
		long count = 0;
		
		for(int i = 0; i < N; i++) {
			count += arr[i]/P;
			if(arr[i]%P > 0) {
				count++;
			}
		}
		System.out.println(count*P);
		
	}

}
