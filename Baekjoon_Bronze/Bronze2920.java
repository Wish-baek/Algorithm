import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze2920 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int[] arr = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int cnt = 0;
		int cnt2 = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1] + 1)
				cnt++;
			else if (arr[i] == arr[i - 1] - 1)
				cnt2++;
		}
		if(cnt==7) System.out.println("ascending");
		else if(cnt2==7) System.out.println("descending");
		else System.out.println("mixed");
	}
}
//https://www.acmicpc.net/problem/2920