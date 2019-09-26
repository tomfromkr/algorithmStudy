package boj;

import java.util.Scanner;

public class BOJ1065 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (i <= 99) {
				ans++;
			} else {
				String str = Integer.toString(i);
				int d = str.charAt(0) - str.charAt(1);
				boolean flag=true;
				for(int j=1;j<str.length()-1;j++) {
					if((str.charAt(j)-str.charAt(j+1))!=d) {
						flag=false;
						break;
					}
				}
				if(flag) ans++;

			}
		}
		System.out.println(ans);
	}

}
