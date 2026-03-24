package d0324;

import java.io.*;
import java.util.*;

public class BJ_14921_용액합성하기_최태선{
    static int N;
    static long[] arr;
    static long result;
    static long nowSmall, nowBig;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        result = Long.MAX_VALUE;
        StringTokenizer st =  new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int s =0;
        int e =N-1;
        while(s<e){
            long nowVal = arr[s]+ arr[e];
            long absVal = Math.abs(nowVal);
            if(absVal<Math.abs(result)){
                nowSmall = arr[s];
                nowBig = arr[e];
                result = nowVal;
            }
            if(nowVal == 0){
                break;
            }else if(nowVal>0){
                e--;
            }else{
                s++;
            }
        }
        System.out.println(result);
    }
}
