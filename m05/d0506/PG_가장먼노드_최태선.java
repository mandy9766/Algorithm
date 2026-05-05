package m05.d0506;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class PG_가장먼노드_최태선 {
     int N;
    List<Integer>[] graph;
    int[] count;
    int maxVal;
    int answer;
    public int solution(int n, int[][] edge) {
        N = n;
        graph = new List[N+1];
        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<>();
        }
        int size = edge.length;
        for(int i=0;i<size;i++){
            int a = edge[i][0];
            int b = edge[i][1];
            // a b가 연결되어있다.
            graph[a].add(b);
            graph[b].add(a);
        }
        count = new int[N+1];
        Arrays.fill(count,-1);
        maxVal = 0;
        answer = 0;
        bfs();
        for(int i=1;i<N+1;i++){
            if(maxVal == count[i]){
                answer++;
            }
        }
        return answer;
    }
    void bfs(){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        count[1] = 0;
        while(!deque.isEmpty()){
            int nowNum = deque.poll();
            for(int nextNum : graph[nowNum]){
                if(count[nextNum] == -1){
                    count[nextNum] = count[nowNum]+1;
                    deque.add(nextNum);
                    
                    maxVal = Math.max(maxVal,count[nextNum]);
                }
            }
        }
    }
}
