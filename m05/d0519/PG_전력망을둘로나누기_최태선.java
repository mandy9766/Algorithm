package m05.d0519;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class PG_전력망을둘로나누기_최태선 {
    int minVal;
    int size;
    int N;
    Deque<Integer> deque;
    List<Integer>[] edges;
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        N=n;
        size = wires.length;
        edges= new ArrayList[N+1];
        visited = new boolean[N+1];
        minVal = Integer.MAX_VALUE;
        for(int i=1;i<n+1;i++){
            edges[i] = new ArrayList<>();
        }
        for(int i=0;i<size;i++){
            int start = wires[i][0];
            int end = wires[i][1];
            edges[start].add(end);
            edges[end].add(start);
        }
        deque = new ArrayDeque<>();
        for(int i=0;i<size;i++){
            int start = wires[i][0];
            int end = wires[i][1];
            bfs(start,end);
        }
        return minVal;
    }
    void bfs(int start, int end){
        int count = 0;
        deque.clear();
        deque.add(1);
        Arrays.fill(visited,false);
        visited[1] = true;
        while(!deque.isEmpty()){
            int nowNum = deque.poll();
            count++;
            for(int nextNum : edges[nowNum]){
                if((nowNum == start && nextNum == end) || (nowNum == end && nextNum == start) || visited[nextNum])
                    continue;
                visited[nextNum] = true;
                deque.add(nextNum);
            }
        }
        minVal = Math.min(minVal,Math.abs(N-count*2));
    }
}
