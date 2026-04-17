package m04.d0417;

import java.io.*;
import java.util.*;

public class BJ_11057_오르막수_최태선 {
     static int N;
     static int[][] dp;
     static int result;

     public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          N = Integer.parseInt(br.readLine());
          dp = new int[N + 1][10];
          for (int j = 0; j < 10; j++) {
               dp[1][j] = 1;
          }
          for (int i = 2; i < N + 1; i++) {
               for (int j = 0; j < 10; j++) {
                    if (j == 0)
                         dp[i][j] = 1;
                    else {
                         dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007;
                    }
               }
          }
          for (int j = 0; j < 10; j++) {
               result += dp[N][j];
          }
          System.out.println(result % 10007);
     }
}
