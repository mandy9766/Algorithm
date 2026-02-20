package d0220;

import java.io.*;
import java.util.*;


public class BJ_3665_최종순위_최태선 {
    static int T,N,M;
    static int[] pastOrder;
    static Set<Integer>[] graph;
    static int[] inDegree;
    static StringBuilder sb;
    static boolean isPossible;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            graph = new HashSet[N+1];
            inDegree = new int[N+1];
            for(int i=1;i<=N;i++){
                graph[i] = new HashSet<>();
            }
            pastOrder = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                pastOrder[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<N;i++){
                for (int j=i+1;j<N;j++){
                    graph[pastOrder[i]].add(pastOrder[j]);
                    inDegree[pastOrder[j]]++;
                }
            }
            M = Integer.parseInt(br.readLine());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                if(graph[num1].contains(num2)){
                    graph[num1].remove(num2);
                    inDegree[num2] --;
                    graph[num2].add(num1);
                    inDegree[num1]++;

                }else if(graph[num2].contains(num1)){
                    graph[num2].remove(num1);
                    inDegree[num1] --;
                    graph[num1].add(num2);
                    inDegree[num2] ++;
                }
            }
            sb= new StringBuilder();
            isPossible = checkCan1();
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
        for(int i=1;i<=N;i++){
            if(inDegree[i] == 0)
                deque.add(i);
        }
        int count = 0;
        while(!deque.isEmpty()){
            int num = deque.poll();
            sb.append(num).append(" ");
            count ++;
            for(int next : graph[num]){
                inDegree[next]--;
                if(inDegree[next] == 0)
                    deque.add(next);
            }
        }
        if(count != N)
            return false;
        else
            return true;
    }
    static boolean checkCan1(){
        int[] temp = new int[N+1];
        for(int i=1;i<N+1;i++){
            temp[i] = inDegree[i];
        }
        Arrays.sort(temp);
        for(int i=1;i<=N;i++){
            if (temp[i] != i-1)
                return false;
        }
        return true;
    }
}
