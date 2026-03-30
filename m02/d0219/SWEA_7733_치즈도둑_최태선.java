package d0219;

import java.io.*;
import java.util.*;

public class SWEA_7733_치즈도둑_최태선 {
    static int[][] graph;
    static int N;
    static int day;
    static int maxVal;
    static boolean[][] visited;
    static Deque<int[]> deque;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            visited = new boolean[N][N];
            deque = new ArrayDeque<>();
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            maxVal = 1;
            for(int i=1;i<=100;i++){
                day = i;
                int dayVal = check();
                maxVal = Math.max(maxVal,dayVal);
            }
            System.out.println("#"+(t+1) + " " + maxVal);
        }
    }
    static int check(){ // day보다 큰방이 몇개인지 체크하는 BFS
        for(int i=0;i<N;i++){
            Arrays.fill(visited[i], false);
        }
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j] > day && visited[i][j] == false){
                    count ++;
                    Bfs(i,j);
                }
            }
        }

        return count;
    }
    static void Bfs(int i,int j){
        deque.clear();
        deque.add(new int[]{i,j});
        visited[i][j] = true;
        while (!deque.isEmpty()){
            int[] temp = deque.poll();
            int nowI = temp[0];
            int nowJ = temp[1];
            for(int k=0;k<4;k++){
                int ni = nowI+di[k];
                int nj = nowJ+dj[k];
                if(ni>=0 && ni<N && nj>=0 && nj<N && graph[ni][nj] >day && visited[ni][nj] == false){
                    deque.add(new int[]{ni,nj});
                    visited[ni][nj] = true;
                }
            }
        }
    }
    

}
