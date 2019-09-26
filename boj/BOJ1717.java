package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			
			int operation = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (operation == 0) {
				a=find(a);
				b=find(b);
				if(a!=b) {
					parent[a]=b;
				}
			} else {
				if (find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	static int find(int a) {

		if (parent[a] == a) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}
}
