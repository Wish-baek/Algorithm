import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver4659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		char ch;
		String moeum = "aeiou";

		loop: while (true) {
			str = br.readLine();
			if (str.equals("end"))
				break;

			if (str.indexOf('a') == -1 && str.indexOf('e') == -1 && str.indexOf('i') == -1 && str.indexOf('o') == -1
					&& str.indexOf('u') == -1) {
				sb.append("<").append(str).append("> is not acceptable.").append("\n");
				continue;
			}

			int type_cnt = 1;
			boolean isMoeum = moeum.indexOf(str.charAt(0)) == -1 ? false : true;

			int same_cnt = 1;
			char before = str.charAt(0);

			for (int i = 1; i < str.length(); i++) {
				ch = str.charAt(i);
				boolean tmp = moeum.indexOf(ch) == -1 ? false : true;

				if (tmp == isMoeum) { // 두 번째 조건 검사
					type_cnt++;
					if (type_cnt == 3) {
						sb.append("<").append(str).append("> is not acceptable.").append("\n");
						continue loop;
					}
				} else {
					isMoeum = tmp;
					type_cnt = 1;
				}

				if (ch != 'e' && ch != 'o' && ch == before) { // 세 번째 조건 검사
					same_cnt++;
					if (same_cnt == 2) {
						sb.append("<").append(str).append("> is not acceptable.").append("\n");
						continue loop;
					}
				} else {
					before = ch;
					same_cnt = 1;
				}
			}
			sb.append("<").append(str).append("> is acceptable.").append("\n");
		}
		System.out.println(sb);
	}
}
//https://www.acmicpc.net/problem/4659