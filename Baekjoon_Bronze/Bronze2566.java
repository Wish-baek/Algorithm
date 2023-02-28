import java.util.Scanner;
import java.math.*;
public class Bronze2566 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[9][9];
		int max = 0;
		int row = 0;
		int col = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]>max) {
					max = arr[i][j];
					row = i+1;
					col = j+1;
				}
			}
		}
		System.out.println(max);
		System.out.println(row + " " + col);
		
	}

}
