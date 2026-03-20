package d0320;

import java.io.*;
import java.util.*;

public class BJ_13458_시험감독_최태선 {
    static int N;
    static int[] A;
    static int B , C;
    static long count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        count = 0;
        for(int i=0;i<N;i++){
            A[i] -= B;
        }
        count += N;
        for(int i=0;i<N;i++){
            if(A[i] <=0 )
                continue;
            else{
                count += A[i]/C;
                if(A[i]%C != 0)
                    count ++;
            }
        }
        System.out.println(count);
    }
}
