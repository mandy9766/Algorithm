package d0321;

import java.io.*;
import java.util.*;

public class BJ_7662_이중우선순위큐_최태선 {
    static int T;
    static int K;
    static TreeMap<Integer,Integer> treeMap;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            K = Integer.parseInt(br.readLine());
            treeMap = new TreeMap<>();
            for(int k=0;k<K;k++){
                StringTokenizer st= new StringTokenizer(br.readLine()," ");
                if(st.nextToken().equals("I")){
                    int num = Integer.parseInt(st.nextToken());
                    if(treeMap.containsKey(num)){
                        int count = treeMap.get(num);
                        treeMap.put(num,count+1);
                    }else
                    {
                        treeMap.put(num,1);
                    }
                }
                else{
                    if(treeMap.isEmpty())
                        continue;
                    else{
                        if(st.nextToken().equals("1"))
                        {
                            int nowKey = treeMap.lastKey();
                            int count = treeMap.get(nowKey);
                            if(count>1)
                                treeMap.put(nowKey,count-1);
                            else
                                treeMap.remove(nowKey);
                        }
                        else{
                            int nowKey = treeMap.firstKey();
                            int count = treeMap.get(nowKey);
                            if(count>1)
                                treeMap.put(nowKey,count-1);
                            else
                                treeMap.remove(nowKey);
                        }
                    }
                }
            }
            if(treeMap.isEmpty())
                System.out.println("EMPTY");
            else
                System.out.println(treeMap.lastKey()+" "+treeMap.firstKey());
        }
    }
}
