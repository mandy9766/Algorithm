package d0318;

import java.io.*;
import java.util.*;

public class BJ_17281_야구공_최태선 {
    static int N;
    static int[] nowOrder = new int[10];
    static int[] val = new int[10];
    static int[][] graph;
    static boolean[] isSelected;
    static boolean[] nowGround = new boolean[4];
    static int maxVal;
    
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maxVal = 0;
        graph = new int[N][10];
        isSelected = new boolean[10];
        // 1번은 이미 처리된걸로치기
        isSelected[1] = true;
        nowOrder[4] = 1;
        // 1번타자는 인덱스 4번에 고정
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<10;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1);
        System.out.println(maxVal);
    }
    static void dfs(int depth){
        if(depth == 10){
            // nowOrder 값으로 graph 기반해서 게임 처리
            playGame();
            return;
        }if(depth == 4){
            dfs(depth+1);
        }
        else{
            for(int i=1;i<10;i++){
                if(isSelected[i] == false){
                    nowOrder[depth] = i;
                    isSelected[i] = true;
                    dfs(depth+1); 
                    isSelected[i] = false;
                }
            }
        }
    }
    static void playGame(){
        int count=0;
        int playerNum = 1;
        for(int n=0;n<N;n++){
            Arrays.fill(nowGround, false);
            int outCount = 0;
            for(int j=1;j<10;j++){
                val[j] = graph[n][j]; 
            }
            while(outCount<3){
                if(playerNum == 10)
                    playerNum = 1;
                int nowPlayer = nowOrder[playerNum];
                int nowVal = val[nowPlayer];
                if(nowVal ==  0){
                    outCount ++;
                }else{
                    for(int i=3;i>0;i--){
                        if(nowGround[i])
                        {
                            int temp = i+nowVal;
                            if(temp >= 4){
                                count++;
                                nowGround[i] = false;
                            }else{
                                nowGround[i] = false;
                                nowGround[temp] = true;
                            }
                        }
                    }
                    if(nowVal == 4)
                        count ++;
                    else{
                        nowGround[nowVal] = true;
                    }
                }
                // 플레이어 넘버 올리기
                playerNum++;
            }
        }
        maxVal = Math.max(maxVal, count);
    }
}
