package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//	백준알고리즘 14890번문제
//	https://www.acmicpc.net/problem/14890
public class BOJ14890 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		// 열 작업
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			for (int j = 0; j < N - 1; j++) {
				int nx = j + 1;
				if (map[i][j] == map[i][nx])
					continue;
				if (Math.abs(map[i][j] - map[i][nx]) > 1) {
					flag = true;
					break;
				}
				if (map[i][j] - map[i][nx] == 1) {
					for (int k = 0; k < L; k++) {
						if (nx + k >= N) {
							flag = true;
							continue;
						}

						if (visited[i][nx + k] || map[i][nx] != map[i][nx + k]) {
							flag = true;
							break;
						}
						visited[i][nx + k] = true;
					}
				} else if (map[i][j] - map[i][nx] == -1) {
					for (int k = 0; k < L; k++) {
						if (j - k < 0) {
							flag = true;
							continue;
						}

						if (visited[i][j - k] || map[i][j] != map[i][j - k]) {
							flag = true;
							break;
						}
						visited[i][j - k] = true;
					}
				}
			}
			if (flag == false)
				ans++;
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}

		// 행 작업
		for (int j = 0; j < N; j++) {
			boolean flag = false;
			for (int i = 0; i < N - 1; i++) {
				int ny = i + 1;
				if (map[i][j] == map[ny][j])
					continue;
				if (Math.abs(map[i][j] - map[ny][j]) > 1) {
					flag = true;
					break;
				}
				if (map[i][j] - map[ny][j] == 1) {
					for (int k = 0; k < L; k++) {
						if (ny + k >= N) {
							flag = true;
							continue;
						}

						if (visited[ny + k][j] || map[ny][j] != map[ny + k][j]) {
							flag = true;
							break;
						}
						visited[ny + k][j] = true;
					}
				} else if (map[i][j] - map[ny][j] == -1) {
					for (int k = 0; k < L; k++) {
						if (i - k < 0) {
							flag = true;
							continue;
						}

						if (visited[i - k][j] || map[i][j] != map[i - k][j]) {
							flag = true;
							break;
						}
						visited[i - k][j] = true;
					}
				}
			}
			if (flag == false)
				ans++;
		}
		System.out.println(ans);
	}

}
