import java.util.Scanner;

public class Bronze1773 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] student = new int[N];
		
		for(int i = 0; i < N; i++) {
			student[i] = sc.nextInt();
		}
		
		int count = 0;
		
		for(int i = 1; i <=C; i++) {
			for(int j = 0; j < N;j++) {
				if(i%student[j]==0) {
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
	}

}
