package d0311;

import java.io.*;
import java.util.*;

public class SWEA_1251_하나로Prim_최태선 {
    static class Node implements Comparable<Node>{
        int nowNum;
        long weight;
        Node(int nowNum,long weight){
            this.nowNum = nowNum;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){
            return Long.compare(this.weight, o.weight);
        }
    }
    static int T,N;
    static double E;
    static int[] posX,posY;
    static int count;
    static long tempResult;
    static double result;
    static boolean[] visited;
    static List<Node>[] nodeList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            nodeList = new ArrayList[N];
            for(int i=0;i<N;i++){
                nodeList[i] = new ArrayList<>();
            }
            // pos 0번이랑 1번은 도착과 끝지점
            posX = new int[N];
            posY = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                posX[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                posY[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<N;i++){
                for (int j=i+1;j<N;j++)
                {
                    long dx = Math.abs(posX[i]-posX[j]);
                    long dy = Math.abs(posY[i]-posY[j]);
                    // i=>j로 가는데 비용 = dx*dx + dy*dy, 양방향
                    nodeList[i].add(new Node(j,dx*dx+dy*dy));
                    nodeList[j].add(new Node(i,dx*dx+dy*dy));
                }
            }

            E = Double.parseDouble(br.readLine());
            visited = new boolean[N];
            tempResult = 0;
            prim();
            result = E*tempResult;
            System.out.println("#"+t+" "+Math.round(result));

        }
    }
    static void prim(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0));
        int tempC = 0;
        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            int num = nowNode.nowNum;
            long weight = nowNode.weight;
            if(visited[num] == true)
                continue;
            visited[num] = true;
            tempResult += weight;
            tempC ++;
            if(tempC == N)
                return;
            for(Node next : nodeList[num]){
                if (visited[next.nowNum] == false)
                {
                    pq.add(next);
                }
            }
        }
    }
}


