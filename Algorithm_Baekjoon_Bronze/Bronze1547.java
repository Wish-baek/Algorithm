import java.util.Scanner;
import java.util.Arrays;
public class Bronze1547 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] arr = {1, 2, 3};
		
		int i, j;
		for(i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int ax = Arrays.asList(arr).indexOf(a); //a 위치 검색 
			int bx = Arrays.asList(arr).indexOf(b); //b 위치 검색 
			arr[ax] = b; //a가 있는 위치 값을 b로 변경 
			arr[bx] = a; //b가 있는 위치 값을 a로 변경 
			
		}
		
		System.out.println(arr[0]);
	}

}

