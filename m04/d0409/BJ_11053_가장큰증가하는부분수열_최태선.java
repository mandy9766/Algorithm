package m04.d0409;

import java.io.*;
import java.util.*;

public class BJ_11053_가장큰증가하는부분수열_최태선 {
    static int N;
    static int[] A,dp;
    static int maxVal;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        dp[0]=1;
        maxVal = 1;
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(A[i]>A[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxVal = Math.max(dp[i],maxVal);
                }
            }
        }
        System.out.println(maxVal);
    }
}
