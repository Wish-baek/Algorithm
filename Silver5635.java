import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Silver5635 {
	static class Person {
		String name;
		int month;
		int date;
		int year;

		public Person() {
		}

		public Person(String name, int date, int month, int year) {
			super();
			this.name = name;
			this.month = month;
			this.date = date;
			this.year = year;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public int getDate() {
			return date;
		}

		public void setDate(int date) {
			this.date = date;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		List<Person> list = new ArrayList<>();
		String[][] arr = new String[N][4];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new Person(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));

		}

		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if (o1.getYear() == o2.getYear()) {
					if (o1.getMonth() == o2.getMonth()) {
						return o1.getDate() - o2.getDate();
					}
					return o1.month - o2.month;
				}
				return o1.getYear() - o2.getYear();
			}
		});
		System.out.println(list.get(list.size() - 1).getName());
		System.out.println(list.get(0).getName());

	}

}
//https://www.acmicpc.net/problem/5635