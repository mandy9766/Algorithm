package d0203;

import java.io.*;
import java.util.*;

public class BJ_2470_두용액_최태선 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int s = 0;
        int e = N-1;
        long minVal = Long.MAX_VALUE;
        int idxS = -1;
        int idxE = -1;
        while(s<e){
            long sum = arr[s] + arr[e];
            if (Math.abs(sum) < minVal){
                idxS = s;
                idxE = e;
                minVal = Math.abs(sum);
            }
            if (sum>0){
                e--;
            }else{
                s ++;
            }
        }
        System.out.println(arr[idxS] + " " +arr[idxE]);
    }
}
