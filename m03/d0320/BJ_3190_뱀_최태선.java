package d0320;

import java.io.*;
import java.util.*;

public class BJ_3190_뱀_최태선 {
    static class Snake{
        int i;
        int j;
        Snake next;
        Snake(int i,int j ,Snake s){
            this.i = i;
            this.j = j;
            this.next = s;
        }
    }
    
    static int N,K,L;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static Snake tail;
    static Snake head;
    static int[][] graph;
    static int[][] order;
    static int dir;
    static int count;
    static int ni,nj;
    public static void main(String[] args) throws Exception{
        // 초기 dir = 1, 0,0 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        dir =1;
        graph = new int[N][N];
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int ai = Integer.parseInt(st.nextToken());
            int aj = Integer.parseInt(st.nextToken());
            graph[ai-1][aj-1] = 2;
        }
        
        L = Integer.parseInt(br.readLine());
        order = new int[L][2];
        for(int i=0;i<L;i++){
            StringTokenizer st =new StringTokenizer(br.readLine()," ");
            int sec = Integer.parseInt(st.nextToken());
            int dirChange;
            if(st.nextToken().equals("D"))
                dirChange = 1;
            else
                dirChange = -1;
            order[i][0] = sec;
            order[i][1] = dirChange;
        }
        tail = new Snake(0,0, null);
        head = tail;
        count = 0;
        ni=0;
        nj=0;
        graph[0][0] = 1;
        
        while(true){
            
            count ++;
            ni = ni + di[dir];
            nj = nj + dj[dir];
           
            if(ni<0 || ni>=N || nj<0 || nj>=N || graph[ni][nj] == 1)
                break;
            head.next = new Snake(ni, nj, null);
            head = head.next;
            boolean isUpgraded = false;
            if(graph[ni][nj] == 2){
                isUpgraded = true;
            } 
            if(isUpgraded == false){
                graph[tail.i][tail.j] = 0;
                tail = tail.next;
            }
            graph[ni][nj] = 1;
            for(int p=0;p<L;p++){
                if(order[p][0] == count){
                    setDir(order[p][1]);
                    break;
                }
            }
        }
        System.out.println(count);
    }
    static void setDir(int k){
        if (k == -1){
            if(dir == 0)
                dir = 3;
            else 
                dir --;
        }
        else{
            if(dir == 3)
                dir = 0;
            else
                dir ++;
        }
        return;
    }
}
