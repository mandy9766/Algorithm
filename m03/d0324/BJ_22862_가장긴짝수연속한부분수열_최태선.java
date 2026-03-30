package d0324;

import java.io.*;
import java.util.*;

public class BJ_22862_가장긴짝수연속한부분수열_최태선 {
    static int N,K;
    static int[] arr;
    static int maxVal;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        maxVal = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int count =0;
        int kCount =0;
        for(int e=0;e<N;e++){
            if(arr[e]%2 == 0){
                count ++;
                maxVal = Math.max(maxVal,count);
            }else{
                kCount++;
            }
            if(kCount>K){
                while(kCount>K){
                    if(arr[s]%2 == 0){
                        count--;
                    }else{
                        kCount --;
                    }
                    s++;
                }
            }
        }
        System.out.println(maxVal);
    }
    
}
