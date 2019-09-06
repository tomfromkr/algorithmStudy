package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준알고리즘 1018번 문제
// https://www.acmicpc.net/problem/1018

public class BOJ1018 {
	static boolean[][] map;
	static boolean black = true;
	static boolean white = false;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String temp = reader.readLine();
			for (int j = 1; j <= M; j++) {
				if (temp.charAt(j - 1) == 'W')
					map[i][j] = white;
				else
					map[i][j] = black;
			}
		}
		int ans = 64;
		for (int i = 1; i <= N - 8 + 1; i++) {
			for (int j = 1; j <= M - 8 + 1; j++) {
				ans = Math.min(ans, dfs(i, j, black));
				ans = Math.min(ans, dfs(i, j, white));
			}
		}
		System.out.print(ans);
	}

	static int dfs(int x, int y, boolean color) {
		int ret = 0;
		for (int i = x; i <= x + 8 - 1; i++) {
			for (int j = y; j <= y + 8 - 1; j++) {
				if (j % 2 == y % 2 && map[i][j] != color)
					ret++;
				else if (j % 2 != y % 2 && map[i][j] == color)
					ret++;
			}
			color = !color;
		}
		return ret;
	}
}
