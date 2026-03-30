package d0220;

import java.io.*;

public class SWEA_1227_미로2_최태선 {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static boolean isPossible;
    static int[][] graph;
    static boolean[][] visited;
    static int[] start,goal;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int t=0;t<10;t++){
            int tNum = Integer.parseInt(br.readLine());
            graph= new int[100][100];
            visited = new boolean[100][100];
            for(int i=0;i<100;i++){
                char[] temp = br.readLine().toCharArray();
                for(int j=0;j<100;j++){
                    graph[i][j] = temp[j]-'0';
                    if(graph[i][j] == 2){
                        start = new int[]{i,j};
                    }else if(graph[i][j] == 3){
                        goal = new int[]{i,j};
                    }
                }
            }
            isPossible = false;
            visited[start[0]][start[1]] =true;
            Dfs(start[0],start[1]);
            if(isPossible == true){
                System.out.println("#"+tNum+" 1");
            }else{
                System.out.println("#"+tNum+" 0");
            }
        }
        
    }
    static void Dfs(int i,int j){
        if(isPossible == true){
            return;
        }
        if(i == goal[0] && j == goal[1]){
            isPossible = true;
            return;
        }
        for(int k=0;k<4;k++){
            int ni = i+di[k];
            int nj = j+dj[k];

            if(ni>=0 && ni<100 && nj>=0 && nj<100 && graph[ni][nj] != 1 && visited[ni][nj] == false){
                visited[ni][nj] = true;
                Dfs(ni,nj);
            }
        }

    }    
}
