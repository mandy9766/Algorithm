package m04.d0401;

import java.io.*;
import java.util.*;

public class BJ_20955_민서의응급수술_최태선 {
    static int[] parents;
    static int N,M;
    static int count;
    static int linkedCount;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        count = 0;
        linkedCount = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        makeSet();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(union(a, b)){
                linkedCount ++;
            }else{
                count ++;
            }
        }
        count += (N-1) - linkedCount;
        System.out.println(count);
    }
    static void makeSet(){
        parents = new int[N+1];
        for(int i=1;i<N+1;i++){
            parents[i] = -1;
        } 
    }
    static int findSet(int x ){
        if(parents[x]<0)
            return x;
        else
            return parents[x] = findSet(parents[x]);
    }
    static boolean union(int x, int y){
        int rootX = findSet(x);
        int rootY = findSet(y);
        if(rootX == rootY){
            return false;
        }
        else if(parents[rootX] < parents[rootY]){
            parents[rootX] += parents[rootY];
            parents[rootY] = rootX;
        }else{
            parents[rootY] += parents[rootX];
            parents[rootX] = rootY;
        }
        return true;
    }
}
