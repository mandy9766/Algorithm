package m04.d0410;

import java.io.*;
import java.util.*;

public class BJ_10844_쉬운계단수_최태선 {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][10];
        for(int j=1;j<10;j++){
            dp[1][j] = 1;
        }
        for(int i=2;i<=N;i++){
            for(int j=0;j<10;j++){
                if(j == 0)
                    dp[i][j] = dp[i-1][j+1];
                else if(j == 9)
                    dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
                }
            }
        }
        int result = 0;
        for(int i=0;i<10;i++){
            result = (result+ dp[N][i])%1000000000;
        }
        System.out.println(result);
    }
}
