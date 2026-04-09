package m04.d0409;

import java.io.*;
import java.util.*;

public class BJ_14501_퇴사_최태선 {
    static int N;
    static int[] dp,T,P;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+2];
        T = new int[N+2];
        P = new int[N+2];
        for(int i=1;i<N+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=N;i>0;i--){
            if(i+T[i] >N+1)
                dp[i]= dp[i+1];
            else{
                dp[i] = Math.max(dp[i+T[i]]+P[i],dp[i+1]);
            }
        }
        System.out.println(dp[1]);
    }
}
