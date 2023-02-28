import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1074 {
	static int cnt, N, r, c;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		divide(r, c, (int) Math.pow(2, N));
		System.out.println(cnt);
	}

	static void divide(int r, int c, int size) {
		if (size == 1)
			return;
		if (r < size / 2 && c < size / 2)
			divide(r, c, size / 2);
		else if (r < size / 2 && c >= size / 2) {
			cnt += size * size / 4;
			divide(r, c - size / 2, size / 2);
		}
		else if (r >= size / 2 && c < size / 2) {
			cnt += (size * size / 4) * 2;
			divide(r - size / 2, c, size / 2);
		} 
		else if (r >= size / 2 && c >= size / 2) {
			cnt += (size * size / 4) * 3;
			divide(r - size / 2, c - size / 2, size / 2);
		}

	}

}
//https://www.acmicpc.net/problem/1074