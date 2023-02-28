import java.util.Scanner;

public class Bronze2139 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			
			int date = sc.nextInt();
			int month = sc.nextInt();
			int year = sc.nextInt();
			
			if(date==0 && month==0 && year==0) break;
			
			int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			
			if(((year%4)==0 && (year%100)==0 && (year%400)==0)) arr[1]=29;
			else if((year%4)==0 && (year%100)==0 ) arr[1]=28;
			else if(year%4==0) arr[1]=29;
			
			int sum = 0;
			
			for(int i = 0; i < month-1; i++) {
				sum+=arr[i];
			}
			sum+=date;
			System.out.println(sum);
			
		}
		
	}

}
