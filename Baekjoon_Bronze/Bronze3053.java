import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze3053 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double R = Integer.parseInt(br.readLine());

		System.out.printf("%.6f\n", R*R * Math.PI);
		System.out.printf("%.6f",R*R*2);
	}

}
//https://www.acmicpc.net/problem/3053