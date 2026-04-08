package m04.d0408;

import java.io.*;
import java.util.*;

public class BJ_11727_2xN타일링2_최태선 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        if(N == 1){
            System.out.println(1);
            return;
        }else if(N == 2){
            System.out.println(3);
            return;
        }
        dp[1] = 1;
        dp[2] = 3;
        for(int i=3;i<N+1;i++){
            dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
        }
        System.out.println(dp[N]);
        

    }
}
