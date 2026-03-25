package d0325;

import java.io.*;
import java.util.*;

public class BJ_7453_합이0인네정수_최태선R {
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
        Arrays.sort(AB);
        Arrays.sort(CD);
        int left = 0;
        int right = CDIdx-1;
        while(left<ABIdx && right>=0){
            int nowVal = AB[left] + CD[right];
            if (nowVal== 0){
                int leftCount = 1;
                int nextLeft = left+1;
                while(nextLeft<ABIdx && AB[left] == AB[nextLeft]){
                    leftCount++;
                    left ++;
                    nextLeft ++; 
                }
                int rightCount = 1;
                int nextRight = right-1;
                while(nextRight>=0 && CD[right] == CD[nextRight]){
                    rightCount++;
                    right--;
                    nextRight--;
                    
                }
                count += (long)leftCount *rightCount;
                left++;
                right--;
            }
            else if(nowVal>0){
                right --;
            }else
            {
                left++;
            }
        }
        System.out.println(count);
    }
}
