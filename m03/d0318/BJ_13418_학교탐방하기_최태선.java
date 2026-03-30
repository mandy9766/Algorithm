package d0318;

import java.io.*;
import java.util.*;

public class BJ_13418_학교탐방하기_최태선 {
    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int v;
        Edge(int s,int e,int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }
        public int compareTo(Edge o){
            return Integer.compare(this.v, o.v);
        }
    }
    static int N,M;
    static int minVal;
    static int maxVal;
    static Edge[] edges;
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M+1];

        for(int i=0;i<M+1;i++){
            st =new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s, e, v);
        }
        kruskal();
        System.out.println(maxVal*maxVal-minVal*minVal);
    }
    static void makeSet(){
        parents = new int[N+1];
        for(int i=0;i<N+1;i++){
            parents[i] = -1;
        }
    }
    static int findSet(int x){
        if(parents[x] < 0)
            return x;
        else
            return parents[x] = findSet(parents[x]);
    }
    static boolean union(int x, int y){
        int rootX = findSet(x);
        int rootY = findSet(y);
        if(rootX == rootY)
            return false;
        if(parents[rootX] < parents[rootY]){
            parents[rootX] += parents[rootY];
            parents[rootY] = rootX;
        }
        else{
            parents[rootY] += parents[rootX];
            parents[rootX] = rootY;
        }
        return true;
    }
    static void kruskal(){
        minVal = 0;
        maxVal = 0;
        // 최대값
        int count =0;
        makeSet();
        Arrays.sort(edges);
        for(int i=0;i<M+1;i++){
            if(union(edges[i].s,edges[i].e)){
                if(edges[i].v == 0)
                    maxVal+= 1;
                count ++;
            }
            if(count == N)
                break;
        }
        // 최소값
        count =0;
        makeSet();
        Arrays.sort(edges,Collections.reverseOrder());
        for(int i=0;i<M+1;i++){
            if(union(edges[i].s,edges[i].e)){
                if(edges[i].v == 0)
                    minVal+= 1;
                count ++;
            }
             if(count == N)
                break;
        }
    }
}
