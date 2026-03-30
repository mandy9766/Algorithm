package d0211;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_15654_N과M5_최태선 {
    static int N;
    static int M;
    static int[] result;
    static int[] original;
    static boolean[] isSelected;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int[M];
        original = new int[N];
        isSelected = new boolean[N];
        sb = new StringBuilder();
        for(int i=0;i<N;i++){
            original[i] = sc.nextInt();
        }
        Arrays.sort(original);
        perm(0);
        System.out.println(sb);
        
    }
    static void perm(int count){
        if(count == M){
            for(int i=0;i<M;i++){
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=0;i<N;i++){
            if(isSelected[i])
                continue;
            isSelected[i]= true;
            result[count] = original[i];
            perm(count+1);
            isSelected[i] =false;
        }

    }
}
