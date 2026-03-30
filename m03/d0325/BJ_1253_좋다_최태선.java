package d0325;

import java.io.*;
import java.util.*;

public class BJ_1253_좋다_최태선 {
    static int N;
    static int[] arr;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            check(i); // i를 검증 (가능한지)
        }
        System.out.println(result);
    }    
    static void check(int targetIdx){
        int target = arr[targetIdx];
        int left;
        int right;
        if (targetIdx==0)
            left= 1;
        else{
            left = 0;
        }
        if (targetIdx==N-1)
            right = N-2;
        else{
            right = N-1;
        }
        while(left<right){
            if(target == arr[left]+arr[right]){
                result ++;
                return;
            }
            else if (arr[left]+arr[right] < target){
                left++;
                if(left == targetIdx)
                    left++;
            }
            else{
                right--;
                if(right== targetIdx)
                    right--;
            }
                
        }
        return;
    }
}
