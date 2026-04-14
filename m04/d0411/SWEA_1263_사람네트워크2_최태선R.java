package m04.d0411;

import java.io.*;
import java.util.*;

public class SWEA_1263_사람네트워크2_최태선R {
    static int T,N;
    static int[][] arr;
    static List<Integer>[] graph;
    static Deque<Integer> deque;
    static boolean[] visited;
    static int INF = Integer.MAX_VALUE/2;
    static int minVal;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            graph = new List[N];
            for(int i=0;i<N;i++){
                graph[i]= new ArrayList<>();
            }
            deque = new ArrayDeque<>();
            visited = new boolean[N];
            minVal = Integer.MAX_VALUE;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr[i][j] == 1){
                        graph[i].add(j);
                    }
                }
            }

            for(int i=0;i<N;i++){
                minVal = Math.min(minVal, bfs(i));
            }
            
            
            System.out.println("#"+t+" " +minVal);
        }
    }
    static int bfs(int start){
        Arrays.fill(visited,false);
        deque.clear();
        visited[start] = true;
        deque.add(start);
        int result= 0;
        int count = 0;
        while(!deque.isEmpty()){
            int size = deque.size();
            while(size >0){
                int nowNum = deque.poll();
                result += count;
                size --;
                for(int nextNum : graph[nowNum]){
                    if(visited[nextNum] == false ){
                        visited[nextNum] = true;
                        deque.add(nextNum);
                    }
                }
            }
            count ++;
        }
        return result;
    }
}
