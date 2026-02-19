package d0219;

import java.io.*;
import java.util.*;

public class BJ_14567_선수과목_최태선 {
    static int N;
    static int M;
    static List<Integer> [] graph;
    static int[] inDegree;
    static Deque<int[]> deque;
    static int[] doneDayArray;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        inDegree = new int[N+1];
        doneDayArray = new int[N+1];
        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            inDegree[to] ++ ;
        }
        topologicalSort();
        sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            sb.append(doneDayArray[i]+" ");
        }
        System.out.println(sb);

    }
    static void topologicalSort(){
        deque = new ArrayDeque<>();
        int count = 0;
        for(int i=1;i<N+1;i++){
            if(inDegree[i] == 0)
                deque.add(new int[]{i,1}); // 첫번째로 
        }
        while(!deque.isEmpty()){
            count ++;
            int[] temp = deque.poll();
            int doneIdx = temp[0];
            int doneDay = temp[1];
            doneDayArray[doneIdx] = doneDay;
            for(int next : graph[doneIdx]){
                inDegree[next] --;
                if(inDegree[next] == 0){
                    deque.add(new int[]{next,doneDay+1});
                }
            }
        }
        if(count != N)
            System.out.println("오류");
    }
    
}
