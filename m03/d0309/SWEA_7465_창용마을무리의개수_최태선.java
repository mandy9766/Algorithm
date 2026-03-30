package d0309;

import java.io.*;
import java.util.*;

public class SWEA_7465_창용마을무리의개수_최태선 {
    static int T,N,M;
    static int[] parents;
    static Set<Integer> rootSet;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parents = new int[N+1];
            makeSet();
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }
            rootSet = new HashSet<>();
            for(int i=1;i<=N;i++){
                rootSet.add(findSet(i));
            }
            System.out.println("#"+t+" "+rootSet.size());
            

        }
    }
    static void makeSet(){
        for(int i=1;i<=N;i++){
            parents[i] = i;
        }
    }
    static int findSet(int x){
        if(parents[x] == x)
            return parents[x];
        else
            return parents[x] = findSet(parents[x]);
    }
    static boolean union(int x,int y){
        int rootX = findSet(x);
        int rootY = findSet(y);
        if(rootX == rootY)
            return false;
        else{
            parents[rootY] = rootX;
            return true;
        }
    }
}
