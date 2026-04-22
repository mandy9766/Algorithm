package m04.d0417;

import java.io.*;
import java.util.*;

public class BJ_2293_동전1_최태선 {
     static int N, K;
     static int[] dp;

     public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          N = Integer.parseInt(st.nextToken());
          K = Integer.parseInt(st.nextToken());

          dp = new int[K+1];
          dp[0] =1;
          for(int i=0;i<N;i++){
               int a = Integer.parseInt(br.readLine());
               for(int j=a;j<K+1;j++){
                    if(dp[j-a]>0){
                         dp[j] += dp[j-a] ;
                    }
               }
          }
          System.out.println(dp[K]);
     }
}
