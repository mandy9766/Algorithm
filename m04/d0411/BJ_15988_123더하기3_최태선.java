package m04.d0411;

import java.io.*;
import java.util.*;

public class BJ_15988_123더하기3_최태선 {
    static int T,N;
    static int[] dp;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4;i<1000001;i++){
            dp[i] = ((dp[i-1] + dp[i-2])%1000000009 + dp[i-3])%1000000009;
        }
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}
