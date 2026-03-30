package d0326;

import java.io.*;
import java.util.*;

public class BJ_1477_휴게소세우기_최태선 {
    static int N,M,L;
    static int[] arr,dist;
    static int minVal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N+2];
        dist = new int[N+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N+1] = L;
        int minDistance = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0;i<N+1;i++){
            dist[i] = arr[i+1]-arr[i];
            minDistance = Math.min(minDistance,dist[i]);
        }
        int left = 1;
        int right = L-1;
        minVal = Integer.MAX_VALUE;
        while (left<=right){
            int mid = (left+right)/2;
            if(check(mid)){
                minVal = Math.min(minVal,mid);
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        System.out.println(minVal);
    }
    static boolean check(int nowMinDist){
        int nowCount =0;
        for(int i=0;i<N+1;i++){
            if(nowMinDist >= dist[i])
                continue;
            nowCount += (dist[i]-1) /nowMinDist;
        }
        if(nowCount<=M)
            return true;
        else
            return false;
    }
}
