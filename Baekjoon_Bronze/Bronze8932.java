import java.util.*;

public class Bronze8932 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		double[][] arr = {{9.23076, 26.7, 1.835},
							{1.84523, 75, 1.348},
							{56.0211, 1.5, 1.05},
							{4.99087, 42.5, 1.81},
							{0.188807, 210, 1.41},
							{15.9803, 3.8, 1.04},
							{0.11193, 254, 1.88}};
		for(int i = 0; i < n; i++) {
			int sum = 0;
			int[] score = new int[7];
			for(int j = 0; j < 7; j++) {
				score[j] = sc.nextInt();
			}
			
			for(int k = 0; k < 7; k++) {
				if(k==0 || k==3 || k==6) {
					sum+=arr[k][0] * Math.pow(arr[k][1]-score[k], arr[k][2]);
				}
				else if(k==1 || k==2 || k==4 || k==5) {
					sum+=arr[k][0] * Math.pow(score[k]-arr[k][1], arr[k][2]);
				}
				
			}
			System.out.println(sum);
		}
		
	}

}
