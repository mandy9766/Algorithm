package d0321;

import java.io.*;
import java.util.*;

public class BJ_14501_퇴사_최태선 {
    static int N;
    static int[] dp;
    static int maxVal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+2]; // i까지 할수있는 최대값
        dp[0] = 0;
        maxVal = 0;
        for(int i=1;i<N+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int t= Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            maxVal = Math.max(maxVal,dp[i]); // 현재 일까지의 최대값
            if( i+t<=N+1 )
                dp[i+t] = Math.max(maxVal+p,dp[i+t]);
        }
        maxVal = Math.max(maxVal, dp[N+1]);
        System.out.println(maxVal);
    }
}
