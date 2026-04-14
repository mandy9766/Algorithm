package m04.d0411;

import java.io.*;
import java.util.*;

public class BJ_2156_포도주시식_최태선 {
    static int N;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1][3];
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=1;i<=N;i++){
            int nowMax = Math.max(dp[i-1][0],dp[i-1][1]);
            nowMax = Math.max(nowMax,dp[i-1][2]);
            dp[i][0] = nowMax;
            dp[i][1] = dp[i-1][0] + arr[i];
            dp[i][2] = dp[i-1][1] + arr[i];
        }
        int result = Math.max(dp[N][0],dp[N][1]);
        result = Math.max(result,dp[N][2]);
        System.out.println(result);
    }
}
