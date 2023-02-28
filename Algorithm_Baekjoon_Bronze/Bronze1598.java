import java.util.Scanner;
public class Bronze1598 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int max = Math.max(a,  b);
		int min = Math.min(a,  b);
		
		if(max%4==0 && min%4==0) System.out.println(max/4-min/4);
		else if(max%4==0) System.out.println((max/4-1) - min/4 + (max%4+4) - min%4);
		else if(min%4==0) System.out.println((max/4 - (min/4-1)) + Math.abs((max%4) - (min%4+4)));
		else System.out.println(max/4-min/4 + Math.max(max%4,  min%4)-Math.min(max%4,  min%4));
							// 10/4-7/4 + 10%4+7%4
		
		
	}

}
