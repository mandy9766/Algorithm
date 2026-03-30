package d0320;
import java.io.*;
import java.util.*;

public class BJ_12100_2048_최태선 {
    static int N;
    static int[][] graph;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static int resultVal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        resultVal = 0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1);
        System.out.println(resultVal);
    }
    static void dfs(int depth){
        if(depth == 6){
           // 그래프에서 가장 큰값 처리
            getMaxVal();
            return;
        }
        int[][] tempGraph = new int[N][N];
        for(int i=0;i<N;i++){
            tempGraph[i] = graph[i].clone();
        }
        for(int k=0;k<4;k++){
            // 방향에 따른 로직
            playGame(k); // 여기서 그래프 옮김
            dfs(depth+1);
            for(int i=0;i<N;i++){
                graph[i] = tempGraph[i].clone();
            }
        }
    }
    static void  getMaxVal(){
        int maxVal = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                maxVal = Math.max(maxVal, graph[i][j]);
            }
        }
        resultVal = Math.max(maxVal,resultVal);
        return;
    }
    static void playGame(int k){
        // up 인 경우
        if(k == 0){
            for(int j=0;j<N;j++){
                int idx = 0;
                int temp = -1;
                for(int i=0;i<N;i++){
                    if(graph[i][j] != 0){    
                        int nowVal = graph[i][j];
                        graph[i][j] = 0;
                        //만약 더해볼 값이 존재하지않으면
                        if(temp == -1){
                            temp = nowVal;
                            graph[idx][j] = nowVal;
                        //더해볼 값이 존재하면
                        }else{ 
                            // 그값이 이전값이랑 같으면
                            if(nowVal == temp){
                                graph[idx][j] = 2* graph[idx][j]; 
                                idx ++;
                                temp = -1;
                            // 그 값이 이전값이랑 다르면
                            }else{
                                idx ++;
                                graph[idx][j] = nowVal;
                                temp = nowVal;
                            }
                        }
                    }
                }
            }
        }
        // down인경우 
        else if(k == 2){
            for(int j=0;j<N;j++){
                int idx = N-1;
                int temp = -1;
                for(int i=N-1;i>=0;i--){
                    if(graph[i][j] != 0){    
                        int nowVal = graph[i][j];
                        graph[i][j] = 0;
                        //만약 더해볼 값이 존재하지않으면
                        if(temp == -1){
                            temp = nowVal;
                            graph[idx][j] = nowVal;
                        //더해볼 값이 존재하면
                        }else{ 
                            // 그값이 이전값이랑 같으면
                            if(nowVal == temp){
                                graph[idx][j] = 2* graph[idx][j]; 
                                idx --;
                                temp = -1;
                            // 그 값이 이전값이랑 다르면
                            }else{
                                idx --;
                                graph[idx][j] = nowVal;
                                temp = nowVal;
                            }
                        }
                    }
                }
            }
        }
        // right인경우
        else if(k == 1){
            for(int i=0;i<N;i++){
                int idx = N-1;
                int temp = -1;
                for(int j=N-1;j>=0;j--){
                    if(graph[i][j] != 0){    
                        int nowVal = graph[i][j];
                        graph[i][j] = 0;
                        //만약 더해볼 값이 존재하지않으면
                        if(temp == -1){
                            temp = nowVal;
                            graph[i][idx] = nowVal;
                        //더해볼 값이 존재하면
                        }else{ 
                            // 그값이 이전값이랑 같으면
                            if(nowVal == temp){
                                graph[i][idx] = 2* graph[i][idx]; 
                                idx --;
                                temp = -1;
                            // 그 값이 이전값이랑 다르면
                            }else{
                                idx --;
                                graph[i][idx] = nowVal;
                                temp = nowVal;
                            }
                        }
                    }
                }
            }
        }
        // left인경우
        else if(k == 3){
            for(int i=0;i<N;i++){
                int idx = 0;
                int temp = -1;
                for(int j=0;j<N;j++){
                    if(graph[i][j] != 0){  
                        int nowVal = graph[i][j];
                        graph[i][j] = 0;  
                        //만약 더해볼 값이 존재하지않으면
                        if(temp == -1){
                            temp = nowVal;
                            graph[i][idx] = nowVal;
                        //더해볼 값이 존재하면
                        }else{ 
                            // 그값이 이전값이랑 같으면
                            if(nowVal == temp){
                                graph[i][idx] = 2* graph[i][idx]; 
                                idx ++;
                                temp = -1;
                            // 그 값이 이전값이랑 다르면
                            }else{
                                idx ++;
                                graph[i][idx] = nowVal;
                                temp = nowVal;
                            }
                        }
                    }
                }
            }
        }
        return;
    }
}
