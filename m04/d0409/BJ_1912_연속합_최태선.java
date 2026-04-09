package m04.d0409;

import java.io.*;
import java.util.*;

public class BJ_1912_연속합_최태선 {
    static int N;
    static int[] arr,dp;
    static int maxVal;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        maxVal = dp[0];
        for(int i=1;i<N;i++){
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
            maxVal = Math.max(maxVal,dp[i]);
        }
        System.out.println(maxVal);
    }    
}
