package m04.d0410;

import java.io.*;
import java.util.*;


public class BJ_2240_자두나무_최태선 {
    static int T,W;
    static int[][]dp;    

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        dp = new int[T+1][W+1];
        for(int i=0;i<T+1;i++){
            Arrays.fill(dp[i],-111);
        }
        dp[0][0] = 0;
        // i값이 짝수면 자두는 1번에있고 홀수면 2번에있음
        for(int i=1;i<T+1;i++){
            int num  = Integer.parseInt(br.readLine());
            for(int j=0;j<W+1;j++){
                if(num == 1){
                    if(j%2 == 0) { // 지금 1번에있음, 1번에 자두옴
                        if(j == 0){
                            dp[i][j] = dp[i-1][j] +1;
                        }else{
                            dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]+1);
                        }
                    }else{//지금 2번에 있음, 1번에 자두옴
                        if(j == 0){ 
                            dp[i][j] = dp[i-1][j];
                        }else{
                            dp[i][j] = Math.max(dp[i-1][j-1]+1,dp[i-1][j]);
                        }
                    }
                    
                }else{
                    if(j%2 == 0) { // 지금 1번에있음, 2번에 자두옴
                        if(j == 0){
                            dp[i][j] = dp[i-1][j];
                        }else{
                            dp[i][j] = Math.max(dp[i-1][j-1]+1,dp[i-1][j]);
                        }
                    }else{//지금 2번에 있음, 2번에 자두옴
                        if(j == 0){ 
                            dp[i][j] = dp[i-1][j]+1;
                        }else{
                            dp[i][j] = Math.max(dp[i-1][j-1]+1,dp[i-1][j]+1);
                        }
                    }

                }
                
            }
        }
        int result = 0;
        for(int j=0;j<W+1;j++){
            result = Math.max(result,dp[T][j]);
        }
        System.out.println(result);
    }    
}
