import java.util.Scanner;

public class Bronze10984 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		for(int i = 0; i < k; i++) {
			int n = sc.nextInt();
			double sum = 0;
			double count = 0;
			for(int j = 0; j < n; j++) {
				double c = sc.nextDouble();
				double g = sc.nextDouble();
				sum += c*g;
				count += c;
				
			}
			System.out.printf("%d %.1f",(int)count,sum/count);
			System.out.println();
		}
		
	}

}
