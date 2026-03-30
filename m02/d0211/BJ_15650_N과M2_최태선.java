package d0211;

import java.util.Scanner;

public class BJ_15650_N과M2_최태선 {
    static int N;
    static int M;
    static int[] result;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int[M];
        // 1부터 start 
        comb(1,0);
        System.out.println(sb);
    }
    static void comb(int start,int count){
        if (count == M){
            for(int i=0;i<M;i++)
                sb.append(result[i] +" ");
            sb.append("\n");
            return;
        }
        for(int i=start;i<=N;i++){
            result[count] = i;
            comb(i+1,count+1);
        }
    }
}
