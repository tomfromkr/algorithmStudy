package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2615 {
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 0, 1, 1, 1 };
	static int[] dy = { 1, 1, 0, -1 };
	static Queue<Point> queue = new LinkedList<Point>();
	static int[][] map;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0)
					queue.add(new Point(i, j));
			}
		}
		bfs();
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int x = point.x;
			int y = point.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19) {
					continue;
				} else if (map[x][y] == map[nx][ny]) {
					int dir = 2;
					while (true) {
						int nnx = x + dir * dx[i];
						int nny = y + dir * dy[i];
						if (nnx < 0 || nnx >= 19 || nny < 0 || nny >= 19) {
							break;
						} else if (map[x][y] != map[nnx][nny]) {
							break;
						}
						dir++;

					}
					if (dir == 5) {
						int cx = x - dx[i];
						int cy = y - dy[i];
						if (0 <= cx && cx < 19 && 0 <= cy && cy < 19) {
							if (map[cx][cy] == map[x][y]) {
								continue;
							}
						}
						if (i == 0 || i == 1 || i == 2) {

							System.out.println(map[x][y]);
							System.out.print((x + 1) + " " + (y + 1));
							return;

						} else {
							System.out.println(map[x][y]);
							System.out.print((x + 5) + " " + (y - 3));
							return;
						}
					}
				}
			}
		}
		System.out.print(0);
	}
}
