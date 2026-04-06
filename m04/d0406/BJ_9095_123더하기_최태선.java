package m04.d0406;

import java.io.*;
import java.util.*;

public class BJ_9095_123더하기_최태선 {
    static int T,N;
    static int[] dp;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4;i<12;i++){
            dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        }
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
