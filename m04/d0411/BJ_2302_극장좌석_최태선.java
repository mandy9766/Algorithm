package m04.d0411;

import java.io.*;
import java.util.*;

public class BJ_2302_극장좌석_최태선 {
    static int N,M;
    static int[] dp;
    static Deque<Integer> deque;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[41];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4;i<N+1;i++){
            dp[i] = dp[i-1]+ dp[i-2] ;
        }
        int nowIdx = 0;
        deque = new ArrayDeque<>();
        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            int fixedIdx = Integer.parseInt(br.readLine());
            if((fixedIdx-nowIdx)-1 != 0)
                deque.add((fixedIdx-nowIdx)-1);
            nowIdx = fixedIdx;
        }
        if(N != nowIdx)
            deque.add(N-nowIdx);
        result = 1;
        while(!deque.isEmpty()){
            int nowVal = deque.poll();
            result = result * dp[nowVal];
        }
        System.out.println(result);
        
    }
}
