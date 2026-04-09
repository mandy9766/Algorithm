package m04.d0409;

import java.io.*;
import java.util.*;

public class BJ_9461_파도반수열_최태선 {
    static int T,N;
    static long[] dp;
    
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new long[101];
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        dp[4]=2;
        dp[5]=2;
        for(int i=6;i<101;i++){
            dp[i] = dp[i-1]+dp[i-5];
        }
        
        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
