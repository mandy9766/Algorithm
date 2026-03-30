package d0312;

import java.io.*;
import java.util.*;

public class SWEA_5656_벽돌깨기_최태선 {
    static int T,N,W,H;
    static int[][] graph;
    static boolean[][] visited;
    static int minVal;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken()); // j
            H = Integer.parseInt(st.nextToken()); // i
            graph = new int[H][W];
            visited = new boolean[H][W];
            for(int i=0;i<H;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<W;j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            minVal = Integer.MAX_VALUE/2;
            dfs(0);
            // 4번까지 하기전에 전부 블록없어져서 dfs가 끝까지 도달하지못한경우
            if(minVal == Integer.MAX_VALUE/2)
                System.out.println("#"+t+" "+0);
            else
                System.out.println("#"+t+" "+ minVal);
        }
    }
    static void dfs(int depth){
        if (depth == N){
            // graph에 0아닌값 세서 블록개수 minVal이랑 처리
            int count = 0;
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(graph[i][j] != 0)
                        count ++;
                }
            }
            minVal = Math.min(minVal,count);
            return;
        }
        Deque<int[]> upperDeque = new ArrayDeque<>(); //현재 그래프에서 맨위에있는 블록 리스트 가져오기
        for(int j=0;j<W;j++){
            for(int i=0;i<H;i++){
                if(graph[i][j] != 0){
                    upperDeque.add(new int[]{i,j}); // i,j가 현재 맨 위에있는 블록
                    break; // 찾았으면 다음행으로
                }
            }
        }
        // 원복용 그래프 업데이트
        int[][] pastGraph = new int[H][W];
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                pastGraph[i][j] = graph[i][j];
            }
        }

        while(!upperDeque.isEmpty()){ // 각 맨위블록의 케이스마다 dfs()
            int[] nowBlock = upperDeque.poll();
            // 이 블록에대한 연쇄처리 (graph 업데이트)
            //현재 boomBlock 범위에 들어오는값들 eraseList에 전부 넣기
            Deque<int[]> boomBlock = new ArrayDeque<>();
            boomBlock.add(nowBlock);
            ArrayList<int[]> eraseList = new ArrayList<>();
            for(int i=0;i<H;i++){
                Arrays.fill(visited[i],false);
            }
            visited[nowBlock[0]][nowBlock[1]] = true;
            while(!boomBlock.isEmpty()){
                int[] nowBoomBlock = boomBlock.poll();
                int nowI = nowBoomBlock[0];
                int nowJ = nowBoomBlock[1];
                eraseList.add(new int[]{nowI,nowJ});
                for(int p=1;p<graph[nowI][nowJ];p++){
                    for(int k=0;k<4;k++){
                        int ni = nowI + p*di[k];
                        int nj = nowJ + p*dj[k];
                        if(ni>=0 && ni<H && nj>=0 && nj<W && graph[ni][nj] != 0 && visited[ni][nj] == false)
                        {  
                            visited[ni][nj] = true;
                            boomBlock.add(new int[]{ni,nj}); 
                        }
                    }
                }
            }
            // 지울 리스트 전부 0으로 만들기
            int size = eraseList.size();
            for(int i=0;i<size;i++){
                int[] temp = eraseList.get(i);
                int nowI = temp[0];
                int nowJ = temp[1];
                graph[nowI][nowJ] = 0;
            }
            Deque<Integer> dq = new ArrayDeque<>();
            // 떠있는 블록 전부 내리기
            for(int j=0;j<W;j++){
                for(int i=0;i<H;i++){
                    if(graph[i][j] != 0){
                        dq.addLast(graph[i][j]);
                    }
                }
                for(int i=H-1;i>=0;i--){
                    if(!dq.isEmpty()){
                        graph[i][j] = dq.pollLast();
                    }
                    else{
                        graph[i][j] = 0;
                    }
                }

                /** 
                for(int k=H;k>=0;k--){ // 그냥 H번 반복
                    for(int i=H-1;i>=1;i--){
                        if(graph[i-1][j] != 0 && graph[i][j] == 0)
                        {
                            int temp = graph[i-1][j];
                            graph[i-1][j] = graph[i][j];
                            graph[i][j] = temp;
                        }
                    }
                }
                    **/
            }
            dfs(depth+1);
            // 그래프 원복
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    graph[i][j] = pastGraph[i][j];
                }
            }

            
        }
    }
}
