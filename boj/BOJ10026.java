package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//백준알고리즘 10026번문제 bfs
public class BOJ10026 {
	static char[][] map;
	static boolean[][] visited, visited2;
	static Queue<Color> queue = new LinkedList<Color>();
	static Queue<Color> weakQueue = new LinkedList<Color>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		map = new char[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		visited2 = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String str = reader.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}
		for (int i = 1; i <= N; i++) {
			Arrays.fill(visited[i], false);
			Arrays.fill(visited2[i], false);
		}
		int count = 0, count2 = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					queue.add(new Color(i, j));
					bfs();
					count++;
				}
				if (!visited2[i][j]) {
					visited2[i][j] = true;
					weakQueue.add(new Color(i, j));
					bfs2();
					count2++;
				}

			}
		}
		System.out.print(count+" "+count2);
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			Color color = queue.poll();
			int x = color.x;
			int y = color.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 1 || nx > N || ny < 1 || ny > N)
					continue;
				if (visited[nx][ny])
					continue;
				if (map[x][y] == map[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Color(nx, ny));
				}

			}
		}

	}

	static void bfs2() {
		while (!weakQueue.isEmpty()) {
			Color color = weakQueue.poll();
			int x = color.x;
			int y = color.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 1 || nx > N || ny < 1 || ny > N)
					continue;
				if (visited2[nx][ny])
					continue;
				if (map[x][y] == 'B') {
					if (map[x][y] == map[nx][ny]) {
						visited2[nx][ny] = true;
						weakQueue.add(new Color(nx, ny));
					}
				} else {
					if (map[nx][ny] == 'R' || map[nx][ny] == 'G') {
						visited2[nx][ny] = true;
						weakQueue.add(new Color(nx, ny));
					}
				}

			}
		}
	}

	static class Color {
		int x, y;

		public Color(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
