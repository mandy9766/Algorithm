package d0324;

import java.io.*;
import java.util.*;

public class BJ_3151_합이0_최태선 {
    static int N;
    static int[] A;
    static long count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        count =0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                int person1 = A[i];
                int person2 = A[j];
                int target = -(person2+person1);
                int s = j+1;
                int e = N;
                int nowLower = lowerBound(s, e, target);
                int nowUpper = upperBound(s,e,target);
                count += nowUpper - nowLower;
            }
        }
        System.out.println(count);
    }   
    static int lowerBound(int s,int e,int target){
        int left = s;
        int right = e;
        while(left< right){
            int mid = (left+right)/2;
            if (A[mid] >= target){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    static int upperBound(int s,int e,int target){
        int left = s;
        int right = e;
        while(left< right){
            int mid = (left+right)/2;
            if (A[mid] > target){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
}
