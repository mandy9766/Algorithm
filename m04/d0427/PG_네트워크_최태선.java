package m04.d0427;
import java.io.*;
import java.util.*;

public class PG_네트워크_최태선 {

class Solution {
    int count;
    int[][] graph;
    boolean[] visited;
    Deque<Integer> deque;
    int N;
    
    public int solution(int n, int[][] computers) {
        count = 0;
        N = n;
        graph = computers;
        visited = new boolean[N];
        deque = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            if(visited[i] == false){
                visited[i] = true;
                bfs(i);
                count ++;
            }
        }
        return count;
    }
    public void bfs(int i){
        deque.clear();
        deque.add(i);
        while(!deque.isEmpty()){
            int nowCom = deque.poll();
            for(int j=0;j<N;j++){
                if(visited[j] == false && graph[nowCom][j] == 1){
                    visited[j] = true;
                    deque.add(j);
                }
            }
        }
    }
}
}
