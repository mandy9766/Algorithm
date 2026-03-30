package d0226;

import java.io.*;
import java.util.*;

import javax.swing.CellEditor;


public class BJ_21276_계보복원가호석_최태선 {
    static int N,M;
    static List<String> roots;
    static Map<String,List<String>> answer;
    static Map<String,List<String>> graph;
    static Map<String,Integer> indegree;
    static List<String> people;
    static int count;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new ArrayList<>();
        graph = new HashMap<>();
        answer = new HashMap<>();
        roots = new ArrayList<>();
        indegree = new HashMap<>();
        count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            String s = st.nextToken();
            people.add(s);
            answer.put(s,new ArrayList<>());
            graph.put(s,new ArrayList<>());
            indegree.put(s,0);
        }
        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            String child = st.nextToken();
            String parent = st.nextToken();
            graph.get(child).add(parent);
            indegree.put(parent,indegree.get(parent)+1);
        }
        Collections.sort(people);
        topologicalSort();
        Collections.sort(roots);
        System.out.println(count);
        for(int i=0;i<roots.size();i++){
            System.out.print(roots.get(i)+" ");
        }
        System.out.println();
        for(int i=0;i<N;i++){
            String name = people.get(i);
            System.out.print(name+" ");
            System.out.print(answer.get(name).size()+" ");
            Collections.sort(answer.get(name));
            for(String next : answer.get(name)){
                System.out.print(next+" ");
            }
            System.out.println();
        }

    }
    static void topologicalSort(){
        Deque<String> deque = new ArrayDeque<>();
        indegree.forEach((key,value)-> {
                if(value == 0){
                    deque.add(key);
                }   
            }
        );
        while(!deque.isEmpty()){
            String name = deque.poll();
            if(graph.get(name).size() == 0){ //루트이면
                count ++;
                roots.add(name);
            }else{
                int minVal = 1001; 
                String nowParent="";
                for(String next : graph.get(name)){
                    int nowIndegree = indegree.get(next);
                    nowIndegree--;
                    if(nowIndegree ==0){
                        deque.add(next);
                    }
                    if(nowIndegree<minVal){
                        minVal = nowIndegree;
                        nowParent = next;
                    }
                    indegree.put(next,nowIndegree);
                }
                answer.get(nowParent).add(name);  
            }

        }
    }
}
