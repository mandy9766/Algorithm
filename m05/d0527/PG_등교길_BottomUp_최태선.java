package m05.d0527;

import java.util.*;

public class PG_등교길_BottomUp_최태선 {
    int[][] dp;
    int[][] arr;
    int M,N;
    int depth;
    public int solution(int m, int n, int[][] puddles) {
        M = m;
        N = n;
        depth = M+N-1;
        arr = new int[M+1][N+1];
        dp = new int[M+1][N+1];
        for(int p=0;p<puddles.length;p++){
            arr[puddles[p][0]][puddles[p][1]] = 1;
        }
        dp[1][1] = 1;
        // i+j = d+1
        for(int d=2;d<=depth;d++){
            for(int j=1;j<=d;j++){
                int nowI = d+1-j;
                if(nowI>=1 && nowI<=M && j>=1 && j<=N){
                    if(arr[nowI][j] == 1)
                        continue;
                    if(nowI == 1)
                        dp[nowI][j] = dp[nowI][j-1];
                    else if(j == 1)
                        dp[nowI][j] = dp[nowI-1][j];
                    else{
                        dp[nowI][j] = (dp[nowI][j-1] + dp[nowI-1][j])%1000000007;
                    }
                }
            }
        }
        return dp[M][N];
    }
}
