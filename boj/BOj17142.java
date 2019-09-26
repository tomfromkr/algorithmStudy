package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOj17142 {
	static Queue<Virus> queue = new LinkedList<Virus>();
	static List<Virus> virusList = new ArrayList<Virus>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] visited;
	static boolean[][] copyVisited;
	static int N, M;
	static int[][] map;
	static int ans = 0;
	static List<Integer> ansList = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		copyVisited = new boolean[N][N];


		int virus = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					visited[i][j] = true;
				else if (map[i][j] == 2) {
					virusList.add(new Virus(i, j, 0));
					virus++;
				}
			}
		}
		for (int i = 0; i < N; i++)
			System.arraycopy(visited[i], 0, copyVisited[i], 0, N);
		Virus[] outputArr = new Virus[M];
		combi(outputArr, virus, M, 0, 0);
		ansList.sort(null);
		if (ansList.get(ansList.size() - 1) == -1)
			System.out.println(-1);
		else {
			for (int i : ansList) {
				if (i == -1)
					continue;
				else {
					System.out.print(i);
					break;
				}
			}

		}


	}

	static void combi(Virus[] outputArr, int n, int r, int index, int target) {
		if (r == 0) {
			ans = 0;
			for (Virus virus : outputArr)
				queue.add(virus);
			for (int i = 0; i < N; i++)
				System.arraycopy(visited[i], 0, copyVisited[i], 0, N);
			bfs();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!copyVisited[i][j])
						ans = -1;
				}
			}
			ansList.add(ans);

		} else if (n == target)
			return;
		else {
			outputArr[index] = virusList.get(target);
			combi(outputArr, n, r - 1, index + 1, target + 1);
			combi(outputArr, n, r, index, target + 1);
		}
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			Virus virus = queue.poll();
			int x = virus.x;
			int y = virus.y;
			int time = virus.time;
			copyVisited[x][y] = true;
			if (map[x][y] != 2)
				ans = Math.max(ans, time);
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				else if (copyVisited[nx][ny]) {
					continue;
				} else {
					copyVisited[nx][ny] = true;
					queue.add(new Virus(nx, ny, time + 1));
				}
			}
		}
	}

	private static class Virus {
		int x, y, time;

		private Virus(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

}
