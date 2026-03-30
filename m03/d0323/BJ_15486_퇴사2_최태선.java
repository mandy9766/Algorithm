package d0323;

import java.io.*;
import java.util.*;

public class BJ_15486_퇴사2_최태선 {
    static int N;
    static int[] dp;
    static int[] t;
    static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+2]; // i까지 할수있는 최대값
        dp[0] = 0;
        t = new int[N+1];
        p = new int[N+1];
        for(int i=1;i<N+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int ti= Integer.parseInt(st.nextToken());
            int pi = Integer.parseInt(st.nextToken());
            p[i] = pi;
            t[i] = ti;
        }
        for(int i=N;i>=1;i--){
            if(i+t[i] > N+1)
                dp[i] = dp[i+1];
            else{
                dp[i] = Math.max(dp[i+1],dp[i+t[i]]+p[i]);
            }
        }
        
        System.out.println(dp[1]);
    }
}
