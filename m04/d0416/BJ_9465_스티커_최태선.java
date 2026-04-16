package m04.d0416;

import java.io.*;
import java.util.*;

public class BJ_9465_스티커_최태선 {
	static int T, N;
	static int[][] arr, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[2][N];
			dp = new int[2][N];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (N == 1) {
				System.out.println(Math.max(arr[0][0], arr[1][0]));
				continue;
			}
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			dp[0][1] = arr[1][0] + arr[0][1];
			dp[1][1] = arr[0][0] + arr[1][1];
			for (int i = 2; i < N; i++) {
				dp[0][i] = Math.max(dp[1][i - 1] + arr[0][i], dp[1][i - 2] + arr[0][i]);
				dp[1][i] = Math.max(dp[0][i - 1] + arr[1][i], dp[1][i - 2] + arr[1][i]);
			}
			System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
		}
	}
}
