import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold17609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[] str;
		for (int i = 0; i < N; i++) {
			str = br.readLine().toCharArray();
			System.out.println(check(str));
		}
	}

	static int check(char[] str) {
		int aP = 0;
		int bP = str.length - 1;
		boolean isPseudo = false;
		boolean isLeft = true;
		boolean isRight = true;

		int aP2 = 0;
		int bP2 = str.length - 1;

		while (true) {
			if (!isLeft && !isRight)
				break;

			if (!isPseudo) { // 문자 삭제 안 했다면
				if (aP >= bP)
					break;
				if (str[aP] == str[bP]) { // 문자 같으면 포인터 이동
					aP++;
					bP--;
				} else { // 다르면 포인터 두개로 나누기
					aP2 = aP;
					bP2 = bP;
					bP--; // aP, bP는 오른쪽 문자 삭제
					aP2++; // aP2, bP2는 왼쪽 문자 삭제
					isPseudo = true;
				}
			} else {

				if (isRight) {
					if (str[aP] == str[bP]) {
						aP++;
						bP--;
						if (aP >= bP)
							break;
					} else
						isRight = false;
				}

				if (isLeft) {
					if (str[aP2] == str[bP2]) {
						aP2++;
						bP2--;
						if (aP2 >= bP2)
							break;
					} else
						isLeft = false;
				}

			}

			if (!isLeft && !isRight)
				return 2;
		}

		if (isPseudo && (isLeft || isRight))
			return 1;
		else
			return 0;
	}

}

// https://www.acmicpc.net/problem/17609