package m05.d0518;

import java.util.*;

class PG_피로도_최태선 {
    int[][] dArr;
    int K;
    int size;
    boolean [] selected;
    int maxVal;
    public int solution(int k, int[][] dungeons) {
        K = k;
        dArr = dungeons;
        size = dArr.length;
        selected = new boolean[size];
        maxVal = 0;
        dfs(0,K,0);
        return maxVal;   
    }
    void dfs(int depth, int nowK,int nowCount){
        // 일단 만족했으면 계속 max값 업데이트
        maxVal = Math.max(nowCount,maxVal);
        if(depth == size)
            return;
        for(int i=0;i<size;i++){
            if(selected[i] == false && nowK>=dArr[i][0]){
                selected[i] = true;
                dfs(depth+1,nowK-dArr[i][1],nowCount+1);
                selected[i] = false;
            }
        }
        
    }
}