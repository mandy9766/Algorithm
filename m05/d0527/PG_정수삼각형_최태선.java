package m05.d0527;

import java.util.*;

public class PG_정수삼각형_최태선 {
    int [][] dp;
    int [][] arr;
    int N;
    int maxVal;
    public int solution(int[][] triangle) {
        N = triangle.length;
        arr = triangle;
        dp = new int[N][N];
        dp[0][0] = arr[0][0];
        maxVal = dp[0][0];
        for(int i=1;i<N;i++){
            dp[i][0] = dp[i-1][0] + arr[i][0];
            maxVal = Math.max(maxVal,dp[i][0]);
            for(int j=1;j<=i;j++){
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
                maxVal = Math.max(maxVal,dp[i][j]);
            }
        }
        return maxVal;
    }
}
