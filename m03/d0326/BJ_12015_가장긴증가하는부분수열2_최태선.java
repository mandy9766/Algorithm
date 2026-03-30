package d0326;

import java.io.*;
import java.util.*;

public class BJ_12015_가장긴증가하는부분수열2_최태선 {
    static int N;
    static int[] A;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int s =0;
        int e =0;
        int nowMaxCount= 0;
        int nowMaxVal =0;

        // 처음 처리
        while(e+1<N && A[e] < A[e+1]){
                e++;
        }
        nowMaxCount = e+1;
        nowMaxVal = A[e];
        s = e;
        // 만약 할거 남아있다
        while (true){
            if(e+1<N){
                while(e+1<N && A[e] >= A [e+1] ){
                    e++;
                }
                s = e;
                while(e+1<N && A[e] < A[e+1]){
                    e++;
                }
                if(s == e)
                    break;
                int tempMaxVal = e-s +1;
                while (s<=e && A[s]<= nowMaxVal){
                    s++;
                }
                int tempMaxVal2 = e-s+1+nowMaxCount;
                nowMaxVal = A[e];
                nowMaxCount = Math.max(tempMaxVal,tempMaxVal2);
            }else{
                break;
            }
        }
        System.out.println(nowMaxCount);
        
    }
}
