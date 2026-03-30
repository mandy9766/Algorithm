package d0211;

import java.util.Scanner;

public class BJ_15651_N과M3_최태선 {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sb = new StringBuilder();
        arr = new int[M];
        duPerm(0);
        System.out.println(sb);        
    }
    static void duPerm(int depth){
        if(depth == M){
            for(int i=0;i<M;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=N;i++){
            arr[depth] = i;
            duPerm(depth+1);
        }
    }
}
