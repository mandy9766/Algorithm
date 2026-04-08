package m04.d0408;

import java.io.*;
import java.util.*;

public class SWEA_3282_01Knapsack_최태선 {
    static int T,N,K;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            dp = new int[K+1];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                for(int j=K;j>=v;j--){
                    dp[j] = Math.max(dp[j-v] + c,dp[j]);
                }
            }
            sb.append("#").append(t).append(" ").append(dp[K]).append("\n");
        }
        System.out.println(sb);
    }
}
