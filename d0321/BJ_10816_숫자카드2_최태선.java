package d0321;

import java.io.*;
import java.util.*;

public class BJ_10816_숫자카드2_최태선 {
    static int N,M;
    static int[] count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = new int[20000055];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int a = Integer.parseInt(st.nextToken());
            count[a+10000000] ++;
        }
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            int a = Integer.parseInt(st.nextToken());
            sb.append(count[a+10000000]).append(" ");
        } 
        System.out.println(sb);
    }
}
