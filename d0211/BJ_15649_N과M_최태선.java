package d0211;

import java.io.*;
import java.util.*;

public class BJ_15649_N과M_최태선 {
    static int N;
    static int M;
    static StringBuilder sb;
    static int[] nums;
    static boolean[] isSelected;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        isSelected = new boolean[N+1];
        Dfs(0) ;
        System.out.println(sb);
    }
    static void Dfs(int count){
        if(count == M){
            for(int i=0;i<M;i++)
            {
                sb.append(nums[i] +" ");
            }
            sb.append("\n");
            return;
        }
        for (int i=1;i<=N;i++){
            if(isSelected[i])
                continue;
            nums[count] = i;
            isSelected[i] = true;
            Dfs(count+1);
            isSelected[i] = false;
        }
    }
}
