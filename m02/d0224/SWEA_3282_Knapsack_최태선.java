package d0224;

import java.io.*;
import java.util.*;

public class SWEA_3282_Knapsack_최태선 {
    static int T,N,K;
    static int[] V,C;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken()); // 물건개수
            K = Integer.parseInt(st.nextToken()); // 부피
            V = new int[N+1];
            C = new int[N+1];
            dp = new int[N+1][K+1]; // N개까지 부피 K 이하로 가능한 최대값
            dp[0][0] = 0; 
            for(int i=1;i<=N;i++){
                st = new StringTokenizer(br.readLine()," ");
                V[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
            }
            for(int j=0;j<=K;j++){
                dp[0][j] = 0;
            }
            for(int i=1;i<=N;i++){
                for(int j=1;j<=K;j++){
                    if(j>=V[i])
                        dp[i][j] = Math.max(dp[i-1][j-V[i]]+C[i],dp[i-1][j]);
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
            System.out.println("#"+t+" "+ dp[N][K]);

        }
    }
}
