package d0211;

import java.io.*;
import java.util.*;

public class SWEA_1486_장훈이의높은선반_최태선R {
    static int[] h;
    static int N,B,S;
    static int minVal; // B보다크며 가장 가까운
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            S =0;
            st = new StringTokenizer(br.readLine()," ");
            h = new int[N];
            for(int i=0;i<N;i++){
                h[i] = Integer.parseInt(st.nextToken());
                S += h[i];
            }
            minVal = S;
            Dfs(0,0);
            System.out.println("#"+(t+1) +" "+(minVal-B));
        }
        
    }
    static void Dfs(int idx,int sum){
        if(sum >= B){
            if(minVal >sum)
                minVal = sum;
            return;
        }
        if(idx == N){
            if(minVal > sum && sum>=B){
                minVal = sum;
            }
            return;
        }
        Dfs(idx+1,sum+h[idx]);
        Dfs(idx+1,sum);
    }
}
