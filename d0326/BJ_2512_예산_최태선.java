package d0326;

import java.io.*;
import java.util.*;


public class BJ_2512_예산_최태선 {
    static int N,M;
    static int[] arr;
    static int maxVal;
    static int big;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr =new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            big = Math.max(big,arr[i]);
        }
        M = Integer.parseInt(br.readLine());
        int left= 0;
        int right = big;
        maxVal = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if(check(mid)){
                maxVal = Math.max(maxVal,mid);
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(maxVal);

    }
    static boolean check(int val){
        int nowSum =0;
        for(int i=0;i<N;i++){
            if(arr[i]<val){
                nowSum += arr[i];
            }else{
                nowSum += val;
            }
        }
        if(nowSum<=M)
            return true;
        else
            return false;
    }
}
