package d0310;

import java.io.*;
import java.util.*;

public class SWEA_1247_최적경로_최태선 {
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;
        Edge(int start, int end,int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight,o.weight);
        }
    }
    static void makeSet(){
        parents = new int[N+2];
        for(int i=0;i<N+2;i++){
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
        if(rootX <rootY){ // rootX가 더깊음
            parents[rootX] += parents[rootY];
            parents[rootY] = rootX;
        }
        else{ // rootY가 더 깊음
            parents[rootY] += parents[rootX];
            parents[rootX] = rootY;
        }
        return true;
    }
    static int T,N;
    static int[][] pos;
    static int[] parents;
    static List<Edge> edgeList;
    static int result;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            pos = new int[N+2][2];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N+2;i++){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                pos[i][0] = x;
                pos[i][1] = y;
            }
            edgeList = new ArrayList<>();
            for(int i=0;i<N+2;i++){
                for(int j=i+1;j<N+2;j++){
                    int x1 = pos[i][0];
                    int y1 = pos[i][1];
                    int x2 = pos[j][0];
                    int y2 = pos[j][1];
                    int weight = Math.abs(x1-x2) + Math.abs(y1-y2);
                    edgeList.add(new Edge(i,j,weight));
                }
            }
            if(kruscal()== false)
                System.out.println("불가");
            else
                System.out.println("#"+t+" "+result);
        }
    }
    static boolean kruscal(){
        Collections.sort(edgeList);
        makeSet();
        int size= edgeList.size();
        count = 0;
        result = 0;
        for(int i=0;i<size;i++){
            Edge nowEdge = edgeList.get(i);
            int start = nowEdge.start;
            int end = nowEdge.end;
            int weight = nowEdge.weight;
            if(union(start,end)){
                result += weight;
                count ++;
                if(count == N+1){
                    return true;
                }
            }
        }
        return false;
    }
}
