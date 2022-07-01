import java.util.*;
public class Bronze1284 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String a = sc.next();
			char[] arr = a.toCharArray();
			if(arr.length==1 && arr[0]=='0') break;
			int sum = 2 + arr.length-1;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i]=='1') sum+=2;
				else if(arr[i]=='0') sum+=4;
				else sum+=3;
			}
			System.out.println(sum);
			
			
		}
		
	}

}
