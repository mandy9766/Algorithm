package m04.d0407;

import java.io.*;
import java.util.*;

public class BJ_11726_2xN타일링_최태선 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[1]= 1;
        if(N >= 2)
            dp[2] = 2;
        for(int i=3;i<N+1;i++){
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        System.out.println(dp[N]);
    }
}
