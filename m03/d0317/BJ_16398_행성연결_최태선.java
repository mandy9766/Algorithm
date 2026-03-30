import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16398_행성연결_최태선 {
    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int v;
        Edge(int s,int e, int v){
            this.s=s;
            this.e=e;
            this.v=v;
        }
        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.v,o.v);
        }
    }
    static int N;
    static List<Edge> edges;
    static int[] parents;
    static long minVal;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        minVal = 0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int temp = Integer.parseInt(st.nextToken());
                if(j>i && temp != 0)
                    edges.add(new Edge(i, j, temp));
            }
        }
        makeSet();
        Kruskal();
        System.out.println(minVal);

    }
    static void makeSet(){
        parents = new int[N];
        for(int i=0;i<N;i++){
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
        if( parents[rootX]<parents[rootY]){
            parents[rootX] += parents[rootY];
            parents[rootY] = rootX;
        }else{
            parents[rootY] += parents[rootX];
            parents[rootX]= rootY;
        }
        return true;
    }
    static void Kruskal(){
        int count = 0;
        Collections.sort(edges);
        for(Edge edge :edges){
            if(count == N-1)
                return;
            if(union(edge.s, edge.e)){
                minVal += edge.v;
                count ++;
            }
        }
    }
}
