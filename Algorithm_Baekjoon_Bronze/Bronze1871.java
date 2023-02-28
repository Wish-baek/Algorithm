import java.util.Scanner;

public class Bronze1871 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			String[] arr = sc.next().split("-");
			int right = Integer.valueOf(arr[1]);
			
			String[] arr2 = arr[0].split("");
			
			String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
			
			int left = 0;
			int num = 0;
			for(int j = arr2.length-1; j >= 0; j--) {
				for(int k = 0; k < alpha.length; k++) {
					if(arr2[j].equals(alpha[k])) {
						left+= Math.pow(26, num) * k;
						num++;
					}
				}
			}
			if(Math.abs(left-right)<=100) System.out.println("nice");
			else System.out.println("not nice");
			
		}
		
		
		
	}

}
