package d0325;

import java.io.*;
import java.util.*;

// 25
public class BJ_7453_합이0인네정수_최태선 {
    static int N;
    static int[] A,B,C,D,AB,CD;
    static int ABIdx,CDIdx;
    static long count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];   
        AB = new int[N*N];
        CD = new int[N*N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken()); 
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        ABIdx = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                AB[ABIdx] = A[i]+B[j];
                ABIdx ++;
            }
        }
        CDIdx = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                CD[CDIdx] = C[i]+D[j];
                CDIdx++;
            }
        }
        count = 0;
        Arrays.sort(CD);
        for(int i=0;i<ABIdx;i++){
            int nowVal = AB[i];
            int lower = lowerBound(nowVal);
            int upper = upperBound(nowVal);
            count += upper - lower;
        }
        System.out.println(count);
    }
    static int lowerBound(int nowVal){
        int left = 0;
        int right = CDIdx;
        int target = -nowVal;
        while(left<right){
            int mid = (left+right)/2;
            if(CD[mid]>= target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    static int upperBound(int nowVal){
        int left = 0;
        int right = CDIdx;
        int target = -nowVal;
        while(left<right){
            int mid = (left+right)/2;
            if(CD[mid]> target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
