package d0330;

import java.io.*;
import java.util.*;

public class BJ_15681_트리와쿼리_최태선 {
    static int N,R,Q;
    static List<Integer>[] candiate;
    static boolean[] visited;
    static int[] treeCount;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        candiate = new List[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<N+1;i++){
            candiate[i] = new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st=  new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            candiate[a].add(b);
            candiate[b].add(a);
        }
        treeCount = new int[N+1];
        visited[R] = true;
        dfs(R);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++){
            int q = Integer.parseInt(br.readLine());
            sb.append(treeCount[q]).append("\n");
        }
        System.out.println(sb);
    }
    static int dfs(int nowNode){
        int temp = 0;
        for(int nextNode : candiate[nowNode]){
            if(visited[nextNode] == false){
                visited[nextNode] = true;
                temp += dfs(nextNode);
            }
        }
        treeCount[nowNode] = temp+1;
        return treeCount[nowNode];
    }
    
    
}
