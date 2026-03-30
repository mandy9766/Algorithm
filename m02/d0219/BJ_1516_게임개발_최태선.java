package d0219;

import java.io.*;
import java.util.*;
public class BJ_1516_게임개발_최태선 {
    static int N;
    static List<Integer>[] graph;
    static int[] inDegree;
    static int[] result;
    static int[] time;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        result = new int[N+1];
        time = new int[N+1];
        inDegree = new int[N+1];
        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=1;i<N+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            time[i]  = Integer.parseInt(st.nextToken());
            while(true){
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1)
                    break;
                int from = temp;
                graph[from].add(i);
                inDegree[i] ++;
            }
        }
        for(int i=1;i<N+1;i++){
            result[i] = time[i];
        }
        topologicalSort();
        for(int i=1;i<N+1;i++){
            System.out.println(result[i]);
        }

    }
    static void topologicalSort(){
        Deque <Integer> deque = new ArrayDeque<>();
        for(int i=1;i<N+1;i++){
            if(inDegree[i] == 0 ){
                deque.add(i);
            }
        }
        while(!deque.isEmpty()){
            int nowItem = deque.poll();
            for(int next : graph[nowItem]){
                result[next] =Math.max(result[next],result[nowItem]+ time[next]);
                inDegree[next] --;
                if(inDegree[next] == 0){
                    deque.add(next);
                }
            }
        }
    }
}
