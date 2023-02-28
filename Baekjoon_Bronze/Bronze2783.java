import java.util.Arrays;
import java.util.Scanner;

public class Bronze2783 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();

		int n = sc.nextInt();
		double[] arr = new double[n];

		for(int i = 0; i < n; i++) {
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			arr[i] = 1000/b*a;
			
		}
		
		Arrays.sort(arr);
		System.out.printf("%.2f", Math.min(arr[0], 1000/y*x));
	}

}
