import java.util.Scanner;

public class Bronze1681 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr = sc.nextInt();
		int n = sc.nextInt();
		int count = 0;	// 학생 수 
		int label = 1;	// 라벨링 
		
		while(true) {
			int cnt = 0;	//1 포함 개수 카운트 
			int tmp = label;
			
			while(tmp>0) {
				int a = tmp%10;
				tmp/=10;
				if(a==n) {
					cnt++;
				}
				
			}
			
		
			if(cnt==0) {
				count++;
				
			}
			if(count==arr) break;
			label++;
			
		}
		System.out.println(label);
	}

}
