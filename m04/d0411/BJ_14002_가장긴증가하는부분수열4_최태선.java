package m04.d0411;

import java.io.*;
import java.util.*;

public class BJ_14002_가장긴증가하는부분수열4_최태선 {
    static int N;
    static int[] arr;
    static int[] dp;
    static int[] parents;
    static int maxIdx, maxCount;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        parents = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,1);
        Arrays.fill(parents,-1);
        dp[0] = 1;
        maxCount = 1;
        maxIdx = 0;
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    parents[i] = j;
                    if(maxCount < dp[i]){
                        maxCount = dp[i];
                        maxIdx = i;
                    }
                }
            }
        }
        result = new int[maxCount];
        int c=0;
        while(true){
            int nowNum = arr[maxIdx];
            result[c] = nowNum;
            c++;
            maxIdx = parents[maxIdx];
            if(maxIdx == -1)
                break;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(maxCount).append("\n");
        for(int i=maxCount-1;i>=0;i--){
            sb.append(result[i]).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);
        
    }
}
