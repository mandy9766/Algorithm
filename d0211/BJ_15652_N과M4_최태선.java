package d0211;

import java.util.Scanner;

public class BJ_15652_N과M4_최태선 {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();
        arr =new int[M];
        duComb(1, 0);
        System.out.println(sb);
    
    }
    static void duComb(int start,int count){
        if(count == M){
            for(int i=0;i<M;i++){
                sb.append(arr[i] +" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<=N;i++){
            arr[count] = i;
            duComb(i, count+1);
        }
    }
}
