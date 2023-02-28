import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Silver10825 {

	static class student {
		String name;
		int korean;
		int eng;
		int math;

		public student(String name, int korean, int eng, int math) {
			this.name = name;
			this.korean = korean;
			this.eng = eng;
			this.math = math;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<student> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());

			list.add(new student(name, korean, eng, math));
		}

		Collections.sort(list, new Comparator<student>() {

			@Override
			public int compare(student o1, student o2) {

				if (o1.korean == o2.korean) {
					if (o1.eng == o2.eng) {
						if (o1.math == o2.math) {
							return o1.name.compareTo(o2.name);
						}
						return o2.math - o1.math;
					}
					return o1.eng - o2.eng;
				}
				return o2.korean - o1.korean;
			}
		});

		for (int i = 0; i < N; i++) {
			System.out.println(list.get(i).name);
		}

	}

}
//https://www.acmicpc.net/problem/10825