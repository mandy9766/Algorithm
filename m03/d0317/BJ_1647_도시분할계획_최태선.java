import java.io.*;
import java.util.*;

public class BJ_1647_도시분할계획_최태선 {
    static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int v;
        Edge(int a,int b,int v){
            this.a = a;
            this.b = b;
            this.v = v;
        }
        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.v, o.v);
        }
    }
    static int N,M;
    static long minVal;
    static int maxNodeVal;
    static List<Edge> edges;
    static int[] parents;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        minVal = 0;
        maxNodeVal = 0;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a,b,v));
        }
        makeSet();
        kruskal();
        System.out.println(minVal - maxNodeVal);

    }
    static void makeSet(){
        parents = new int[N+1];
        for(int i=1;i<N+1;i++){
            parents[i] = -1;
        }
    }
    static int findSet(int x){
        if(parents[x]<0)
            return x;
        else
            return parents[x] = findSet(parents[x]);
    }
    static boolean union(int x ,int y){
        int rootX = findSet(x);
        int rootY = findSet(y);
        if(rootX == rootY)
            return false;

        if(parents[rootX] < parents[rootY]){
            parents[rootX] += parents[rootY];
            parents[rootY] = rootX;
        }else{
            parents[rootY] += parents[rootX];
            parents[rootX] = rootY;
        }
        return true;
    }
    static void kruskal(){
        Collections.sort(edges);
        for(Edge edge : edges){
            if(union(edge.a, edge.b)){
                minVal+= edge.v;
                maxNodeVal = Math.max(maxNodeVal, edge.v);
            }
        }
        
    }

}
