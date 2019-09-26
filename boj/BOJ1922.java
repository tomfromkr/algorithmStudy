package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1922 {
	static class Edge implements Comparable<Edge> {
		int v1, v2, weight;

		Edge(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.weight > o.weight)
				return 1;
			else if (this.weight < o.weight)
				return -1;
			else
				return 0;
		}

	}

	static int[] parent;
	static ArrayList<Edge> list = new ArrayList<Edge>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Edge(v1, v2, weight));
		}
		list.sort(null);
		int sum = 0;
		for (Edge edge : list) {
			if (find(edge.v1) != find(edge.v2)) {
				sum += edge.weight;
				union(edge.v1, edge.v2);
			}
		}
		System.out.println(sum);
	}

	static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		if (v1 != v2)
			parent[v1] = v2;
	}

	static int find(int v1) {
		if (parent[v1] == v1)
			return v1;
		else
			return parent[v1] = find(parent[v1]);
	}
}
