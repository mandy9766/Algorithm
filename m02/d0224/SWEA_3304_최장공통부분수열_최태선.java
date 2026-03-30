package d0224;

import java.io.*;
import java.util.*;

public class SWEA_3304_최장공통부분수열_최태선 {
    static int T;
    static String string1, string2;
    static int[][] dp;
    static char[] cArr1,cArr2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            string1 = st.nextToken();
            string2 = st.nextToken();
            int N = string1.length();
            int K = string2.length();
            cArr1 = new char[N+1];
            cArr2 = new char[K+1];
            for(int i=1;i<=N;i++){
                cArr1[i] = string1.charAt(i-1);
            }
            for(int i=1;i<=K;i++){
                cArr2[i] = string2.charAt(i-1);
            }
            
            
            dp = new int[N+1][K+1];

            for(int i=1;i<=N;i++){
                for(int j=1;j<=K;j++){
                    if(cArr1[i] == cArr2[j]){
                        dp[i][j] = dp[i-1][j-1] +1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            System.out.println("#"+t+" "+dp[N][K]);
        }

    }    
}
