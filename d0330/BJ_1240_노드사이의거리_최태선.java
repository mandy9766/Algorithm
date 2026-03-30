package d0330;

import java.io.*;
import java.util.*;

public class BJ_1240_노드사이의거리_최태선 {
    static int N,M;
    static List<int[]>[] graph;
    static boolean[] visited;
    static Deque<int[]> deque;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N+1];
        visited = new boolean[N+1];
        deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b,v});
            graph[b].add(new int[]{a,v});
        }
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(bfs(a,b)).append("\n");
        }   
        System.out.println(sb);
    }
    static int bfs(int a,int b){
        Arrays.fill(visited,false);
        deque.clear();
        deque.add(new int[]{a,0});
        visited[a] = true;
        while(!deque.isEmpty()){
            int[] nowNode = deque.poll();
            int nowNum = nowNode[0];
            int nowVal = nowNode[1];
            for(int[] nextNode : graph[nowNum]){
                int nextNum = nextNode[0];
                int nextVal = nextNode[1];
                if(nextNum == b)
                    return nowVal+nextVal;
                if(visited[nextNum] == false){
                    visited[nextNum] = true;
                    deque.add(new int[]{nextNum,nowVal+nextVal});
                }
            }
        }
        return -1;
    }
}
