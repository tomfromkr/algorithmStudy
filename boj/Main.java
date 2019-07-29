import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 7569번 문제
//https://www.acmicpc.net/problem/7569

class Tomato {
	int x;
	int y;
	int z;

	Tomato(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int M, N, H;
	static int[][][] box;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 0, 0, 1, -1 };
	static int[] dz = { 1, -1, 0, 0, 0, 0 };
	static int[][][] day2;
	static Queue<Tomato> queue = new LinkedList<Tomato>();
	static int max = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer stk = new StringTokenizer(reader.readLine(), " ");
			M = Integer.parseInt(stk.nextToken());// 5
			N = Integer.parseInt(stk.nextToken());// 3
			H = Integer.parseInt(stk.nextToken());// 1
			box = new int[N + 1][M + 1][H + 1];
			visited = new boolean[N + 1][M + 1][H + 1];
			day2 = new int[N + 1][M + 1][H + 1];
			int count = 0;
			for (int i = 1; i <= H; i++) {
				for (int j = 1; j <= N; j++) {
					String temp = reader.readLine();
					stk = new StringTokenizer(temp, " ");
					for (int k = 1; k <= M; k++) {
						int num = Integer.parseInt(stk.nextToken());
						box[j][k][i] = num;
//						visited[j][k][i] = false;
						if(num!=0) {
							visited[j][k][i]=true;
						}
						if (num == 1) {
							queue.add(new Tomato(j, k, i));
							day2[j][k][i] = 0;
						}
					}
				}
			}
			bfs();
			for (int i = 1; i <= H; i++) {
				for (int j = 1; j <= N; j++) {
					for (int k = 1; k <= M; k++) {
						if (box[j][k][i] == 0)
							count++;
					}
				}
			}
			if (count > 0)
				max = -1;
			System.out.println(max);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void bfs() {

		while (!queue.isEmpty()) {
			Tomato q = queue.poll();
			int x = q.x;
			int y = q.y;
			int z = q.z;


			for (int i = 1; i <= 6; i++) {
				int nx = x + dx[i - 1];
				int ny = y + dy[i - 1];
				int nz = z + dz[i - 1];
				if (nx > N || ny > M || nz > H || nx < 1 || ny < 1 || nz < 1)
					continue;
				if (box[nx][ny][nz] == -1 || visited[nx][ny][nz] == true)
					continue;
				box[nx][ny][nz] = 1;
				day2[nx][ny][nz] = day2[x][y][z] + 1;
				max = Math.max(max, day2[nx][ny][nz]);

				visited[nx][ny][nz] = true;
				queue.add(new Tomato(nx, ny, nz));
			}
		}
	}

}
