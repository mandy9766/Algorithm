package m04.d0406;

import java.io.*;
import java.util.*;


public class SWEA_1952_수영장_최태선 {
    static int T;
    static int d,m,m3,y;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            d = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            m3= Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            dp = new int[13];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<13;i++){
                int nowCount = Integer.parseInt(st.nextToken());
                dp[i] = Math.min(dp[i],dp[i-1]+d*nowCount);
                dp[i] = Math.min(dp[i],dp[i-1] +m);
                if(i>=3){
                    dp[i] = Math.min(dp[i],dp[i-3]+m3);
                } 
                if(i>=12){
                    dp[i] = Math.min(dp[i],dp[i-12]+y);
                }
            }
            System.out.println("#"+t+" "+dp[12]);
        }
    }
}
