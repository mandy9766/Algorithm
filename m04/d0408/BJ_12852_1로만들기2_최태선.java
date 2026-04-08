package m04.d0408;

import java.io.*;
import java.util.*;

public class BJ_12852_1로만들기2_최태선 {
    static int N;
    static int[] dp;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        parent = new int[N+1];
        parent[1] = -1;
        dp[1] = 0;
        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1]+1;
            parent[i] = i-1;
            if(i%2 == 0)
            {
                if(dp[i]>dp[i/2]+1){
                    dp[i] = dp[i/2]+1;
                    parent[i] = i/2;
                }
            }
            if(i%3 == 0){
                if(dp[i]>dp[i/3]+1){
                    dp[i] = dp[i/3]+1;
                    parent[i] = i/3;
                }

            }
        }
        System.out.println(dp[N]);
        StringBuilder sb =new StringBuilder();
        int x = N;
        while(x != -1){
            sb.append(x).append(" ");
            x = parent[x];
        }
        System.out.println(sb);
    }
}
