import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold14891 {
	static ArrayList<Integer> magnet1, magnet2, magnet3, magnet4;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		magnet1 = new ArrayList<>();
		magnet2 = new ArrayList<>();
		magnet3 = new ArrayList<>();
		magnet4 = new ArrayList<>();
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();
		String str4 = br.readLine();

		for (int j = 0; j < 8; j++) {
			magnet1.add(str1.charAt(j) - '0');
			magnet2.add(str2.charAt(j) - '0');
			magnet3.add(str3.charAt(j) - '0');
			magnet4.add(str4.charAt(j) - '0');

		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()); // 1: 시계방향, -1: 반시계방향
			rotate(num, dir);
//			System.out.println(magnet1.toString());
//			System.out.println(magnet2.toString());
//			System.out.println(magnet3.toString());
//			System.out.println(magnet4.toString());
//			System.out.println();

		}
		int result = 0;
		if (magnet1.get(0) == 1)
			result++;
		if (magnet2.get(0) == 1)
			result += 2;
		if (magnet3.get(0) == 1)
			result += 4;
		if (magnet4.get(0) == 1)
			result += 8;

		System.out.print(result);
	}

	static void rotate(int num, int dir) {
		List<Integer> tmp1 = new ArrayList<>();
		List<Integer> tmp2 = new ArrayList<>();
		List<Integer> tmp3 = new ArrayList<>();
		List<Integer> tmp4 = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			tmp1.add(magnet1.get(i));
			tmp2.add(magnet2.get(i));
			tmp3.add(magnet3.get(i));
			tmp4.add(magnet4.get(i));
		}

		if (num == 1) {
			chainRotate(num, dir);

			if (tmp1.get(2) != tmp2.get(6)) {
				dir *= -1;
				chainRotate(2, dir);

				if (tmp2.get(2) != tmp3.get(6)) {
					dir *= -1;
					chainRotate(3, dir);

					if (tmp3.get(2) != tmp4.get(6)) {
						dir *= -1;
						chainRotate(4, dir);
					}
				}
			}
		}

		else if (num == 2) {
			chainRotate(num, dir);
			int dirtmp = dir;
			int dirtmp2 = dir;

			if (tmp1.get(2) != tmp2.get(6)) {
				dirtmp *= -1;
				chainRotate(1, dirtmp);
			}

			if (tmp2.get(2) != tmp3.get(6)) {
				dirtmp2 *= -1;
				chainRotate(3, dirtmp2);

				if (tmp3.get(2) != tmp4.get(6)) {
					dirtmp2 *= -1;
					chainRotate(4, dirtmp2);
				}
			}
		}

		else if (num == 3) {
			int dirtmp = dir;
			int dirtmp2 = dir;
			chainRotate(num, dir);
			if (tmp2.get(2) != tmp3.get(6)) {
				dirtmp *= -1;
				chainRotate(2, dirtmp);
				if (tmp1.get(2) != tmp2.get(6)) {
					dirtmp *= -1;
					chainRotate(1, dirtmp);
				}
			}
			if (tmp3.get(2) != tmp4.get(6)) {
				dirtmp2 *= -1;
				chainRotate(4, dirtmp2);
			}
		}

		if (num == 4) {
			chainRotate(num, dir);
			if (tmp3.get(2) != tmp4.get(6)) {
				dir *= -1;
				chainRotate(3, dir);
				if (tmp2.get(2) != tmp3.get(6)) {
					dir *= -1;
					chainRotate(2, dir);
					if (tmp1.get(2) != tmp2.get(6)) {
						dir *= -1;
						chainRotate(1, dir);
					}
				}
			}
		}
	}

	static void chainRotate(int num, int dir) {
		if (dir == 1) {
			if (num == 1) {
				int n = magnet1.get(7);
				magnet1.remove(7);
				magnet1.add(0, n);
			} else if (num == 2) {
				int n = magnet2.get(7);
				magnet2.remove(7);
				magnet2.add(0, n);
			} else if (num == 3) {
				int n = magnet3.get(7);
				magnet3.remove(7);
				magnet3.add(0, n);
			} else if (num == 4) {
				int n = magnet4.get(7);
				magnet4.remove(7);
				magnet4.add(0, n);
			}
		} else if (dir == -1) {
			if (num == 1) {
				int n = magnet1.get(0);
				magnet1.remove(0);
				magnet1.add(n);
			} else if (num == 2) {
				int n = magnet2.get(0);
				magnet2.remove(0);
				magnet2.add(n);
			} else if (num == 3) {
				int n = magnet3.get(0);
				magnet3.remove(0);
				magnet3.add(n);
			} else if (num == 4) {
				int n = magnet4.get(0);
				magnet4.remove(0);
				magnet4.add(n);
			}
		}
	}
}
//https://www.acmicpc.net/problem/14891