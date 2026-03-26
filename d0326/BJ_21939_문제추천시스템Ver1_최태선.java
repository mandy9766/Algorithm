package d0326;

import java.io.*;
import java.util.*;

public class BJ_21939_문제추천시스템Ver1_최태선 {
    static int N,M;
    static TreeSet<int[]> treeSet; // 문제번호, 문제난이도 셋
    static HashMap<Integer,Integer> map; // 문제번호 -> 문제난이도 
    
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
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            treeSet.add(new int[]{P,L});
            map.put(P,L);
        }
        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String order = st.nextToken();
            if(order.equals("add")){
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                treeSet.add(new int[]{P,L});
                map.put(P,L);
            }else if (order.equals("recommend")){
                int x = Integer.parseInt(st.nextToken());
                int[] nowNode;
                if(x == 1){
                    nowNode = treeSet.last();
                }else{
                    nowNode = treeSet.first();
                }
                int problem = nowNode[0];
                System.out.println(problem);
            }else{
                int P = Integer.parseInt(st.nextToken());
                int nan = map.get(P);
                map.remove(P);
                treeSet.remove(new int[]{P,nan});
            }
        }
    }
}
