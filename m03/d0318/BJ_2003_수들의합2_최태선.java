package d0318;

import java.io.*;
import java.util.*;

public class BJ_2003_수들의합2_최태선 {
    static int N,M;
    static int[] arr;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count =0;
        int s = 0;
        int e = 0;
        int nowSum = 0;
        while(true){
            if(nowSum >= M){
                if(nowSum == M)
                    count ++;
                nowSum -= arr[s];
                s ++;
            }else if(e == N){
                break;
            }else{
                nowSum+= arr[e];
                e++;
            }
        }
        System.out.println(count);
    }
}
