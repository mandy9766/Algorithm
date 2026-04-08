package m04.d0408;

import java.io.*;
import java.util.*;

public class BJ_1003_피보나치함수_최태선 {
    static int[][] memoization;
    static int T,N;
    static int count;
    public static void main(String[] args) throws Exception {
        memoization = new int[41][2];
        memoization[0][0] = 1;
        memoization[0][1] = 0;
        memoization[1][0] = 0;
        memoization[1][1] = 1;
        for(int i=2;i<41;i++){
            memoization[i][0] = memoization[i-1][0]+memoization[i-2][0];
            memoization[i][1] = memoization[i-1][1]+memoization[i-2][1];
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            sb.append(memoization[N][0]).append(" ").append(memoization[N][1]).append("\n");
        }
        System.out.println(sb);
    }
    
}
