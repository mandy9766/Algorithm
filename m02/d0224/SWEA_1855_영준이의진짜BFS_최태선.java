package d0224;

import java.io.*;
import java.util.*;


public class SWEA_1855_영준이의진짜BFS_최태선 {
    static int T,N;
    static int[] rev_graph;
    static List<Integer> bfsOrder;
    static List<Integer>[] graph;
    static int[] indegree;
    static boolean[] visited;
    static int pastNode,nowNode,sameParentNode;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            bfsOrder = new ArrayList<>();
            graph = new ArrayList[N+1];
            rev_graph = new int[N+1];
            indegree = new int[N+1];
            visited = new boolean[N+1];
            indegree[1] = 0;
            for(int i=0;i<=N;i++){
                graph[i] = new ArrayList<>();
            }
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N-1;i++){
                int root = Integer.parseInt(st.nextToken());
                // i+2번째의 루트는 root
                graph[root].add(i+2);
                rev_graph[i+2] = root;
                indegree[i+2] = indegree[root]+1;
            }
            bfs();
            int result = 1; // 두번째꺼까지 하는데 1번이면됨
            if(N>1){
                pastNode = bfsOrder.get(1); // 이전거를 pastNode로 
                for(int i=2;i<N;i++){
                    nowNode = bfsOrder.get(i);
                    sameParentNode = getSameParent(pastNode,nowNode);
                    result += indegree[pastNode] - indegree[sameParentNode];
                    result += indegree[nowNode] - indegree[sameParentNode];
                    pastNode = nowNode;
                }
                System.out.println("#"+t+" "+ result);
            }else{
                System.out.println("#"+t+" "+0);
            }
        }
    }
    static int getSameParent(int past,int now){
        Arrays.fill(visited, false);
        visited[past] = true;
        while(true){
            int nextNode = rev_graph[past];
            visited[nextNode] = true;
            if(nextNode == 1)
                break;
            past = nextNode;
        }
        while(true){
            int nextNode = rev_graph[now];
            if(visited[nextNode] == true)
                return nextNode;
            now = nextNode;
        }
    }
    static void bfs(){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        while(!deque.isEmpty()){
            int nowNode = deque.poll();
            bfsOrder.add(nowNode);
            for(int next : graph[nowNode]){
                deque.add(next);
            }
        }
    }
}
