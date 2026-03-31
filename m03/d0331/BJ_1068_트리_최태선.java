package d0331;

import java.io.*;
import java.util.*;

public class BJ_1068_트리_최태선 {
    static int N;
    static int[] arr;
    static List<Integer>[] graph;
    static int deletedIdx,rootIdx;
    static int leafCount;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        graph = new List[N];
        for(int i=0;i<N;i++){
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == -1)
                rootIdx = i;
        }
        deletedIdx = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            if(i == deletedIdx || arr[i] == -1)
                continue;
            graph[arr[i]].add(i);
        }
        leafCount = 0;
        if(rootIdx == deletedIdx)
            System.out.println(0);
        else{
            dfs(rootIdx);
            System.out.println(leafCount);
        }
       
    }
    static void dfs(int nowNode){
        if(graph[nowNode].size() == 0){
            leafCount ++;
            return;
        }
        for(int nextNode : graph[nowNode]){
            dfs(nextNode);
        }
    }
}
