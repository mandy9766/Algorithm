package d0320;

import java.io.*;
import java.util.*;

public class BJ_14499_주사위굴리기_최태선 {
    static int [] dice;
    static int N,M,diceI,diceJ,K;
    static int[][] graph;
    static int[] order;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        diceI = Integer.parseInt(st.nextToken());
        diceJ = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        order = new int[K];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<K;i++){
            order[i] = Integer.parseInt(st.nextToken());
        }
        dice = new int[7];
        for(int i=0;i<K;i++){
            int nowOrder = order[i];
            if(nowOrder == 1){
                if(diceJ == M-1)
                    continue;
                rollDiceRight();
                diceJ ++;
            }
            else if(nowOrder == 2){
                if(diceJ == 0)
                    continue;
                rollDiceLeft();
                diceJ --;
            }
            else if(nowOrder == 3){
                if(diceI == 0)
                    continue;
                rollDiceUp();
                diceI --;
                
            }
            else if(nowOrder == 4){
                if(diceI == N-1)
                    continue;
                rollDiceDown();
                diceI ++;
            }
            //이동칸 수 0 => 주사위 바닥면 수 칸에 복사
            if(graph[diceI][diceJ] == 0){
                graph[diceI][diceJ] = dice[6];
            }
            //이동칸 수 0아님 => 그래프에 있는 수 주사위 바닥에 복사 , 그래프 0
            else{
                dice[6] = graph[diceI][diceJ];
                graph[diceI][diceJ] = 0;
            }   
            System.out.println(dice[1]);
        }
    }
    static void rollDiceRight(){
        int temp = dice[1];
        dice[1] = dice[4];
        dice[4] = dice[6];
        dice[6] = dice[3];
        dice[3] = temp;
    }
    static void rollDiceLeft(){
        int temp = dice[1];
        dice[1] = dice[3];
        dice[3] = dice[6];
        dice[6] = dice[4];
        dice[4] = temp;
    }
    static void rollDiceUp(){
        int temp = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[6];
        dice[6] = dice[2];
        dice[2] = temp;
    }
    static void rollDiceDown(){
        int temp = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[6];
        dice[6] = dice[5];
        dice[5] = temp;
    }
}
