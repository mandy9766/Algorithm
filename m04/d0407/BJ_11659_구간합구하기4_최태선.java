package m04.d0407;

import java.io.*;
import java.util.*;

public class BJ_11659_구간합구하기4_최태선 {
    static int N,M;
    static int[] arr;
    static int[] sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        arr = new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sum = new int[N+1]; // 0~ i까지 누적합
        for(int i=1;i<N+1;i++){
            sum[i] = sum[i-1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(sum[e]-sum[s-1]).append("\n");
        }
        System.out.println(sb);
    }
}
