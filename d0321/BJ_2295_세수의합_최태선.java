package d0321;

import java.io.*;
import java.util.*;

public class BJ_2295_세수의합_최태선 {
    static int N;
    static int[] originalArr;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        originalArr = new int[N];
        for(int i=0;i<N;i++){
            originalArr[i] = Integer.parseInt(br.readLine());
        }
        arr = new int[N*N];
        int idx = 0;
        for(int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                arr[idx] = originalArr[i] + originalArr[j];
                idx ++;
            }
        }
        // 정렬된 x+y 배열
        Arrays.sort(arr);
        Arrays.sort(originalArr);
        boolean isDone = false;
        for(int i=N-1;i>=0;i--){
            for(int j=N-1;j>=0;j--){
                int k = originalArr[i];
                int z = originalArr[j];
                if(Arrays.binarySearch(arr, k-z) >=0){
                    System.out.println(k);
                    isDone = true;
                    break;
                }
            }
            if (isDone)
                break;
        }
    }
    
}
