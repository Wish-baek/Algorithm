import java.util.Scanner;

public class Bronze1212 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] num = sc.next().split("");
		
		String str = "";
		if(Integer.parseInt(num[0])==0) {
			System.out.println(0);
			System.exit(0);
		}
		while(Integer.parseInt(num[0])>0) {
			
			str = Integer.toString(Integer.parseInt(num[0])%2)+str;
			
			num[0] = Integer.toString(Integer.parseInt(num[0])/2);
		}
		
		System.out.print(str);
	
		for(int i = 1 ; i < num.length; i++) {
			String a = "";
			if(Integer.parseInt(num[i])==0) a = "0";
			else {
			while(Integer.parseInt(num[i])>0) {
				
					a = Integer.toString(Integer.parseInt(num[i])%2)+a;
				
					num[i] = Integer.toString(Integer.parseInt(num[i])/2);
				}
			
			}
			if(a.length()==3) System.out.print(a);
			else if(a.length()==2) System.out.print( "0" + a);
			else System.out.print("00" + a);
			
		}
		
		
	}

}
