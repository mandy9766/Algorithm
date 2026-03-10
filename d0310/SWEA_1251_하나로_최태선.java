package d0310;

import java.io.*;
import java.util.*;

public class SWEA_1251_하나로_최태선 {

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        double weight;
        Edge(int start,int end,double weight){
            this.start = start;
            this.end = end;
            this.weight=  weight;
        }
        @Override
        public int compareTo(Edge o){
            return Double.compare(this.weight,o.weight);
        }

    }
    static int T,N;
    static double E;
    static int[] posX,posY;
    static int[] parents;
    static int count;
    static double result;
    static List<Edge> edgeList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            posX = new int[N];
            posY = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                posX[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                posY[i] = Integer.parseInt(st.nextToken());
            }
            E = Double.parseDouble(br.readLine());
            edgeList = new ArrayList<>();
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    double dx = posX[i]-posX[j];
                    double dy = posY[i]-posY[j];
                    edgeList.add(new Edge(i,j,E*(dx*dx +dy*dy)));
                }
            }
            Collections.sort(edgeList);
            int size = edgeList.size();
            count =0;
            result = 0;
            makeSet();
            for(int i=0;i<size;i++){
                Edge nowEdge = edgeList.get(i);
                int a = nowEdge.start;
                int b = nowEdge.end;
                double weight = nowEdge.weight;
                if(union(a, b)){
                    result += weight;
                    count ++;
                    if(count == N-1)
                        break;
                }
            }
            System.out.println("#"+t+" "+Math.round(result));
        }
    }
    static void makeSet(){
        parents = new int[N];
        for(int i=0;i<N;i++){
            parents[i] = -1;
        }
    }
    static int findSet(int x){
        if(parents[x] <0)
            return x;
        else
            return parents[x] = findSet(parents[x]);
    }
    static boolean union(int x, int y){
        int rootX = findSet(x);
        int rootY = findSet(y);
        if(rootX == rootY)
            return false;
        if(rootX<rootY){
            parents[rootX] += parents[rootY];
            parents[rootY] = rootX;
        }else{
            parents[rootY] += parents[rootX];
            parents[rootX] = rootY;
        }
        return true;
    }

}
