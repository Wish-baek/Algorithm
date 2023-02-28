import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Silver2751 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.valueOf(br.readLine());
		ArrayList<BigInteger> arr = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			arr.add(new BigInteger(str));
		}
		Collections.sort(arr);
		for(int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i) + "\n");
		}
		System.out.println(sb);
	}

}
//https://www.acmicpc.net/problem/2751