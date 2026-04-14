package m04.d0411;

import java.io.*;
import java.util.*;

public class SWEA_5643_키순서_최태선 {
    static int T,N,M;
    static List<Integer>[] graph;
    static List<Integer>[] revGraph;
    static boolean[] visited;
    static Deque<Integer> deque;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            graph = new List[N+1];
            revGraph = new List[N+1];
            visited = new boolean[N+1];
            deque = new ArrayDeque<>();
            for(int i=1;i<N+1;i++){
                graph[i] = new ArrayList<>();
                revGraph[i] = new ArrayList<>();
            }
            for(int i=0;i<M;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                revGraph[b].add(a);
            }
            result = 0;
            for(int i=1;i<N+1;i++){
                if(getGraphCount(i) +getRevGraphCount(i) == N-1)
                    result ++;
            }
            System.out.println("#"+t+" "+result);
        }
    }
    static int getGraphCount(int num){
        Arrays.fill(visited, false);
        visited[num] = true;
        deque.clear();
        deque.add(num);
        int count = 0;
        while(!deque.isEmpty()){
            int nowNum = deque.poll();
            for(int nextNum : graph[nowNum]){
                if(visited[nextNum] == false){
                    visited[nextNum] = true;
                    deque.add(nextNum);
                    count++;
                }
            }
        }
        return count;
    }
    static int getRevGraphCount(int num){
        Arrays.fill(visited, false);
        visited[num] = true;
        deque.clear();
        deque.add(num);
        int count = 0;
        while(!deque.isEmpty()){
            int nowNum = deque.poll();
            for(int nextNum : revGraph[nowNum]){
                if(visited[nextNum] == false){
                    visited[nextNum] = true;
                    deque.add(nextNum);
                    count++;
                }
            }
        }
        return count;
    }
    
}
