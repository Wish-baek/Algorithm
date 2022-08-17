import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1992 {
	static int N;
	static int[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		quadTree(0, 0, N);
		System.out.println(sb);
	}

	static void quadTree(int x, int y, int size) {
		if(check(x, y, size)) {
			sb.append(arr[x][y]);
			return;
		}
		int quad = size/2;
		
		sb.append("(");
		
		quadTree(x, y, quad);
		quadTree(x, y+quad, quad);
		quadTree(x+quad, y, quad);
		quadTree(x+quad, y+quad, quad);
		sb.append(")");
		
		
	}
	static boolean check(int x, int y, int size) {
		boolean ck = true;
		int tmp = arr[x][y];
		for(int i = x; i<x+size; i++) {
			for(int j = y; j < y+size; j++) {
				if(arr[i][j]!=tmp) return false;
			}
		}
		return ck;
	}
}
//https://www.acmicpc.net/problem/1992