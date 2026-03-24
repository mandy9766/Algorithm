package d0324;
import java.io.*;
import java.util.*;

public class BJ_16401_과자나눠주기_최태선 {
    static int N,M;
    static int[] candy;
    static int maxVal;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        candy = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            candy[i] = Integer.parseInt(st.nextToken());
        }
        maxVal = 0;
        Arrays.sort(candy);
        
        int s =1;
        int e = candy[N-1];
        while(s<=e){
            int mid = (s+e)/2;
            int count = 0;
            for(int i=N-1;i>=0;i--){
                count += candy[i]/mid; 
            }
            if(count >= M)
            {
                maxVal = Math.max(maxVal,mid);
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        
        System.out.println(maxVal);
    }
}
