package m05.d0521;

import java.util.StringTokenizer;
import java.util.TreeMap;

public class PG_이중우선순위큐_최태선 {
    TreeMap<Integer,Integer> treeMap;
    int size;
    public int[] solution(String[] operations) {
        treeMap = new TreeMap<>();
        size = operations.length;
        for(int i=0;i<size;i++){
            StringTokenizer st = new StringTokenizer(operations[i]," ");
            if(st.nextToken().equals("I")){
                int nowNum = Integer.parseInt(st.nextToken());
                treeMap.put(nowNum,treeMap.getOrDefault(nowNum,0)+1);
            }else{
                if(treeMap.isEmpty())
                        continue;
                int nowNum;
                if(st.nextToken().equals("-1")){ // 최소값 삭제       
                    nowNum = treeMap.firstKey();
                }else{ // 최대값 삭제
                    nowNum = treeMap.lastKey();
                }
                if(treeMap.get(nowNum) == 1){
                    treeMap.remove(nowNum);
                }else{
                    treeMap.put(nowNum,treeMap.get(nowNum)-1);
                }
            }
        }
        if(treeMap.isEmpty()){
            return new int[]{0,0};
        }else{
            int perv = treeMap.firstKey();
            int next = treeMap.lastKey();
            return new int[]{next,perv};
        }
    }
}
