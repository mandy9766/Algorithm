package d0211;

import java.io.*;
import java.util.*;

public class SWEA_1486_장훈이의높은선반_최태선 {
    static int[] h;
    static int N,B,S;
    static boolean[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            h = new int[N];
            for(int i=0;i<N;i++){
                h[i] = Integer.parseInt(st.nextToken());
                S += h[i];
            }
            dp = new boolean[S+1]; //dp[i]는 i번까지 넣었을때 가능한지
            dp[0] = true;
            for(int i=0;i<N;i++){
                int height = h[i];
                for(int sum = S-height;sum>=0;sum--)
                {
                    if(dp[sum] == true){
                        dp[sum+height] = true;
                    }
                }
            }
            int minVal = S;
            for(int i=S;i>=B;i--){
                if(dp[i] == true){
                    minVal = i;
                }

            }
            System.out.println("#"+(t+1) +" "+(minVal-B));
        }
    }
}
