package d0330;

import java.io.*;
import java.util.*;

public class BJ_16987_계란으로계란치기_최태선 {
    static int N;
    static int[] S,W;
    static int maxVal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N+1];
        W = new int[N+1];
        maxVal = 0;
        for(int i=1;i<N+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            S[i] = s;
            W[i] = w;
        }
        dfs(1,0);
        System.out.println(maxVal);
    }
    static void dfs(int depth,int count){
        if(depth >= N+1)
        {
            maxVal = Math.max(maxVal,count);
            return;
        }
        // 현재 든 계란 : depth
        if(S[depth] <=0 || check(depth) == false)
        {
            dfs(depth+1,count);
            return;
        }
        for(int i=1;i<N+1;i++){
            int tempCount = count;
            if(i==depth || S[i] <=0)
                continue;
            // i번 계란 선택해서 서로깬다
            S[depth] -= W[i];
            S[i] -= W[depth];
            if(S[depth]<= 0)
                tempCount++;
            if(S[i] <= 0)
                tempCount++;
            dfs(depth+1,tempCount);
            S[i] += W[depth];
            S[depth] += W[i];
        }
    }
    static boolean check(int nowNum){
        for(int i=1;i<N+1;i++){
            if(i == nowNum)
                continue;
            if(S[i] >0)
                return true;
        }
        return false;
    }
}
