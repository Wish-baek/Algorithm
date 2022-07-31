import java.util.Scanner;

public class Bronze1864 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			String[] s_arr = sc.next().split("");
			if(s_arr[0].equals("#")) System.exit(0);
			
			int[] arr = new int[s_arr.length];
			for(int i = 0; i < arr.length; i++) {
				switch(s_arr[i]) {
					case "-":
						arr[i] = 0;
						break;
					case "\\":
						arr[i] = 1;
						break;
					case "(":
						arr[i] = 2;
						break;
					case "@":
						arr[i] = 3;
						break;
					case "?":
						arr[i] = 4;
						break;
					case ">":
						arr[i] = 5;
						break;
					case "&":
						arr[i] = 6;
						break;
					case "%":
						arr[i] = 7;
						break;
					case "/":
						arr[i] = -1;
						break;
				}
			}
			
			int tmp = 0;
			int sum = 0;
			
			for(int i = arr.length-1; i >= 0; i--) {
				sum += Math.pow(8, tmp) * arr[i];
				tmp++;
			}
			System.out.println(sum);
		}
		
	}

}
