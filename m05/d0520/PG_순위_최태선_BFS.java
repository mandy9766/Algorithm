package m05.d0520;

import java.util.*;

class PG_순위_최태선_BFS {
    int N;
    int Results[][];
    List<Integer>[] winList; // winList[a].get(i) = b -> a는 b를 이김
    List<Integer>[] loseList; // loseList[a].get(i) = b -> a는 b한테 짐
    Deque<Integer> deque;
    boolean[] visited;
    int resultCount;
    public int solution(int n, int[][] results) {
        N = n;
        Results = results;
        deque = new ArrayDeque<>();
        resultCount = 0;
        winList = new ArrayList[N+1];
        loseList = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<N+1;i++){
            winList[i] = new ArrayList<>();
            loseList[i] = new ArrayList<>();
        }
        for(int i=0;i<Results.length;i++){
            int nowWinner = Results[i][0];
            int nowLoser = Results[i][1];
            winList[nowWinner].add(nowLoser);
            loseList[nowLoser].add(nowWinner);
        }
        for(int i=1;i<N+1;i++){
            int winCount = winBfs(i);
            int loseCount = loseBfs(i);
            if(winCount + loseCount == N-1)
                resultCount++;
        }
        return resultCount;
    }
    int winBfs(int i){
        Arrays.fill(visited,false);
        deque.clear();
        int count = 0;
        deque.add(i);
        visited[i] = true;
        while(!deque.isEmpty()){
            int nowNum = deque.poll();
            count++;
            for(int nextNum : winList[nowNum]){
                if(!visited[nextNum]){
                    visited[nextNum] = true;
                    deque.add(nextNum);
                }
            }
        }
        
        return count-1; // 본인빼기
    }
    int loseBfs(int i){
        Arrays.fill(visited,false);
        deque.clear();
        int count = 0;
        deque.add(i);
        visited[i] = true;
        while(!deque.isEmpty()){
            int nowNum = deque.poll();
            count++;
            for(int nextNum : loseList[nowNum]){
                if(!visited[nextNum]){
                    visited[nextNum] = true;
                    deque.add(nextNum);
                }
            }
        }
        
        return count-1; // 본인빼기
    }
}