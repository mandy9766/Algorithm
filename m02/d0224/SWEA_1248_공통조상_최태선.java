package d0224;
import java.io.*;
import java.util.*;

public class SWEA_1248_공통조상_최태선 {
    static int T,V,E,num1,num2;
    static Deque<Integer> deque1, deque2;
    static int [] rev_graph;
    static List<Integer>[] graph;
    static int twiceMom;
    static int maxCount;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
            deque1 = new ArrayDeque<>();
            deque2 = new ArrayDeque<>();
            rev_graph = new int[V+1];
            graph = new ArrayList[V+1];
            for(int i=1;i<=V;i++){
                graph[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<E;i++){
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                rev_graph[child] = parent;
                graph[parent].add(child);
            }
            deque1 = getDeque(num1);
            deque2 = getDeque(num2);


            while(!(deque1.isEmpty()||deque2.isEmpty())){
                int temp1 = deque1.pollLast();
                int temp2 = deque2.pollLast();
                if(temp1 == temp2)
                    twiceMom = temp1;
                else{
                    break;
                }
            }
            
            count(twiceMom);
            System.out.println("#"+t+" "+twiceMom+" "+maxCount);
        }
    }
    static void count(int root){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(root);
        int count =0;
        while(!deque.isEmpty()){
            int nowNode = deque.poll();
            count ++;
            if(!graph[nowNode].isEmpty()){
                for(int next : graph[nowNode]){
                    deque.add(next);
                }
            }
        }
        maxCount= count;
    }
    static Deque<Integer> getDeque(int num){
        Deque<Integer> tempDeque = new ArrayDeque<>();
        int nowNum = rev_graph[num];
        while (true){
            tempDeque.add(nowNum);
            if(nowNum == 1)
                break;
            nowNum = rev_graph[nowNum];
        }
        return tempDeque;
    }
}
