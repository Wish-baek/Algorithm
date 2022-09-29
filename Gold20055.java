import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold20055 {
	static List<info> belt;
	static int N, K;

	static class info {
		boolean robot;
		int w;

		public info(boolean robot, int w) {
			this.robot = robot;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		belt = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N * 2; i++) {
			belt.add(new info(false, Integer.parseInt(st.nextToken())));
		}

		int round = 1;

		while (true) {
			if (endCheck())
				break;
			moveBelt();
			if (belt.get(N - 1).robot) {
				belt.set(N - 1, new info(false, belt.get(N - 1).w));
			}
			if (endCheck())
				break;
			moveRobot();
			if (belt.get(N - 1).robot) {
				belt.set(N - 1, new info(false, belt.get(N - 1).w));
			}
			if (endCheck())
				break;

			putRobot();
			if (endCheck())
				break;

			round++;
		}

		System.out.println(round);

	}

	static void putRobot() {
		if (belt.get(0).w > 0) {
			belt.set(0, new info(true, belt.get(0).w - 1));
		}
	}

	static void moveBelt() {
		int size = belt.size();

		belt.add(0, new info(false, belt.get(size - 1).w));
		belt.remove(size);
	}

	static void moveRobot() {
		for (int i = N - 2; i >= 0; i--) {
			if (belt.get(i).robot && !belt.get(i + 1).robot && belt.get(i + 1).w > 0) {
				belt.set(i, new info(false, belt.get(i).w));
				belt.set(i + 1, new info(true, belt.get(i + 1).w - 1));
			}
		}
	}

	static boolean endCheck() {
		int cnt = 0;

		for (info ob : belt) {
			if (ob.w <= 0)
				cnt++;
		}

		if (cnt >= K)
			return true;
		else
			return false;
	}

}
//https://www.acmicpc.net/problem/20055