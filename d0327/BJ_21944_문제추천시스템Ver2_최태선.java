package d0327;

import java.io.*;
import java.util.*;

public class BJ_21944_문제추천시스템Ver2_최태선 {
    static int N,M;
    static TreeSet<int[]> treeSet; // 문제번호, 문제난이도 셋
    static TreeSet<int[]>[] algoSet;
    static HashMap<Integer,Integer> map; // 문제번호 -> 문제난이도 
    static HashMap<Integer,Integer> algoMap;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        treeSet = new TreeSet<>((a,b)->{
            if(a[1] == b[1])
                return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(a[1], b[1]);
        });
        map = new HashMap<>();
        algoMap = new HashMap<>();
        algoSet = new TreeSet[101];
        for(int i=1;i<101;i++){
            algoSet[i] = new TreeSet<>((a,b)->{
                if(a[1] == b[1])
                    return Integer.compare(a[0], b[0]);
                else
                    return Integer.compare(a[1], b[1]);
            });
        }
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            treeSet.add(new int[]{P,L});
            algoSet[R].add(new int[]{P,L});
            map.put(P,L);
            algoMap.put(P,R);
        }
        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String order = st.nextToken();
            if(order.equals("add")){
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                treeSet.add(new int[]{P,L});
                algoSet[R].add(new int[]{P,L});
                map.put(P,L);
                algoMap.put(P,R);
            }else if(order.equals("recommend")){
                int algoNum = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                if(x ==1){
                    System.out.println(algoSet[algoNum].last()[0]);
                }else{
                    System.out.println(algoSet[algoNum].first()[0]);
                }
            }
            else if (order.equals("recommend2")){
                int x = Integer.parseInt(st.nextToken());
                int[] nowNode;
                if(x == 1){
                    nowNode = treeSet.last();
                }else{
                    nowNode = treeSet.first();
                }
                int problem = nowNode[0];
                System.out.println(problem);
            }else if(order.equals("recommend3")){
                int x = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int[] nowNode;
                if(x ==1){
                    if(treeSet.ceiling(new int[]{0,l})!= null){
                        nowNode = treeSet.ceiling(new int[]{0,l});
                        System.out.println(nowNode[0]);
                    }else{
                        System.out.println(-1);
                    }
                }else{
                    if(treeSet.floor(new int[]{0,l})!= null){
                        nowNode = treeSet.floor(new int[]{0,l});
                        System.out.println(nowNode[0]);
                    }else{
                        System.out.println(-1);
                    }
                }
            }
            else if (order.equals("solved")){
                int P = Integer.parseInt(st.nextToken());
                int nan = map.get(P);
                int algoNum = algoMap.get(P);
                map.remove(P);
                treeSet.remove(new int[]{P,nan});
                algoSet[algoNum].remove(new int[]{P,nan});
            }
        }
    }
}
