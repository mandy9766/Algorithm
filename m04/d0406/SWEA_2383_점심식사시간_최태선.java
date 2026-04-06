package m04.d0406;

import java.io.*;
import java.util.*;

public class SWEA_2383_점심식사시간_최태선 {
    static int T , N;
    static int[][] graph;
    static int[][] peoplePos;
    static int[][] stairPos;
    static int peopleCount;
    static int minVal;
    static int[] selectStair;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            peoplePos = new int[10][2];
            stairPos = new int[2][2];
            int stairNum = 0;
            peopleCount = 0;
            minVal = Integer.MAX_VALUE;
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    if(graph[i][j] == 1){
                        peoplePos[peopleCount][0] = i;
                        peoplePos[peopleCount][1] = j;
                        peopleCount++;
                    }else if(graph[i][j] >= 2){
                        stairPos[stairNum][0] = i;
                        stairPos[stairNum][1] = j;
                        stairNum++;
                    }
                }
            }
            selectStair = new int[peopleCount];
            dfs(0,0,0);
            System.out.println("#"+t+" "+ minVal);
        }
    }
    static void dfs(int people,int zeroCount,int oneCount){
        if(people == peopleCount){
            // 현재값으로 처리
            int[] zeroList = new int[zeroCount];
            int nowZeroIdx = 0;
            int[] oneList = new int[oneCount];
            int nowOneIdx = 0;
            int s0I = stairPos[0][0];
            int s0J = stairPos[0][1];
            int s1I = stairPos[1][0];
            int s1J = stairPos[1][1];
            // 거리로 일단 전처리
            for(int i=0;i<peopleCount;i++){
                if(selectStair[i] == 0){
                    zeroList[nowZeroIdx] = Math.abs(stairPos[0][0] - peoplePos[i][0]) + Math.abs(stairPos[0][1] - peoplePos[i][1]);
                    nowZeroIdx ++;
                }else{
                    oneList[nowOneIdx] = Math.abs(stairPos[1][0] - peoplePos[i][0]) + Math.abs(stairPos[1][1] - peoplePos[i][1]);
                    nowOneIdx++;
                }
            }
            Arrays.sort(zeroList);
            Arrays.sort(oneList);
            int maxVal0=0;
            int maxVal1=0;
            int maxResult=0;
            if(zeroCount>0){
                if(zeroCount <4){
                    maxVal0 = zeroList[zeroCount-1]+1+graph[s0I][s0J];
                }else{
                    // dp처리
                    int[] dp0 = new int[zeroCount];
                    dp0[0] = zeroList[0] +1+graph[s0I][s0J];
                    dp0[1] = zeroList[1] +1+graph[s0I][s0J];
                    dp0[2] = zeroList[2] +1+graph[s0I][s0J];
                    for(int i=3;i<zeroCount;i++){
                        dp0[i] = Math.max(dp0[i-3] ,zeroList[i]+1) +graph[s0I][s0J];
                    }
                    maxVal0 = dp0[zeroCount-1];
                }
            }
            if(oneCount >0)
            {
                if(oneCount<4){
                    maxVal1 = oneList[oneCount-1]+1+graph[s1I][s1J];
                }else{
                    int[] dp1 = new int[oneCount];
                    dp1[0] = oneList[0] +1+graph[s1I][s1J];
                    dp1[1] = oneList[1] +1+graph[s1I][s1J];
                    dp1[2] = oneList[2] +1+graph[s1I][s1J];
                    for(int i=3;i<oneCount;i++){
                        dp1[i] = Math.max(dp1[i-3] ,oneList[i]+1)+graph[s1I][s1J];
                    }
                    maxVal1 = dp1[oneCount-1];
                }
            }
            
            maxResult = Math.max(maxVal0,maxVal1);
            minVal = Math.min(minVal,maxResult);
            return;
        }
        // 지금 people이 0번 계단 선택
        selectStair[people] = 0;
        dfs(people+1,zeroCount+1,oneCount);
        // 지금 people이 1번 계단 선택
        selectStair[people] = 1;
        dfs(people+1,zeroCount,oneCount+1);

    }
}
