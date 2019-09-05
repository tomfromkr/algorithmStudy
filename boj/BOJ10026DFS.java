package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//백준알고리즘 10026번문제 dfs
public class BOJ10026DFS {
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		map = new char[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String str = reader.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}
		for (int i = 1; i <= N; i++) {
			Arrays.fill(visited[i], false);
		}
		int count = 0, count2 = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j);
					count++;
				}
			}
		}
		System.out.print(count + " ");

		for (int i = 1; i <= N; i++)
			Arrays.fill(visited[i], false);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 'R')
					map[i][j] = 'G';
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j);
					count2++;
				}
			}
		}
		System.out.print(count2);
	}

	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 1 || nx > N || ny < 1 || ny > N)
				continue;
			if (visited[nx][ny])
				continue;
			if (map[x][y] == map[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}

		}

	}

}
