package d0204;

import java.io.*;
import java.util.*;

public class BJ_18429_근손실_최태선 {
    static int N,K;
    static int[] kits;
    static boolean[] used;
    static int totalCount;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kits = new int[N];
        used = new boolean[N];
        totalCount = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            kits[i] = Integer.parseInt(st.nextToken());
        }
        permutation(0, 500);
        System.out.println(totalCount);
    }
    public static void permutation(int idx,int sum){
        if(sum <500){
            return;
        }
        if(idx == N){
            totalCount += 1;
            return;
        }
        for (int i=0;i<N;i++){
            if(used[i] == false){
                used[i] = true;
                permutation(idx+1,sum+kits[i]-K);
                used[i] = false;
            }
        }
    }
    
}
