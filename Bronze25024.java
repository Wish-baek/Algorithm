import java.util.*;
public class Bronze25024 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int k=0; k<T; k++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			if()
			if( x<24 && y<60) System.out.print("Yes");
			else System.out.print("No");
			
			System.out.print(" ");
			
			if(	(x==1 || x==3 || x==5 || x==7 || x==8 ||x==10 || x==12 ) && (y>0 && y <32) ){
				System.out.print("Yes");
			}
			else if(( x==4 || x==6 || x==9 || x==11 ) && (y>0 && y <31))
				System.out.print("Yes");
			else if(x==2 && y>0 && y<30) System.out.print("Yes");
			else System.out.print("No");
			
			System.out.println();
		}
		
	}

}
