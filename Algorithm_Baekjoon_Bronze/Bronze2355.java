import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Bronze2355 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long result;
		if (b > a) {
			result = (a + b)  * (b - a + 1)/ 2;
		} else
			result = (b + a)  * (a - b + 1)/ 2;
		bw.write(result + "");
		bw.close();
	}

}
//https://www.acmicpc.net/problem/2355