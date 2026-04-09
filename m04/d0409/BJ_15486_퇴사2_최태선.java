package m04.d0409;

import java.io.*;
import java.util.*;

public class BJ_15486_퇴사2_최태선 {
    static int N,maxVal;
    static int[] dp,T,P;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+2];
        T = new int[N+2];
        P = new int[N+2];
        maxVal = 0;
        for(int i=1;i<N+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N+1;i++){
            maxVal = Math.max(maxVal,dp[i]);
            if(i+T[i]>N+1)
                continue;
            dp[i+T[i]] = Math.max(dp[i+T[i]],maxVal+P[i]);
        }
        maxVal = Math.max(maxVal,dp[N+1]);
        System.out.println(maxVal);
    }
}
