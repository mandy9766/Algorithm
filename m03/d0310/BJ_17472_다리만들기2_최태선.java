package d0310;

import java.io.*;
import java.util.*;

public class BJ_17472_다리만들기2_최태선 {
    static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int v;
        Edge(int a, int b, int v){
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
    static int[][] graph;
    static int[][] revGraph;
    static boolean[][] visited;
    static int number;
    static int[] di ={-1,1,0,0};
    static int[] dj ={0,0,-1,1};
    static int count;
    static Map<Integer,Integer> tempMap;
    static int[] parents;
    static List<Edge> edgeList;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        number = 0;
        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if(visited[i][j] == false && graph[i][j] == 1){
                    number++;
                    bfs(i,j);
                }
            }
        }
        count = number-1; // 최소신장트리를 만족하는 간선의 개수
        tempMap = new HashMap<>();
        revGraph = new int[M][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                revGraph[j][i] = graph[i][j];
            }
        }
        //가로로 쭉 가면서 간선 후보를 map에 등록 및 처리하는 함수를 graph, revGraph에 둘다 돌려서 간선생성
        for(int i=0;i<N;i++){
            makePath(graph, i,M);
        }
        for(int i=0;i<M;i++){
            makePath(revGraph, i , N);
        }
        
        edgeList = new ArrayList<>();
        tempMap.forEach((key,values)->{
            int a = key/100;
            int b = key%100;
            int val = values;
            edgeList.add(new Edge(a,b,val));
        });
        makeSet();
        if(kruscal())
            System.out.println(result);
        else
            System.out.println(-1);


    }
    static void makeSet(){
        parents = new int[number+1];
        for(int i=1;i<number+1;i++){
            parents[i] = -1;
        }
    }
    static int findSet(int x){
        if(parents[x] < 0)
            return x;
        else
            return parents[x] = findSet(parents[x]);
    }
    static boolean union(int x,int y){
        int rootX = findSet(x);
        int rootY = findSet(y);
        if(rootX == rootY)
            return false;
        else{
            if(rootX<rootY){
                parents[rootX] += parents[rootY];
                parents[rootY] = rootX;
            }
            else{
                parents[rootY] += parents[rootX];
                parents[rootX] = rootY;
            }
            return true;
        }
    }
    static boolean kruscal(){
        int nowCount = 0;
        result = 0;
        Collections.sort(edgeList);
        int size = edgeList.size();
        for(int i=0;i<size;i++){
            Edge nowEdge = edgeList.get(i);
            int nowA = nowEdge.a;
            int nowB = nowEdge.b;
            int nowV = nowEdge.v;
            if(union(nowA,nowB)){
                result += nowV;
                nowCount ++;
                if(nowCount == count)
                    return true;
            }
        }
        return false;
    }

    static void bfs(int i,int j){ // number로 바꿈 각 graph값을 
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i,j});
        visited[i][j] = true;
        while(!deque.isEmpty()){
            int[] now = deque.poll();
            int nowI = now[0];
            int nowJ = now[1];
            graph[nowI][nowJ] = number;
            for(int k=0;k<4;k++){
                int ni = nowI + di[k];
                int nj = nowJ + dj[k];
                if(ni>=0 && ni<N && nj>=0 && nj<M && visited[ni][nj]== false && graph[ni][nj]== 1)
                {
                    visited[ni][nj] = true;
                    deque.add(new int[]{ni,nj});
                }
            }
        }
    }
    static void makePath(int [][] nowGraph, int i, int maxJ){
        int past = 0;
        int count=0;
        for(int j=0;j<maxJ;j++){
            if (nowGraph[i][j] == 0){
                if (past != 0)
                    count ++;
            }
            else{ 
                if(past == 0){
                    count = 0;
                    past = nowGraph[i][j];
                }
                else{
                    if(count >=2){
                        int nowNum = nowGraph[i][j];
                        int a,b;
                        if(nowNum>past){
                            a = past;
                            b = nowNum;
                        }else{
                            a = nowNum;
                            b = past;
                        }
                        if (tempMap.containsKey(a*100+b)){
                            int val = tempMap.get(a*100+b);
                            int minVal = Math.min(val,count);
                            tempMap.put(a*100+b,minVal);
                        }
                        else{
                            tempMap.put(a*100+b,count);
                        }
                    }
                    past = nowGraph[i][j];
                    count =0;
                }
            }
                
        }
    }
}
