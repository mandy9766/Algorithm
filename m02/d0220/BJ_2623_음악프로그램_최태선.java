package d0220;

import java.io.*;
import java.util.*;


public class BJ_2623_음악프로그램_최태선 {
    static int N,M;
    static int[] inDegree;
    static List<Integer>[] graph;
    static int[] order;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        inDegree = new int[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int count = Integer.parseInt(st.nextToken());
            if(count !=0){
                order = new int[count];
                for(int j=0;j<count;j++){
                    order[j] = Integer.parseInt(st.nextToken());
                }
                for(int j=0;j<count-1;j++){
                    int from = order[j];
                    int to = order[j+1];
                    graph[from].add(to);
                    inDegree[to] ++;
                }
            }
        }
        sb = new StringBuilder();
        if(topologicalSort()){
            System.out.println(sb);
        }else{
            System.out.println(0);
        }

    }
    static boolean topologicalSort(){
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            if(inDegree[i] == 0){
                deque.add(i);
            }
        }
        int count = 0;
        while(!deque.isEmpty()){
            int now = deque.poll();
            count ++;
            sb.append(now+"\n");
            for(int next :graph[now]){
                inDegree[next]--;
                if(inDegree[next] == 0)
                    deque.add(next);
            }
        }
        if(N != count)
            return false;
        else{
            return true;
        }
    }
}
