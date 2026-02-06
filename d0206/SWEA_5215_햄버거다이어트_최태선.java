package d0206;

import java.io.*;
import java.util.*;

public class SWEA_5215_햄버거다이어트_최태선 {
    static int[][] burger; // 각 햄버거, 햄버거 맛점수/칼로리
    static int maxVal;
    static int N,L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            burger = new int[N][2];
            for (int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                burger[i][0] = Integer.parseInt(st.nextToken());
                burger[i][1] = Integer.parseInt(st.nextToken());
            }
            maxVal = 0;
            for (int i=0;i<(1<<N);i++){
                check(i);
            }
            System.out.println("#"+(t+1) + " " +maxVal);
        }

    }
    public static void check(int bit){
        int sumCal = 0;
        int sumVal = 0;
        for(int i=0;i<N;i++){
            if((bit & 1<<i) != 0){
                sumVal += burger[i][0];
                sumCal += burger[i][1];
            }
        }
        if(sumCal<=L){
            maxVal = Math.max(maxVal,sumVal);
        }
    }
}
