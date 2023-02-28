import java.util.*;

public class Bronze1100 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[8][8];
		char[][] chess = new char[8][8];
		for(int i = 0; i <8; i++) {
			for(int j = 0; j <8; j++) {
				if( i%2==0 ) {
					if(j%2==0) arr[i][j]=0;
					else arr[i][j]=1;
					
				}
				
				else {
					if(j%2==1) arr[i][j]=0;
					else arr[i][j]=1;
				}
			}
		}
		int count = 0;
		for(int i = 0; i < 8; i++) {
			String a = sc.next();
			for(int j = 0; j < 8; j++) {
				chess[i][j] = a.charAt(j);
				if(chess[i][j]=='F' && arr[i][j]==0) count++;
			}
		}
		
		System.out.print(count);
		
	}

}
