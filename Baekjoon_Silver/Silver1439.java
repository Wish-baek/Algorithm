import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver1439 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split("");
		int[] arr = new int[s.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(s[i]);
		}
		
		int one = 0;
		int zero = 0;
		
		if(arr[0]==1) one++;
		else if(arr[0]==0) zero++;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i-1]==0 && arr[i] == 1) one++;
			if(arr[i-1]==1 && arr[i] == 0) zero++;
		}
		System.out.println(Math.min(one,  zero));
		

	}

}
