package d0219;

import java.io.*;
import java.util.*;

public class BJ_1766_문제집_최태선 {
    static int N,M;
    static PriorityQueue<Integer> pq;
    static PriorityQueue<Integer>[] graph;
    static int[] inDegree;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N+1];
        graph = new PriorityQueue[N+1];
        for(int i=1;i<N+1;i++){
            graph[i] = new PriorityQueue<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            inDegree[to]++;
        }
        topologicalSort();
        System.out.println(sb);

    }
    static void topologicalSort(){
        sb.setLength(0);
        pq = new PriorityQueue<>();
        for(int i=1;i<N+1;i++){
            if(inDegree[i] == 0){
                pq.add(i);
            }
        }
        int count = 0;
        while(!pq.isEmpty()){
            count ++;
            int num = pq.poll();
            sb.append(num+" ");
            for(int next : graph[num]){
                inDegree[next] --;
                if(inDegree[next] == 0){
                    pq.add(next);
                }
            }
        }
        if(count != N){
            System.out.println("오류");
        }
    }
}
