package d0327;

import java.io.*;
import java.util.*;

public class BJ_20922_겹치는건싫어_최태선 {
    static int N,K;
    static int[] arr;
    static int[] count;
    static int maxVal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        count = new int[100001];
        maxVal = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s=0;
        for(int e=0;e<N;e++){
            count[arr[e]]++;
            while(count[arr[e]]>K){
                count[arr[s]] --;
                s++;
            }
            maxVal = Math.max(maxVal,e-s+1);
        }
        System.out.println(maxVal);
    }    
}
