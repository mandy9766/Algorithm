package d0324;

import java.io.*;
import java.util.*;
public class BJ_2805_나무자르기_최태선 {
    static int N,M;
    static int[] trees;
    static int maxVal;
    static int maxHeight;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        maxHeight = 0;
        maxVal = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight,trees[i]);
        }

        int s = 0;
        int e = maxHeight;
        while(s<=e){
            int mid = (s+e)/2; // 현재 자를 높이 h
            long nowVal = 0;
            for(int i=0;i<N;i++){
                if(trees[i] > mid){
                    nowVal += trees[i]-mid;
                }
            }
            if (nowVal >= M){
                maxVal = Math.max(maxVal, mid);
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        System.out.println(maxVal);
    }
}
