package d0226;

import java.io.*;
import java.util.*;

import javax.swing.CellEditor;
import javax.swing.plaf.ColorUIResource;


public class BJ_21276_계보복원가호석_최태선R {
    static int N,M;
    static List<String> roots;
    static Map<String,List<String>> answer;
    static Map<String,List<String>> graph; // 조상 -> 자식
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
            graph.put(s,new ArrayList<>());
            answer.put(s,new ArrayList<>());
            indegree.put(s,0);
        }
        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            String child = st.nextToken();
            String parent = st.nextToken();
            graph.get(parent).add(child);
            indegree.put(child,indegree.get(child)+1);
        }
        topologicalSort();
        System.out.println(count);
        Collections.sort(roots);
        for(String s : roots){
            System.out.print(s + " ");
        }
        System.out.println();
        Collections.sort(people);
        for(String s: people){
            int size = answer.get(s).size();
            System.out.print(s +" " + size +" ");
            List<String> list = answer.get(s);
            Collections.sort(list);
            for(String s1 : list){
                System.out.print(s1 + " ");
            }
            System.out.println();
        }
        
        
        

    }
    static void topologicalSort(){
        Deque<String> deque = new ArrayDeque<>();
        indegree.forEach((key,value)->{
            if(value==0){
                count++;
                roots.add(key);
                deque.add(key);
            }
        });
        while(!deque.isEmpty()){
            String s = deque.poll();
            List<String> list = graph.get(s);
            for(String next : list){
                int g = indegree.get(next);
                g--;
                indegree.put(next,g);
                if(g == 0){
                    deque.add(next);
                    answer.get(s).add(next);
                }
            }
        }
        
    }
}
