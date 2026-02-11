package d0211;

import java.util.*;

public class BJ_9663_NQueen_최태선 {
    static int N;
    static boolean[] slash;
    static boolean[] bSlash;
    static boolean[] isSelected;
    static int totalCount;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        slash = new boolean[2*N];
        bSlash = new boolean[2*N];
        isSelected = new boolean[N];
        totalCount = 0;
        Dfs(0);
        System.out.println(totalCount);
    }
    static void Dfs(int depth){
        if(depth == N){
            totalCount++;
            return;
        }
        for(int j=0;j<N;j++){
            if (isSelected[j] == true)
                continue;
            if(slash[j-depth+N] == true)
                continue;
            if(bSlash[j+depth] == true)
                continue;
            isSelected[j] = true;
            slash[j-depth+N] = true;
            bSlash[j+depth] = true;
            Dfs(depth+1);
            isSelected[j] = false;
            slash[j-depth+N] = false;
            bSlash[j+depth] = false;
        }
    }
}
