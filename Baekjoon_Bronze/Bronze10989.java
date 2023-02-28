import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Bronze10989 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.valueOf(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < n; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}

}
//https://www.acmicpc.net/problem/10989