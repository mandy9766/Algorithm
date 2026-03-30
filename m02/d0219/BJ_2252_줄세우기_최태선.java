package d0219;

import java.io.*;
import java.util.*;

public class BJ_2252_줄세우기_최태선 {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static int[] inDegree;
    static StringBuilder sb;
    static Deque<Integer> deque;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        inDegree = new int[N+1];
        deque = new ArrayDeque<>();
        for (int i=1;i<N+1;i++){
            graph[i] = new ArrayList<>();
        }
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            inDegree[to] ++;
        }
        sb = new StringBuilder();
        topologicalSort();
        System.out.println(sb);

    }
    static void topologicalSort(){
        sb.setLength(0);
        deque.clear();
        for(int i=1;i<N+1;i++){
            if(inDegree[i] ==0){
                deque.add(i);
            }
        }
        while(!deque.isEmpty()){
            int nowNum = deque.poll();
            sb.append(nowNum +" ");
            for(int next : graph[nowNum]){
                inDegree[next] --;
                if(inDegree[next] == 0)
                    deque.add(next);
            }
        }
    }

}
