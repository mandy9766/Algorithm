
import java.io.*;
import java.util.*;

public class BJ_1368_물대기_최태선{
    static class Edge implements Comparable<Edge>{ 
        int s;
        int e;
        int v;
        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.v, o.v);
        }
    }
    static int N;
    static int [] W;
    static List<Edge> edges;
    static int[] parents;
    static int minVal;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N+1];
        edges = new ArrayList<>();
        minVal = 0;
        for(int i=1;i<N+1;i++){
            W[i] = Integer.parseInt(br.readLine()); 
            edges.add(new Edge(i, 0, W[i]));
        }    
        for(int i=1;i<N+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp != 0 && j>i)
                    edges.add(new Edge(i, j, temp));
            }
        }
        makeSet();
        Kruskal();
        System.out.println(minVal);
    }
    static void makeSet(){
        parents = new int[N+1];
        for(int i=0;i<N+1;i++){
            parents[i] = -1;
        }
    }
    static int findSet(int x){
        if(parents[x] <0)
            return x;
        else
            return parents[x] = findSet(parents[x]);
    }
    static boolean union(int x,int y){
        int rootX = findSet(x);
        int rootY = findSet(y);
        if(rootX == rootY)
            return false;
        if(rootX < rootY){
            parents[rootX] += parents[rootY];
            parents[rootY] = rootX;
        }else{
            parents[rootY] += parents[rootX];
            parents[rootX] = rootY; 
        }
        return true;
    }
    static void Kruskal(){
        Collections.sort(edges);
        for(Edge edge : edges){
            if(union(edge.s,edge.e)){
                minVal += edge.v;
            }
        }
    }
}
            

    
