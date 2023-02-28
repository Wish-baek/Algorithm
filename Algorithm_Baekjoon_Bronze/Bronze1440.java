import java.util.Scanner;

public class Bronze1440 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] arr = sc.next().split(":");
		String[][] tmp = { {arr[0], arr[1], arr[2]},
							{arr[0], arr[2], arr[1]},
							{arr[1], arr[0], arr[2]},
							{arr[1], arr[2], arr[0]},
							{arr[2], arr[0], arr[1]},
							{arr[2], arr[1], arr[0]},
						 };
		
		int count = 0;
		for(int i = 0; i < tmp.length; i++) {
			
		
			if( Integer.parseInt(tmp[i][0])>=1 && Integer.parseInt(tmp[i][0])<=12 &&
					Integer.parseInt(tmp[i][1])>=0 && Integer.parseInt(tmp[i][1])<=59 &&
							Integer.parseInt(tmp[i][2])<=59) {
				
				count++;
			}
			
		}
		System.out.println(count);
		
	}

}
