import java.io.*;
import java.util.*;


public class BJ_1806_부분합_최태선 {
    static int N,S;
    static int[] original;
    static int nowSum;
    static int minVal;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        original = new int[N];
        minVal = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            original[i] = Integer.parseInt(st.nextToken());
        }
        int s1 = 0;
        int s2 = 0;
        nowSum = 0;
        while(true){
            if(nowSum >= S){
                minVal = Math.min(minVal, s2-s1);
                nowSum -= original[s1];
                s1++;
            }else if(s2 == N){
                break;
            }else{
                nowSum += original[s2];
                s2++;
            }
           
        }
        if(minVal == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(minVal);
    }

}
