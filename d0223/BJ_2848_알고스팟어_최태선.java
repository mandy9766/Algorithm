package d0223;

import java.io.*;
import java.util.*;

public class BJ_2848_알고스팟어_최태선 {
    static int N;
    static String[] sArr;
    static Map<Character,List<Character>> graph;
    static Map<Character,Integer> indegree;
    static Set<String> cSet;
    static boolean isImpossible, isOnePossible;
    static StringBuilder sb;
    static int V;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        indegree = new HashMap<>();
        graph = new HashMap<>();
        sArr = new String[N];
        cSet = new HashSet<>();
        for(int i=0;i<N;i++){
            sArr[i] = br.readLine();
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<sArr[i].length();j++){
                if(!graph.containsKey(sArr[i].charAt(j))){
                    graph.put(sArr[i].charAt(j),new ArrayList<>());
                    indegree.put(sArr[i].charAt(j),0);
                }
            }
        }
        isImpossible = false;

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                check(sArr[i],sArr[j],0);
            }
        }
        V = graph.size();

        isOnePossible = true;
        sb= new StringBuilder();

        if (!isImpossible) {
            topologicalSrot();
        }

        if(isImpossible){
            System.out.println('!');
        }else{
            if(isOnePossible)
                System.out.println(sb);
            else{
                System.out.println("?");
            }

        }

    }
    static void topologicalSrot(){
        Deque <Character> deque = new ArrayDeque<>();
        for(char key : graph.keySet()){
            if(indegree.get(key) == 0){
                deque.add(key);
            }
        }
        int count= 0;
        while(!deque.isEmpty()){
            if(deque.size()>1)
                isOnePossible = false;
            char c = deque.poll();
            count ++;
            sb.append(c);
            if (graph.get(c) != null) {
                for(char newC : graph.get(c)){
                    int val = indegree.get(newC);
                    val --;
                    indegree.put(newC, val);
                    if (val == 0){
                        deque.add(newC);
                    }
                }
            }
        }
        if(count != V)
            isImpossible = true;

    }

    static void check(String s1, String s2,int idx){ // s1은 s2보다 사전적으로 빠름
        if (s1.length() > s2.length() && s1.startsWith(s2)) {
            isImpossible = true;
            return;
        }
        if(s1.length() <= idx || s2.length() <=idx)
            return;
        char c1 = s1.charAt(idx);
        char c2 = s2.charAt(idx);
        if(c1 != c2){
            String c = c1+"-"+c2;
            if(cSet.contains(c))
                return;
            else{
                cSet.add(c);
                graph.get(c1).add(c2);
                int val = indegree.get(c2);
                indegree.put(c2,val+1);
            }
            return;
        }
        else{
            check(s1,s2,idx+1);
        }
    }
}
