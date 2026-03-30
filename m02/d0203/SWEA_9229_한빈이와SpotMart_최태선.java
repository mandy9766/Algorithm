package d0203;

import java.io.*;
import java.util.*;

public class SWEA_9229_한빈이와SpotMart_최태선 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int maxVal = -1;
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    int sum = arr[i] + arr[j];
                    if (sum<=M){
                        maxVal = Math.max(maxVal,sum);
                    }
                }
            }
            System.out.println("#"+(t+1)+" "+maxVal);
        }
    }
}
