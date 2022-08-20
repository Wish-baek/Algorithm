import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3036 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int ring = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N - 1; i++) {
			int n = Integer.parseInt(st.nextToken());
			int max = Math.max(ring, n);
			int min = Math.min(ring,  n);
			
			int num = eucd(max, min);
			
			System.out.println(ring/num + "/" +n/num);
		}

	}
	public static int eucd(int bn, int sn) {
        int r = bn % sn;
        if (r == 0) {
            return sn;
        } else {
            return eucd(sn, r);
        }
    }

}
//https://www.acmicpc.net/problem/3036