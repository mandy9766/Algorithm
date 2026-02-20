package d0220;

import java.io.*;
import java.util.*;


public class SWEA_1267_작업순서_최태선 {
    static int V,E;
    static List<Integer>[] graph;
    static int[] inDegree;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        for(int t=1;t<=10;t++){

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            inDegree = new int[V+1];
            graph = new ArrayList[V+1];
            for(int i=1;i<V+1;i++){
                graph[i] = new ArrayList<>();
            }
            for(int i=0;i<E;i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                inDegree[to] ++;
            }
            sb.setLength(0);
            sb.append("#"+t+ " ");
            topologicalSort();
            System.out.println(sb);

        }
    }
    static void topologicalSort(){
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1;i<V+1;i++){
            if(inDegree[i] == 0){
                deque.add(i);
            }
        }
        while(!deque.isEmpty()){
            int num = deque.poll();
            sb.append(num+" ");
            for(int next : graph[num]){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    deque.add(next);
                }
            }
        }
    }
}
