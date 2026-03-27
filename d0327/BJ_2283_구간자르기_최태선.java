package d0327;

import java.io.*;
import java.util.*;

public class BJ_2283_구간자르기_최태선 {
    static int N,K;
    static int[] diff;
    static int[] count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        diff = new int[1000002];
        count = new int[1000001];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            diff[s] += 1;
            diff[e] -= 1;  
        }
        count[0] = diff[0];
        for(int i=1;i<1000001;i++){
            count[i] = count[i-1] + diff[i];
        }
        int val =0;
        int resultS =-1;
        int resultE =-1;
        int s=0;
        for(int e=0;e<1000001;e++){
            val += count[e];
            while(K<val){
                val -= count[s];
                s++;
            }
            if(K == val){
                resultS = s;
                resultE = e+1;
                break;
            }
        }

        if(resultE == -1){
            System.out.println("0 0");
        }else{
            System.out.println(resultS + " " + resultE);
        }
        

    }
}
