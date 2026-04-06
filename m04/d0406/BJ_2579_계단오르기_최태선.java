package m04.d0406;

import java.io.*;
import java.util.*;

public class BJ_2579_계단오르기_최태선 {
    static int N;
    static int[] stair;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stair = new int[N+1];
        for(int i=1;i<N+1;i++){
            stair[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[3][N+1];
        for(int i=0;i<3;i++){
            Arrays.fill(dp[i],-1);
        }
        if(N == 1)
        {
            System.out.println(stair[1]);
            return;
        }
        if(N == 2){
            System.out.println(stair[1]+stair[2]);
            return;
        }
        dp[0][0] = 0;
        dp[1][1] = stair[1];
        dp[1][2] = stair[2];
        dp[2][2] = stair[1]+stair[2];
        
        for(int i=3;i<N+1;i++){
            int temp1 =0;
            int temp2 =0;
            if(dp[2][i-2]!= -1)
                temp1 = dp[2][i-2] +stair[i];
            if(dp[1][i-2]!= -1)
                temp2 = dp[1][i-2] +stair[i];
            dp[1][i] = Math.max(temp1,temp2);
            if(dp[1][i-1] != -1)
                dp[2][i] = dp[1][i-1] +stair[i];
        }
        System.out.println(Math.max(dp[1][N] , dp[2][N]));
    }
}
