package m05.d0527;

import java.util.*;

class PG_등교길_TopDown_최태선 {
    int[][] dp;
    int[][] arr;
    int M,N;
    public int solution(int m, int n, int[][] puddles) {
        M = m;
        N = n;
        arr = new int[M+1][N+1];
        dp = new int[M+1][N+1];
        for(int i=0;i<M+1;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int p=0;p<puddles.length;p++){
            arr[puddles[p][0]][puddles[p][1]] = 1;
        }
        dp[1][1] = 1;
        return dfs(M,N);
        
    }
    int dfs(int i,int j){
        if(arr[i][j] == 1)
            return 0;
        if(j < 1 || i < 1)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];    
        dp[i][j] = (dfs(i-1,j) + dfs(i,j-1))%1000000007;
        return  dp[i][j];
    }
}

