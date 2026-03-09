package d0309;

import java.io.*;
import java.util.*;

public class BJ_2611_자동차경주 {
    static int N,M;
    static int[] indegree, maxVal;
    static List<int[]>[] graph;
    static int[] path;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        path = new int[N+1];
        graph = new ArrayList[N+1];
        for (int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        indegree = new int[N+1];
        maxVal = new int[N+1];
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e,val});
            indegree[e] ++;
        }
        topologicalSort();
        System.out.println(maxVal[1]);
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int now = 1;
        deque.add(1);
        while(true){
            now = path[now];
            deque.addFirst(now);
            if(now == 1)
                break;
        }
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst()).append(" ");
        }
        System.out.println(sb);
        
    }
    static void topologicalSort(){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{1,0});
        while(!deque.isEmpty()){
            int[] nowNode = deque.poll();
            int num = nowNode[0];
            int val = nowNode[1];
            for(int[] nextNode : graph[num]){
                int nextNum = nextNode[0];
                int nextVal = nextNode[1];
                int tempVal = val + nextVal;
                indegree[nextNum] --;
                if(maxVal[nextNum] <tempVal){
                    maxVal[nextNum] = tempVal;
                    path[nextNum] = num;
                }
                if(nextNum == 1)
                    continue;
                if(indegree[nextNum] == 0){
                    deque.add(new int[]{nextNum,maxVal[nextNum]});
                }
            }
        }
    }
}
