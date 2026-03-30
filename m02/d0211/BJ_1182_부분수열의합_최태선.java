package d0211;

import java.io.*;
import java.util.*;

public class BJ_1182_부분수열의합_최태선 {
    static int N;
    static int S;
    static int[] arr;
    static int totalCount;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Dfs(0,0);
        if (S == 0)
            System.out.println(totalCount-1);
        else
            System.out.println(totalCount);
        
    }
    static void Dfs(int depth,int sum){
        if(depth == N){
            if(sum == S)
                totalCount++;
            return;
        }
        Dfs(depth+1,sum+arr[depth]);
        Dfs(depth+1,sum);
    }
}
