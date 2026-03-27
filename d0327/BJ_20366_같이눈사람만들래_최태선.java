package d0327;

import java.io.*;
import java.util.*;

public class BJ_20366_같이눈사람만들래_최태선 {
    static int N;
    static int[] arr;
    static int minVal;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        minVal = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                int snowMan1 = arr[j] + arr[i];
                int tempMin = twoPointer(i,j,snowMan1);
                minVal = Math.min(minVal,tempMin);
            }
        }
        System.out.println(minVal);
    }
    static int twoPointer(int s, int e,int target){
        int minVal = Integer.MAX_VALUE;
        int left = 0;
        int right= N-1;
        while(left<right){
            if (left== s ||left ==e){
                left ++;
                continue;
            }
            if(right==s || right==e){
                right --;
                continue;
            }
            int nowSum = arr[left] +arr[right];
            minVal = Math.min(minVal,Math.abs(target-nowSum));
            if(nowSum == target)
                return 0;
            if(nowSum>target){
                right--;
            }else{
                left++;
            }
        }
        return minVal;
    }
}
