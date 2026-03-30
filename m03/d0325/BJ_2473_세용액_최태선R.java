package d0325;

import java.io.*;
import java.util.*;

public class BJ_2473_세용액_최태선R {
    static int N;
    static int[] arr;
    static long result;
    static int [] resultArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result = Long.MAX_VALUE;
        Arrays.sort(arr);
        resultArr = new int[3];
        for(int i=0;i<N;i++){
            twoPointer(i);
        }
        Arrays.sort(resultArr);
        System.out.println(resultArr[0]+" "+resultArr[1] + " " + resultArr[2]);
    }
    static void twoPointer(int nowI){
        int left;
        int right;
        if(nowI == 0)
            left =1;
        else
            left =0;
        if(nowI == N-1)
            right = N-2;
        else
            right = N-1;

        while(left<right){
            long nowSum = (long)arr[left] + arr[right] + arr[nowI];
            if(Math.abs(nowSum) < result){
                result = Math.abs(nowSum);
                resultArr[0] = arr[left];
                resultArr[1] = arr[right];
                resultArr[2] = arr[nowI];
            }
            if(nowSum>0){
                right --;
                if(right == nowI)
                    right--;
            }else{
                left ++;
                if(left == nowI)
                    left++;
            }
        }
        return;
    }
}
