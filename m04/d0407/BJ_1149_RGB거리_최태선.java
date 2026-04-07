package m04.d0407;

import java.io.*;
import java.util.*;

public class BJ_1149_RGB거리_최태선 {
    static int N;
    static int[][] dp;
    static int[][] arr;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[3][N+1];
        arr = new int[N+1][3];
        for(int i=1;i<N+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken()); // i번째 집에 빨강 칠했을때 값
            arr[i][1] = Integer.parseInt(st.nextToken()); // i번째 집에 초록 칠했을때 값
            arr[i][2] = Integer.parseInt(st.nextToken()); // i번째 집에 파랑 칠했을때
        }
        for(int i=1;i<N+1;i++){
            dp[0][i] = Math.min(dp[1][i-1] ,dp[2][i-1]) + arr[i][0];
            dp[1][i] = Math.min(dp[0][i-1], dp[2][i-1]) + arr[i][1];
            dp[2][i] = Math.min(dp[0][i-1], dp[1][i-1]) + arr[i][2];
        }
        result = Math.min(dp[0][N],dp[1][N]);
        result = Math.min(result,dp[2][N]);
        System.out.println(result);
    }
}
