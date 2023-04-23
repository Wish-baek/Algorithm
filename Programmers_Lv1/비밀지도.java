class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		String temp;

		for (int i = 0; i < n; i++) {
			answer[i] = "";
			String str1 = Integer.toBinaryString(arr1[i]).replace(" ", "0");
			String str2 = Integer.toBinaryString(arr2[i]).replace(" ", "0");

			int len = str1.length();

			for (int s = 0; s < n - len; s++) {
				str1 = "0" + str1;
			}

			len = str2.length();

			for (int s = 0; s < n - len; s++) {
				System.out.println("!");
				str2 = "0" + str2;
			}

			for (int j = 0; j < n; j++) {
				if (str1.length() <= j && str2.length() <= j) {
					answer[i] += " ";
				} else if (str1.length() <= j) {

					if (str2.charAt(j) == '1') {
						answer[i] += "#";
					} else {
						answer[i] += " ";
					}

				} else if (str2.length() <= j) {
					if (str1.charAt(j) == '1') {
						answer[i] += "#";
					} else {
						answer[i] += " ";
					}
				} else {
					if (str1.charAt(j) == '1' || str2.charAt(j) == '1') {
						answer[i] += "#";
					} else {
						answer[i] += " ";
					}
				}

			}
		}
		return answer;
	}
}
