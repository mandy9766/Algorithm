package d0206;

import java.io.*;
import java.util.*;

public class SWEA_3421_수제버거장인_최태선 {
    static int[][] bannedCase;
    static boolean[] used;
    static int totalCount;
    static int N,M;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            bannedCase = new int[N+1][N+1];
            used = new boolean[N+1];
            totalCount = 0;
            for (int k=0;k<M;k++){
                st = new StringTokenizer(br.readLine()," ");
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                bannedCase[i][j] = 1;
                bannedCase[j][i] = 1;
            }
            subSet(1);
            System.out.println("#"+(t+1) +" "+totalCount);

        }


    }
    public static void subSet(int idx){ // idx는 1부터
        if (idx == N+1){
            totalCount ++;
            return;
        }
        else{
            if (check(idx)){ // bannedCase에 지금까지 사용한거랑 겹치는게 없으면
                used[idx] = true;
                subSet(idx+1);
                used[idx] = false;
            }
            subSet(idx+1);
        }
    }
    public static boolean check(int idx){
        for(int k=1;k<idx;k++){ // k~idx-1까지 used[] 중 뽑힌것중에 idx값이랑 banned 되어있는게 있으면 false
            if(used[k] == true && bannedCase[k][idx] == 1){
                return false;
            }
        }
        return true;
    }
}
