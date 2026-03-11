package d0311;

import java.io.*;
import java.util.*;

public class BJ_17471_게리맨더링_최태선 {
    static int N;
    static Deque<Integer> left,right;
    static boolean[][] graph;
    static int[] peopleCount;
    static int minVal;
    static int INF = Integer.MAX_VALUE/2;
    static int[] parents;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new boolean[N+1][N+1];
        
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
        peopleCount = new int[N+1];
        minVal = INF;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++){
            peopleCount[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int count = Integer.parseInt(st.nextToken());
            for(int j=0;j<count;j++){
                int v = Integer.parseInt(st.nextToken());
                graph[i][v] = true;
            }
        }
        dfs(1);
        if(minVal == INF)
            System.out.println(-1);
        else
            System.out.println(minVal);

    }
    static void dfs(int depth){ // 1부터
        if(depth == N+1){
            if (left.size()<1 || right.size()<1 || check() == false) // 하나도 포함안하거나 graph 연결 불가하면
                return;
            // 가능한경우
            int tempL =0;
            int tempR =0;
            for(int p : left){
                tempL += peopleCount[p];
            }
            for(int p : right){
                tempR += peopleCount[p];
            }
            minVal = Math.min(minVal,Math.abs(tempL-tempR));
            return;
        }
        left.addFirst(depth);
        dfs(depth+1);
        left.pollFirst();
        right.addFirst(depth);
        dfs(depth+1);
        right.pollFirst();
    }
    static boolean check(){ // left, right
        // left , right 각각 union 해서 각 사이드에서 대표가 한명이면 ok
        int leftSize = left.size();
        int[] leftArr = new int[leftSize];
        int i=0;
        for(int nowI : left){
            leftArr[i] = nowI;
            i++;
        }
        int rightSize = right.size();

        int[] rightArr = new int[rightSize];
        i =0;
        for (int nowI : right){
            rightArr[i] = nowI;
            i++;
        }
        makeSet();
        // 2중for문을 위한 배열로각각 전처리
        for(int q=0;q<leftSize;q++){
            for (int w=q+1;w<leftSize;w++){
                int a = leftArr[q];
                int b = leftArr[w];
                if(graph[a][b] == true)
                    union(a, b);
            }
        }
        int tempCount = 0;
        for(int q=0;q<leftSize;q++){
            int x = leftArr[q];
            if(parents[x]<0)
                tempCount ++;
        }
        if(tempCount > 1)
            return false;

        makeSet();
        for(int q=0;q<rightSize;q++){
            for (int w=q+1;w<rightSize;w++){
                int a = rightArr[q];
                int b = rightArr[w];
                if(graph[a][b] == true)
                    union(a, b);
            }
        }
        tempCount = 0;
        for(int q=0;q<rightSize;q++){
            int x = rightArr[q];
            if(parents[x]<0)
                tempCount ++;
        }
        if(tempCount > 1)
            return false;
        
        return true;
    }
    static void makeSet(){
        parents = new int[N+1];
        for(int i=1;i<N+1;i++){
            parents[i] = -1;
        }
    }
    static int findSet(int x){
        if(parents[x] <0)
            return x;
        else
            return parents[x] = findSet(parents[x]);
    }
    static boolean union(int x,int y){
        int rootX = findSet(x);
        int rootY = findSet(y);
        if(rootX == rootY){
            return false;
        }
        else{
            if(rootX < rootY){
                parents[rootX] += parents[rootY];
                parents[rootY] = rootX;
            }else{
                parents[rootY] += parents[rootX];
                parents[rootX] = rootY;
            }
            return true;
        }
    }
}
