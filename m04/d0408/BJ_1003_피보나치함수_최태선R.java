package m04.d0408;

import java.io.*;
import java.util.*;

public class BJ_1003_피보나치함수_최태선R {
    static int[][] memoization;
    static int T,N;
    static int count;
    public static void main(String[] args) throws Exception {
        memoization = new int[41][2];
        for(int i=0;i<41;i++){
            for(int j=0;j<2;j++){
                memoization[i][j] = -1;
            }
        }
        memoization[0][0] = 1;
        memoization[0][1] = 0;
        memoization[1][0] = 0;
        memoization[1][1] = 1;
        fibo(40);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            sb.append(memoization[N][0]).append(" ").append(memoization[N][1]).append("\n");
        }
        System.out.println(sb);
    }
    static int[] fibo(int n){
        if(memoization[n][0] != -1)
            return memoization[n];
        int[] left = fibo(n-1);
        int[] right = fibo(n-2);
        memoization[n][0] = left[0] + right[0];
        memoization[n][1] = left[1] + right[1];
        return memoization[n];
    }
    
}
