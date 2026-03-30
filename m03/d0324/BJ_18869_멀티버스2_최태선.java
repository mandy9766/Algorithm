package d0324;

import java.io.*;
import java.util.*;

public class BJ_18869_멀티버스2_최태선 {
    static int M,N;
    static int[][] universe;
    static int[][] originalUniverse;
    static int count;
    static Map<Integer,Integer> rankMap;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        universe = new int[M][N];
        originalUniverse = new int[M][N];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int a = Integer.parseInt(st.nextToken());
                originalUniverse[i][j] = a;
                universe[i][j] = a;
            }
        }
        rankMap = new HashMap<>();
        for(int i=0;i<M;i++)
        {
            Arrays.sort(universe[i]);
            int rank = 0;
            rankMap.clear();
            for(int j=0;j<N;j++){
                if(rankMap.containsKey(universe[i][j]) == false){
                    rankMap.put(universe[i][j],rank);
                    rank++;
                }
            }
            for(int j=0;j<N;j++){
                universe[i][j] = rankMap.get(originalUniverse[i][j]);
            }
        }
        count = 0;
        for(int i=0;i<M;i++){
            for(int j=i+1;j<M;j++){
                if(check(i,j)){
                    count ++;
                }
            }
        }   
        System.out.println(count);
    }
    static boolean check(int a,int b){
        for(int i=0;i<N;i++){
            if(universe[a][i] != universe[b][i])
                return false;
        }
        return true;
    }
}
