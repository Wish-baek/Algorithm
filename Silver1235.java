import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Silver1235 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] str = new String[N];

		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}

		int len = str[0].length();
		
		for (int i = 1; i <= str[0].length(); i++) {
			List<String> list = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				String tmp = str[j].substring(len - i, len);
				if (!list.contains(tmp))
					list.add(tmp);
			}
			if (list.size() == N) {
				System.out.println(i);
				break;
			}
		}
	}
}
//https://www.acmicpc.net/problem/1235