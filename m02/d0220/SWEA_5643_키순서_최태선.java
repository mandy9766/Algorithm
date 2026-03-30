package d0220;

import java.io.*;
import java.util.*;

public class SWEA_5643_키순서_최태선 {
    static int N,M;
    static List<Integer>[] list;
    static List<Integer>[] revList;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            list = new ArrayList[N+1];
            revList = new ArrayList[N+1];
            for(int i=1;i<N+1;i++){
                list[i] = new ArrayList<>();
                revList[i] = new ArrayList<>();
            }
            M = Integer.parseInt(br.readLine());
            for(int i=0;i<M;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
                revList[to].add(from);
            }
            int count = 0;
            for(int i=1;i<=N;i++){
                if(dfs(i)+revDfs(i)+1 == N)// 리스트 dfs로 체크한후 개수, revList dfs로 체크한후 개수 + 1 == N -> count ++;
                    count++;
            }
            System.out.println("#"+t+" "+count);
        }

    }
    static int dfs(int i){
        Set<Integer> set = new HashSet<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int next : list[i]){
            deque.add(next);
            set.add(next);
        }
        int count = 0;
        while(!deque.isEmpty()){
            int num = deque.poll();
            count ++;
            for(int next : list[num]){
                if(!set.contains(next)){
                    deque.add(next);
                    set.add(next);
                }
            }
        }
        return count;
    }
    static int revDfs(int i){
        Set<Integer> set = new HashSet<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int next : revList[i]){
            deque.add(next);
            set.add(next);
        }
        int count = 0;
        while(!deque.isEmpty()){
            int num = deque.poll();
            count ++;
            for(int next : revList[num]){
                if(!set.contains(next)){
                    deque.add(next);
                    set.add(next);
                }
            }
        }
        return count;
    }
}
