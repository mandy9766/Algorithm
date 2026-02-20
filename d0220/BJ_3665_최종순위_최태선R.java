package d0220;

import java.io.*;
import java.util.*;


public class BJ_3665_최종순위_최태선R {
    static int T,N,M;
    static int[] pastOrder;
    static boolean [][] graph;
    static int[] inDegree;
    static StringBuilder sb;
    static boolean isPossible;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            graph = new boolean[N+1][N+1];
            inDegree = new int[N+1];
            pastOrder = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                pastOrder[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<N;i++){
                for (int j=i+1;j<N;j++){
                    graph[pastOrder[i]][pastOrder[j]] = true;
                    inDegree[pastOrder[j]]++;
                }
            }
            M = Integer.parseInt(br.readLine());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                if(graph[num1][num2] == true){
                    graph[num1][num2] = false;
                    inDegree[num2] --;
                    graph[num2][num1] = true;
                    inDegree[num1]++;

                }else if(graph[num2][num1] == true){
                    graph[num2][num1] = false;
                    inDegree[num1] --;
                    graph[num1][num2] = true;
                    inDegree[num2] ++;
                }
            }
            sb= new StringBuilder();
            if(!topologicalSort()){ // 일관성없음
                System.out.println("IMPOSSIBLE");
            }else{
                if(isPossible)
                    System.out.println(sb);
                else{
                    System.out.println("?");
                }
            }
            

        }    
    }
    static boolean topologicalSort(){
        Deque<Integer> deque = new ArrayDeque<>();
        isPossible = true;
        for(int i=1;i<=N;i++){
            if(inDegree[i] == 0)
                deque.add(i);
        }
        int count = 0;
        while(!deque.isEmpty()){
            if(deque.size()> 1)
                isPossible = false;
            int num = deque.poll();
            sb.append(num).append(" ");
            count ++;
            for(int i=1;i<=N;i++){
                if(graph[num][i] == true){
                    graph[num][i] =false; //간선제거
                    inDegree[i]--;
                    if(inDegree[i] == 0)
                        deque.add(i);
                }
            }
        }
        if(count != N)
            return false;
        else
            return true;
    }
   
}
