package m04.d0410;

import java.io.*;
import java.util.*;

public class BJ_2748_피보나치수_최태선 {
    static int N;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[N]);
    }
}
