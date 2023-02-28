import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Silver1065 {

	public static void hansu(int n) {
		if(n<100) {
			System.out.println(n);
			System.exit(0);
		}
		
		int cnt = 2;
		for(int i = 3; i <= n; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			int tmp = i;
			while(tmp>0){
				arr.add(tmp%10);
				tmp/=10;
			}
			
			int count = 0;
			if(arr.size()==1) cnt++;
			else {
				
				int diff = arr.get(0)-arr.get(1);
				for(int j = 1; j < arr.size()-1; j++) {
					if(arr.get(j)-arr.get(j+1)!=diff) count++;
				}
				if(count==0) cnt++; 
			}
			
			
			
			
		}
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		hansu(n);
	}

}
