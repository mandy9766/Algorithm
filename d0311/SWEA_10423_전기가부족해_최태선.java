package d0311;

import java.io.*;
import java.util.*;

public class SWEA_10423_전기가부족해_최태선 {
    static class Edge implements Comparable<Edge>{
        int e;
        int w;
        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.w, o.w);
        }
    }
    
    static int N,M,K;
    static int[] energy;
    static List<Edge>[] edgeList;
    static boolean[] visited;
    static int count;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 케이블의 수
        K = Integer.parseInt(st.nextToken()); // 발전기의 수
        edgeList = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<N+1;i++){
            edgeList[i] = new ArrayList<>();
        }
        energy = new int[K];
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<K;i++){
            energy[i] = Integer.parseInt(st.nextToken()); // 발전기 번호 배열
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edgeList[u].add(new Edge(v,w));
            edgeList[v].add(new Edge(u,w));
        }
        prim();
        System.out.println(result);
    }
    static void prim(){
        count = 0;
        result = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0;i<K;i++){
            int num = energy[i];
            pq.add(new Edge(num,0));
        }
        while(!pq.isEmpty()){
            Edge nowEdge = pq.poll();
            int e = nowEdge.e;
            int w = nowEdge.w;
            // 이미 최소값으로 처리된 정점은 건너뛴다
            if(visited[e] == true)
                continue;
            visited[e] = true;
            result += w;
            count ++;
            if(count == N)
                return;
            // 방금 연결된 노드에서 갈수있는 곳들을 전부 pq에 넣는다. (최소순으로 자동정렬)
            for(Edge nextEdge : edgeList[e]){
                int ne = nextEdge.e;
                int nw = nextEdge.w;
                if(visited[ne] == false)
                    pq.add(new Edge(ne, nw));
            }
        }

    }
}
