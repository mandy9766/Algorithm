package d0324;
import java.io.*;
import java.util.*;

public class BJ_2143_두배열의합_최태선 {
    static int T,N,M;
    static int[] A ,B;
    static List<Long> resultA,resultB;
    static long count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A= new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        resultA = new ArrayList<>();
        resultB = new ArrayList<>();
        for(int i=0;i<N;i++){
            long sum = 0;
            for(int j=i;j<N;j++){
                sum += A[j];
                resultA.add(sum);
            }
        }
        for(int i=0;i<M;i++){
            long sum = 0;
            for(int j=i;j<M;j++){
                sum += B[j];
                resultB.add(sum);
            }
        }
        int sizeB = resultB.size();
        int sizeA = resultA.size();
        Collections.sort(resultA);
        for (int i=0;i<sizeB;i++){
            long nowVal = resultB.get(i);
            int lower = lowerBound(0, sizeA, T-nowVal);
            int upper = upperBound(0, sizeA, T-nowVal);
            count += upper - lower;
        }
        System.out.println(count);
    }   
    static int lowerBound(int s,int e, long target){ // 타겟값으로 T-B 넣을것
        int left = s;
        int right = e;
        while(left<right){
            int mid = (left+right)/2;
            if(resultA.get(mid)>= target){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    static int upperBound(int s,int e, long target){ // 타겟값으로 T-B 넣을것
        int left = s;
        int right = e;
        while(left<right){
            int mid = (left+right)/2;
            if(resultA.get(mid)> target){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    } 
}
