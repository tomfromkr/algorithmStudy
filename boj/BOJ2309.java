package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ2309 {
	static List<Integer> list = new ArrayList<Integer>();
	static int[] ansArr = new int[7];
	static boolean flag = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 9; i++)
			list.add(scanner.nextInt());
		list.sort(null);
		int[] outputArr = new int[7];
		combi(outputArr, 9, 7, 0, 0);
		for (int i : ansArr)
			System.out.println(i);
	}

	static void combi(int[] outputArr, int n, int r, int index, int target) {
		if (flag)
			return;
		if (r == 0) {
			int sum = 0;
			for (int i : outputArr) {
				sum += i;
			}
			if (sum == 100) {
				flag = true;
				for (int i = 0; i < 7; i++) {
					ansArr[i] = outputArr[i];
				}
				return;
			}
		} else if (target == n)
			return;
		else {
			if (!flag) {
				outputArr[index] = list.get(target);
				combi(outputArr, n, r - 1, index + 1, target + 1);
				combi(outputArr, n, r, index, target + 1);
			}

		}
	}
}
