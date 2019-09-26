package boj;

import java.util.Scanner;

public class BOJ10974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		int[] outputArr = new int[N];
		boolean[] visited = new boolean[N];
		perm(arr, outputArr, visited, N, N, 0);
	}

	static void perm(int[] arr, int[] outputArr, boolean[] visited, int n, int r, int depth) {
		if (depth == r) {
			print(outputArr);
			return;
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					outputArr[depth] = arr[i];
					perm(arr, outputArr, visited, n, r, depth + 1);
					visited[i] = false;
				}
			}
		}
	}

	static void print(int[] outputArr) {
		for (int i : outputArr)
			System.out.print(i + " ");
		System.out.println();
	}
}
